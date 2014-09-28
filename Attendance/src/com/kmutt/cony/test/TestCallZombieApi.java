package com.kmutt.cony.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kmutt.cony.api.AttendanceAPIZombie;
import com.kmutt.cony.model.zombie.Course;
import com.kmutt.cony.model.zombie.Groups;
import com.kmutt.cony.model.zombie.StudentAttendance;
import com.kmutt.cony.model.zombie.StudentInfo;
import com.kmutt.cony.model.zombie.StudentStat;
import com.kmutt.cony.model.zombie.User;

public class TestCallZombieApi{
	AttendanceAPIZombie mAttendanceAPI;
	@Before
	public void init(){
		mAttendanceAPI = AttendanceAPIZombie.getInstance();
		mAttendanceAPI.logout();
	}
	
	@Test
	public void testCallApiWithoutAuthentication(){
		try {
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
	public void testisLogin_false(){
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
//		Assert.assertEquals("", user.getEmail());
		Assert.assertEquals("www.facebook.com", user.getFacebook());
		Assert.assertEquals("Carlos", user.getFirstName());
		Assert.assertEquals(User.GENDER_MALE, user.getGender());
		Assert.assertEquals("Zapata", user.getLastName());
//		Assert.assertEquals("", user.getPhoneNumber());
		Assert.assertEquals("http://gala.ie.st/face.png", user.getPhoto());
		Assert.assertEquals("www.twitter.com", user.getTwitter());
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
		Assert.assertEquals(1411230105, c1.getDatetimeSeconds());
		Assert.assertEquals(1, c1.getClassId());
		Assert.assertEquals(2, c1.getPeriod());
		Assert.assertEquals("M8-102", c1.getClassRoom());
		
		com.kmutt.cony.model.zombie.Class c2 = list.get(1);
		Assert.assertEquals(1411834905, c2.getDatetimeSeconds());
		Assert.assertEquals(2, c2.getClassId());
		Assert.assertEquals(2, c2.getPeriod());
		Assert.assertEquals("M8-102", c2.getClassRoom());
		
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
		Assert.assertEquals(null, s1.getStudent().getEmail());
		Assert.assertEquals("www.facebook.com", s1.getStudent().getFacebook());
		Assert.assertEquals("Santiago", s1.getStudent().getFirstName());
		Assert.assertEquals("Carmona", s1.getStudent().getLastName());
		Assert.assertEquals(null, s1.getStudent().getPhoneNumber());
		Assert.assertEquals("http://gala.ie.st/face.png", s1.getStudent().getPhoto());
		Assert.assertEquals("www.twitter.com", s1.getStudent().getTwitter());
		
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
		Assert.assertEquals(null, s1.getEmail());
		Assert.assertEquals("www.facebook.com", s1.getFacebook());
		Assert.assertEquals("Pandez", s1.getFirstName());
		Assert.assertEquals("Jakaprong", s1.getLastName());
		Assert.assertEquals(null, s1.getPhoneNumber());
		Assert.assertEquals("http://gala.ie.st/face.png", s1.getPhoto());
		Assert.assertEquals("www.twitter.com", s1.getTwitter());
		Assert.assertEquals(1, s1.getAbsent());
		Assert.assertEquals(1, s1.getLate());
		Assert.assertEquals(1, s1.getPresent());
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
		Assert.assertEquals(null, user.getStudent().getEmail());
		Assert.assertEquals("www.facebook.com", user.getStudent().getFacebook());
		Assert.assertEquals("Santiago", user.getStudent().getFirstName());
		Assert.assertEquals("Carmona", user.getStudent().getLastName());
		Assert.assertEquals(null, user.getStudent().getPhoneNumber());
		Assert.assertEquals("http://gala.ie.st/face.png", user.getStudent().getPhoto());
		Assert.assertEquals("www.twitter.com", user.getStudent().getTwitter());
		
		
		Assert.assertEquals(1, user.getStatistic().getPresent());
		Assert.assertEquals(1, user.getStatistic().getAbsent());
		Assert.assertEquals(1, user.getStatistic().getLate());
		
		Assert.assertEquals(3, user.getAttendance().size());
		Assert.assertEquals(1411230105, user.getAttendance().get(0).getClazz().getDatetimeSeconds());
		
		com.kmutt.cony.model.zombie.Class c1 = user.getAttendance().get(0).getClazz();
		Assert.assertEquals(1411230105, c1.getDatetimeSeconds());
		Assert.assertEquals(1, c1.getClassId());
		Assert.assertEquals(2, c1.getPeriod());
		Assert.assertEquals("M8-102", c1.getClassRoom());
	}
	
//	@Test
//	public void testGetRegisteredCourse() throws Exception{
//		List<Course>list=null;
//		try{
//			list=mAttendanceAPI.setCredentail("user8","qwe123").getRegisteredCourse(1);
//		}catch(Exception ex){
//			System.out.print(ex);
//			Assert.fail();
//		}
//		Assert.assertNotNull(list);
//		Assert.assertEquals(4, list.size());
//	}
	
//	@Test
//	public void testGetStudentListWith2Param() throws Exception{
//		Statistic student=null;
//		try{
//			student=mAttendanceAPI.setCredentail("user8","qwe123").getStudentInfo("S0001",1);
//		}catch(Exception ex){}
//		Assert.assertNotNull(student);
//	}
//	@Test
//	public void testGetStudentListWith1Param() throws Exception{
//		Student student=null;
//		try{
//			student=mAttendanceAPI.setCredentail("user8","qwe123").getStudentInfo("S0001");
//		}catch(Exception ex){}
//		Assert.assertNotNull(student);
//	}
//	@Test
//	public void testGetCurrentClassSchedule() throws Exception{
//		ClassSchedule classScd=null;
//		try{
//			classScd=mAttendanceAPI.setCredentail("user8","qwe123").getCurrentClassSchedule("09092014","1600");
//		}catch(Exception ex){}
//		Assert.assertNotNull(classScd);
//	}
//	@Test
//	public void testGetCurrentClassScheduleWithNoClass() throws Exception{
//		ClassSchedule classScd=null;
//		try{
//			classScd=mAttendanceAPI.setCredentail("user8","qwe123").getCurrentClassSchedule("09092014","0000");
//		}catch(Exception ex){}
//		Assert.assertNull(classScd);
//	}

}
