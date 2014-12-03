package com.kmutt.cony.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kmutt.cony.api.AttendanceAPIZombie;
import com.kmutt.cony.model.zombie.AttendanceResult;
import com.kmutt.cony.model.zombie.Class;
import com.kmutt.cony.model.zombie.Course;
import com.kmutt.cony.model.zombie.Groups;
import com.kmutt.cony.model.zombie.StudentAttendance;
import com.kmutt.cony.model.zombie.StudentAttendanceEntry;
import com.kmutt.cony.model.zombie.StudentInfo;
import com.kmutt.cony.model.zombie.StudentStat;
import com.kmutt.cony.model.zombie.User;

public class TestCallZombieApi{
	AttendanceAPIZombie mAttendanceAPI;
	@Before
	public void init(){
		mAttendanceAPI = AttendanceAPIZombie.getInstance();
//		mAttendanceAPI.logout();
	}
	@Test
	public void testCallApiWithoutAuthentication(){
		try {
			mAttendanceAPI.logout();
			mAttendanceAPI.getMyInfo();
		} catch (Exception e) {
			Assert.assertEquals("401",e.getMessage());
		}
	}
	@Test
	public void testCallApiWithAuthenticationPasswordMismatch(){
		try {
			mAttendanceAPI.setCredentail("Olarn","olar1").getMyInfo();
		} catch (Exception e) {
			Assert.assertEquals("401",e.getMessage());
		}
	}
	@Test
	public void testCallApiCorrectAuthentication(){
		try {
			mAttendanceAPI.setCredentail("Olarn","olarn1").getMyInfo();
		} catch (Exception e) {
			Assert.fail();
		}
	}
	@Test
	public void testisLogin_false(){
		mAttendanceAPI.logout();
		Assert.assertFalse(mAttendanceAPI.isLogin());
	}
	
	@Test
	public void testisLogin_true(){
		try{
			mAttendanceAPI.setCredentail("Olarn","olarn1").getMyInfo();
		}catch(Exception ex){
			ex.printStackTrace();
			Assert.fail();
		}
		
		Assert.assertTrue(mAttendanceAPI.isLogin());
	}
	
