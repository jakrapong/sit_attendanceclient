package com.kmutt.cony.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kmutt.cony.api.AttendanceAPIZombie;
import com.kmutt.cony.model.zombie.AttendanceResult;
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
			mAttendanceAPI.setCredentail("user8","sally").getMyInfo();
		} catch (Exception e) {
			Assert.assertEquals("401",e.getMessage());
		}
	}
	@Test
	public void testCallApiCorrectAuthentication(){
		try {
			mAttendanceAPI.setCredentail("user8","qwe123").getMyInfo();
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
			mAttendanceAPI.setCredentail("user8","qwe123").getMyInfo();
		}catch(Exception ex){
			ex.printStackTrace();
			Assert.fail();
		}
		
		Assert.assertTrue(mAttendanceAPI.isLogin());
	}
	
	@Test
	public void testRestoreUser(){
		try{
			mAttendanceAPI.setCredentail("user8","qwe123").getMyInfo();
			Assert.assertTrue(mAttendanceAPI.restoreUser());
		}catch(Exception ex){
			ex.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testLogout(){
		try{
			mAttendanceAPI.setCredentail("user8","qwe123").getMyInfo();
		}catch(Exception ex){
			ex.printStackTrace();
			Assert.fail();
		}
		
		Assert.assertTrue(mAttendanceAPI.isLogin());
		mAttendanceAPI.logout();
		Assert.assertFalse(mAttendanceAPI.isLogin());
	}
	
	@Test
	public void testGetMyInfo(){
		User user=null;
		try{
			user=mAttendanceAPI.setCredentail("user8","qwe123").getMyInfo();
		}catch(Exception ex){
			ex.printStackTrace();
			Assert.fail();
		}
		Assert.assertNotNull(user);
		Assert.assertEquals("ADDDress", user.getAddress());
		Assert.assertEquals("Zapata@gmail.com", user.getEmail());
		Assert.assertEquals("www.facebook.com", user.getFacebook());
		Assert.assertEquals("Carlos", user.getFirstName());
		Assert.assertEquals(User.GENDER_MALE, user.getGender());
		Assert.assertEquals("Zapata", user.getLastName());
		Assert.assertEquals("12345788", user.getPhoneNumber());
		Assert.assertEquals("http://gala.ie.st/face.png", user.getPhoto());
		Assert.assertEquals("www.twitter.com", user.getTwitter());
		
		Assert.assertEquals(User.TYPE_INSTRUCTOR, user.getType());
	}
	@Test
	public void testGetCourseList() throws Exception{
		List<Course>list=null;
		try{
			list=mAttendanceAPI.setCredentail("user8","qwe123").getCourseList();
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}
		Assert.assertNotNull(list);
		Assert.assertEquals(2, list.size());
		
		Course c1 = list.get(0);
		Assert.assertEquals(1, c1.getCourseId());
		Assert.assertEquals("DSD", c1.getCourseName());
		Assert.assertEquals("2014-1", c1.getCourseSemester());
		Assert.assertEquals(1, c1.getGroups().size());
		
		Groups c1g1 = c1.getGroups().get(0);
		Assert.assertEquals(1, c1g1.getGroupId());
		Assert.assertEquals("Group of DSD in COlombia", c1g1.getDescription());
		
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
		List<com.kmutt.cony.model.zombie.Class>list=null;
		try{
			list=mAttendanceAPI.setCredentail("user8","qwe123").getClassSchedule(1);
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}
		Assert.assertNotNull(list);
		Assert.assertEquals(3, list.size());
		
		com.kmutt.cony.model.zombie.Class c1 = list.get(0);
//		Assert.assertEquals(1411230105, c1.getDatetimeSeconds());
		Assert.assertEquals(1, c1.getClassId());
		Assert.assertEquals(2, c1.getPeriod());
		Assert.assertEquals("M8-102", c1.getClassRoom());
		
		com.kmutt.cony.model.zombie.Class c2 = list.get(1);
//		Assert.assertEquals(1411834905, c2.getDatetimeSeconds());
		Assert.assertEquals(2, c2.getClassId());
		Assert.assertEquals(2, c2.getPeriod());
		Assert.assertEquals("M8-102", c2.getClassRoom());
		
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
		List<StudentAttendance> classScd=null;
		try{
			classScd=mAttendanceAPI.setCredentail("user8","qwe123").getClassScheduleCheckIn(1,1);
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}
		
		Assert.assertNotNull(classScd);
		Assert.assertEquals(4, classScd.size());
		
		StudentAttendance s1 = classScd.get(0);
		Assert.assertEquals(StudentAttendance.STATUS_PRESENT, s1.getCheckInStatus());
		Assert.assertEquals(User.GENDER_MALE, s1.getStudent().getGender());
		Assert.assertEquals(1, s1.getStudent().getUserId());
		Assert.assertEquals("ADDDress", s1.getStudent().getAddress());
		Assert.assertEquals("scarmonar@gmail.com", s1.getStudent().getEmail());
		Assert.assertEquals("www.facebook.com", s1.getStudent().getFacebook());
		Assert.assertEquals("Santiago", s1.getStudent().getFirstName());
		Assert.assertEquals("Carmona", s1.getStudent().getLastName());
		Assert.assertEquals("12345788", s1.getStudent().getPhoneNumber());
		Assert.assertEquals("http://gala.ie.st/face.png", s1.getStudent().getPhoto());
		Assert.assertEquals("www.twitter.com", s1.getStudent().getTwitter());
		
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
			list=mAttendanceAPI.setCredentail("user8","qwe123").getStudentList(2);
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}
		Assert.assertNotNull(list);
		
		Assert.assertEquals(3, list.size());
		
		StudentStat s1 = list.get(0);
		
		Assert.assertEquals(User.GENDER_MALE, s1.getGender());
		Assert.assertEquals(5, s1.getUserId());
		Assert.assertEquals("ADDDress", s1.getAddress());
		Assert.assertEquals("Jakaprong@gmail.com", s1.getEmail());
		Assert.assertEquals("www.facebook.com", s1.getFacebook());
		Assert.assertEquals("Pandez", s1.getFirstName());
		Assert.assertEquals("Jakaprong", s1.getLastName());
		Assert.assertEquals("12345788", s1.getPhoneNumber());
		Assert.assertEquals("http://gala.ie.st/face.png", s1.getPhoto());
		Assert.assertEquals("www.twitter.com", s1.getTwitter());
		Assert.assertEquals(1, s1.getAbsent());
		Assert.assertEquals(1, s1.getLate());
		Assert.assertEquals(1, s1.getPresent());
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
			user=mAttendanceAPI.setCredentail("user8","qwe123").getStudentInfo(1, 1);
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getStudent());
		Assert.assertNotNull(user.getStatistic());
		Assert.assertNotNull(user.getAttendance());
		
		
		Assert.assertEquals("Santiago", user.getStudent().getFirstName());
		Assert.assertEquals(User.GENDER_MALE, user.getStudent().getGender());
		Assert.assertEquals(1, user.getStudent().getUserId());
		Assert.assertEquals("ADDDress", user.getStudent().getAddress());
		Assert.assertEquals("scarmonar@gmail.com", user.getStudent().getEmail());
		Assert.assertEquals("www.facebook.com", user.getStudent().getFacebook());
		Assert.assertEquals("Santiago", user.getStudent().getFirstName());
		Assert.assertEquals("Carmona", user.getStudent().getLastName());
		Assert.assertEquals("12345788", user.getStudent().getPhoneNumber());
		Assert.assertEquals("http://gala.ie.st/face.png", user.getStudent().getPhoto());
		Assert.assertEquals("www.twitter.com", user.getStudent().getTwitter());
		
		
		Assert.assertEquals(1, user.getStatistic().getPresent());
		Assert.assertEquals(1, user.getStatistic().getAbsent());
		Assert.assertEquals(1, user.getStatistic().getLate());
		
		Assert.assertEquals(3, user.getAttendance().size());
//		Assert.assertEquals(1411230105, user.getAttendance().get(0).getClazz().getDatetimeSeconds());
		
		com.kmutt.cony.model.zombie.Class c1 = user.getAttendance().get(0).getClazz();
//		Assert.assertEquals(1411230105, c1.getDatetimeSeconds());
		Assert.assertEquals(1, c1.getClassId());
		Assert.assertEquals(2, c1.getPeriod());
		Assert.assertEquals("M8-102", c1.getClassRoom());
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
		com.kmutt.cony.model.zombie.Class _class=null;
		try{
			_class=mAttendanceAPI.setCredentail("user8","qwe123").getCurrentClassSchedule(1412578792);
			
			
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}
		
		Assert.assertNotNull(_class);
	}
	
	@Test
	public void getCurrentClassSchedule_TimeBetweenClass()throws Exception{
		com.kmutt.cony.model.zombie.Class _class=null;
		try{
			_class=mAttendanceAPI.setCredentail("user8","qwe123").getCurrentClassSchedule(1412578795);
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}
		
		Assert.assertNotNull(_class);
	}

	@Test
	public void getUpdateStatus()throws Exception{
		
		StudentAttendanceEntry st1 = new StudentAttendanceEntry();
		st1.setClassId(1);
		st1.setUserId(1);
		st1.setStatus(StudentAttendance.STATUS_PRESENT);
		
		StudentAttendanceEntry st2 = new StudentAttendanceEntry();
		st2.setClassId(1);
		st2.setUserId(2);
		st2.setStatus(StudentAttendance.STATUS_ABSENCE);
		
		StudentAttendanceEntry st3 = new StudentAttendanceEntry();
		st3.setClassId(1);
		st3.setUserId(3);
		st3.setStatus(StudentAttendance.STATUS_LATT);
		
		ArrayList<StudentAttendanceEntry> stList = new ArrayList<StudentAttendanceEntry>();
		stList.add(st1);
		stList.add(st2);
		stList.add(st3);
		
		try{
			AttendanceResult result = mAttendanceAPI.setCredentail("user8","qwe123").updateStudentCheckInStatus(stList);
			
			Assert.assertNotNull(result);
			Assert.assertTrue(result.getStatistic().getAbsent() >= 1);
			Assert.assertTrue(result.getStatistic().getPresent() >= 1);
			Assert.assertTrue(result.getStatistic().getLate() >= 1);
			
			st1.setStatus(StudentAttendance.STATUS_PRESENT);
			st2.setStatus(StudentAttendance.STATUS_PRESENT);
			st3.setStatus(StudentAttendance.STATUS_PRESENT);
			
			result = mAttendanceAPI.setCredentail("user8","qwe123").updateStudentCheckInStatus(stList);
			
			Assert.assertNotNull(result);
			Assert.assertTrue(result.getStatistic().getPresent() >= 3);
			
			
		
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}
		
	}
}