	@Test
	public void testRestoreUser(){
		try{
			mAttendanceAPI.setCredentail("Olarn","olarn1").getMyInfo();
			Assert.assertTrue(mAttendanceAPI.restoreUser());
		}catch(Exception ex){
			ex.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testLogout(){
		try{
			mAttendanceAPI.setCredentail("Olarn","olarn1").getMyInfo();
		}catch(Exception ex){
			ex.printStackTrace();
			Assert.fail();
		}Assert.assertTrue(mAttendanceAPI.isLogin());
		mAttendanceAPI.logout();
		Assert.assertFalse(mAttendanceAPI.isLogin());
	}
	
	@Test
	public void testGetMyInfo(){
		User user=null;
		try{
			user=mAttendanceAPI.setCredentail("Olarn","olarn1").getMyInfo();
		}catch(Exception ex){
			ex.printStackTrace();
			Assert.fail();
		}Assert.assertNotNull(user);
		Assert.assertEquals("olarnr@gmail.com", user.getEmail());
		Assert.assertEquals("Olarn", user.getFirstName());
		Assert.assertEquals(User.GENDER_MALE, user.getGender());
		Assert.assertEquals("Rojanapornpun", user.getLastName());
		Assert.assertEquals(User.TYPE_INSTRUCTOR, user.getType());
	}
	@Test
	public void testGetCourseList() throws Exception{
		List<Course>list=null;
		try{
			list=mAttendanceAPI.setCredentail("Olarn","olarn1").getCourseList();
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}Assert.assertNotNull(list);
		Assert.assertEquals(2, list.size());
		Course c0 = list.get(0);
		Assert.assertEquals(3, c0.getCourseId());
		Assert.assertEquals(1, c0.getGroups().size());
		Groups c0g0 = c0.getGroups().get(0);
		Assert.assertEquals(5, c0g0.getGroupId());
		Course c1 = list.get(1);
		Assert.assertEquals(5, c1.getCourseId());
		Assert.assertEquals(1, c1.getGroups().size());
		Groups c1g0 = c1.getGroups().get(0);
		Assert.assertEquals(7, c1g0.getGroupId());
	}
	
	@Test
	public void testGetCourseListWithCache() throws Exception{
		mAttendanceAPI.logout();
		long t1 = System.currentTimeMillis();
		testGetCourseList();
		long t2 = System.currentTimeMillis();
		testGetCourseList();
		long t3 = System.currentTimeMillis();
		Assert.assertTrue(((t2-t1)/10) > (t3-t2));
		System.out.println("t1:"+t1);
		System.out.println("t2:"+t2);
		System.out.println("t3:"+t3);
	}
	@Test
	public void testGetClassSchedule() throws Exception{
		List<Class>list=null;
		try{
			list=mAttendanceAPI.setCredentail("Olarn","olarn1").getClassSchedule(1);
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}Assert.assertNotNull(list);
		Assert.assertEquals(5, list.size());
		Class c0 = list.get(0);
		Class c1 = list.get(1);
		Class c2 = list.get(2);
		Class c3 = list.get(3);
		Class c4 = list.get(4);
		Assert.assertEquals(1, c0.getClassId());
		Assert.assertEquals(2, c1.getClassId());
		Assert.assertEquals(3, c2.getClassId());
		Assert.assertEquals(4, c3.getClassId());
		Assert.assertEquals(5, c4.getClassId());
	}
	@Test
	public void testGetClassScheduleWithCache() throws Exception{
		mAttendanceAPI.logout();
		long t1 = System.currentTimeMillis();
		testGetClassSchedule();
		long t2 = System.currentTimeMillis();
		testGetClassSchedule();
		long t3 = System.currentTimeMillis();
		Assert.assertTrue(((t2-t1)/10) > (t3-t2));
	}
	@Test
	public void testGetClassScheduleCheckIn() throws Exception{
		List<StudentAttendance>stdAtd=null;
		try{
			stdAtd=mAttendanceAPI.setCredentail("Olarn","olarn1").getClassScheduleCheckIn(22);
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}Assert.assertNotNull(stdAtd);
		Assert.assertEquals(2,stdAtd.size());
		StudentAttendance s0 = stdAtd.get(0);
		Assert.assertEquals(52, s0.getStudent().getUserId());
		StudentAttendance s1 = stdAtd.get(1);
		Assert.assertEquals(63, s1.getStudent().getUserId());
	}
	@Test
	public void testGetClassScheduleCheckInWithCache() throws Exception{
		mAttendanceAPI.logout();
		long t1 = System.currentTimeMillis();
		testGetClassScheduleCheckIn();
		long t2 = System.currentTimeMillis();
		testGetClassScheduleCheckIn();
		long t3 = System.currentTimeMillis();
		Assert.assertTrue(((t2-t1)/10) > (t3-t2));
	}
	@Test
	public void testGetStudentList() throws Exception{
		List<StudentStat>list=null;
		try{
			list=mAttendanceAPI.setCredentail("Olarn","olarn1").getStudentList(5);
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}Assert.assertNotNull(list);
		Assert.assertEquals(3, list.size());
		StudentStat s0 = list.get(0);
		Assert.assertEquals(52, s0.getUserId());
		Assert.assertEquals("Nawapon", s0.getFirstName());
		Assert.assertEquals("Ruttanakhunsang", s0.getLastName());
		StudentStat s1 = list.get(1);
		Assert.assertEquals(62, s1.getUserId());
		Assert.assertEquals("Kingkan", s1.getFirstName());
		Assert.assertEquals("Banyenngam", s1.getLastName());
	}
	@Test
	public void testGetStudentListWithCache() throws Exception{
		mAttendanceAPI.logout();
		long t1 = System.currentTimeMillis();
		testGetStudentList();
		long t2 = System.currentTimeMillis();
		testGetStudentList();
		long t3 = System.currentTimeMillis();
		Assert.assertTrue(((t2-t1)/10) > (t3-t2));
	}
	@Test
	public void testStudentInfo() throws Exception{
		StudentInfo user=null;
		try{
			user=mAttendanceAPI.setCredentail("Olarn","olarn1").getStudentInfo(5,52);
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getStudent());
		Assert.assertNotNull(user.getStatistic());
		Assert.assertNotNull(user.getAttendance());
		Assert.assertEquals("Nawapon", user.getStudent().getFirstName());
		Assert.assertEquals("Ruttanakhunsang", user.getStudent().getLastName());
		Assert.assertEquals(User.GENDER_MALE, user.getStudent().getGender());
		Assert.assertEquals(52, user.getStudent().getUserId());
		Assert.assertEquals(3, user.getStatistic().getPresent());
		Assert.assertEquals(1, user.getStatistic().getAbsent());
		Assert.assertEquals(1, user.getStatistic().getLate());
		Assert.assertEquals(0, user.getStatistic().getNa());
		Assert.assertEquals(5, user.getAttendance().size());
	}
	@Test
	public void testStudentInfoWithCache() throws Exception{	
		mAttendanceAPI.logout();
		long t1 = System.currentTimeMillis();
		testStudentInfo();
		long t2 = System.currentTimeMillis();
		testStudentInfo();
		long t3 = System.currentTimeMillis();
		Assert.assertTrue(((t2-t1)/10) > (t3-t2));
	}
	@Test
	public void getCurrentClassSchedule()throws Exception{
		mAttendanceAPI.logout();
		com.kmutt.cony.model.zombie.Class _class=null;
		try{
			_class=mAttendanceAPI.setCredentail("Olarn","olarn1").getCurrentClassSchedule(1409794200);
		}catch(Exception ex){
			Assert.fail();
		}Assert.assertNotNull(_class);
		mAttendanceAPI.logout();
	}
	
	@Test
	public void getCurrentClassSchedule_TimeBetweenClass()throws Exception{
		mAttendanceAPI.logout();
		com.kmutt.cony.model.zombie.Class _class=null;
		try{
			_class=mAttendanceAPI.setCredentail("Olarn","olarn1").getCurrentClassSchedule(1409804200);
		}catch(Exception ex){
			Assert.fail();
		}Assert.assertNotNull(_class);
		mAttendanceAPI.logout();
	}

	@Test
	public void getUpdateStatus()throws Exception{
		StudentAttendanceEntry st11 = new StudentAttendanceEntry();
		st11.setClassId(21);
		st11.setUserId(52);
		st11.setStatus(StudentAttendance.STATUS_PRESENT);
		StudentAttendanceEntry st12 = new StudentAttendanceEntry();
		st12.setClassId(21);
		st12.setUserId(63);
		st12.setStatus(StudentAttendance.STATUS_PRESENT);
		ArrayList<StudentAttendanceEntry> stList = new ArrayList<StudentAttendanceEntry>();
		stList.add(st11);
		stList.add(st12);
		try{
			AttendanceResult result = mAttendanceAPI.setCredentail("Olarn","olarn1").updateStudentCheckInStatus(stList,true);
			Assert.assertNotNull(result);
			int a=result.getStatistic().getAbsent();
			int p=result.getStatistic().getPresent();
			int l=result.getStatistic().getLate();
			int n=result.getStatistic().getNa();
			Assert.assertTrue(a==0);
			Assert.assertTrue(p==2);
			Assert.assertTrue(l==0);
			Assert.assertTrue(n==0);
			st11.setStatus(StudentAttendance.STATUS_ABSENCE);
			st12.setStatus(StudentAttendance.STATUS_ABSENCE);
			result = mAttendanceAPI.setCredentail("Olarn","olarn1").updateStudentCheckInStatus(stList);
			Assert.assertNotNull(result);
			Assert.assertEquals(a,result.getStatistic().getAbsent());
			Assert.assertEquals(p,result.getStatistic().getPresent());
			Assert.assertEquals(l,result.getStatistic().getLate());
			Assert.assertEquals(n,result.getStatistic().getNa());
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}
	}
	@Test
	public void getUserInfo()throws Exception{
		User user=null;
		try{
			user=mAttendanceAPI.getUserProfile(35);
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}Assert.assertNotNull(user);
		Assert.assertEquals(35,user.getUserId());
		Assert.assertEquals("Carlos", user.getFirstName());
		Assert.assertEquals("Zapata", user.getLastName());
	}
}
