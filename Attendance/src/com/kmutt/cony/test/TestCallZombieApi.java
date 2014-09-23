package com.kmutt.cony.test;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kmutt.cony.api.AttendanceAPIZombie;
import com.kmutt.cony.model.zombie.Course;
import com.kmutt.cony.model.zombie.Instructor;
import com.kmutt.cony.model.zombie.StudentAttendance;
import com.kmutt.cony.model.zombie.StudentInfo;
import com.kmutt.cony.model.zombie.StudentStat;

public class TestCallZombieApi{
	AttendanceAPIZombie mAttendanceAPI;
	@Before
	public void init(){
		mAttendanceAPI = AttendanceAPIZombie.getInstance();
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
	public void testGetMyInfo(){
		Instructor user=null;
		try{
			user=mAttendanceAPI.setCredentail("user8","qwe123").getMyInfo();
		}catch(Exception ex){
			ex.printStackTrace();
			Assert.fail();
		}
		Assert.assertNotNull(user);
		System.out.println("FirstName:"+user.getFirstName());
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
	}
	
	@Test
	public void testGetStudentList() throws Exception{
		List<StudentStat>list=null;
		try{
			list=mAttendanceAPI.setCredentail("user8","qwe123").getStudentList(1);
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}
		Assert.assertNotNull(list);
		Assert.assertEquals(4, list.size());
	}
	@Test
	public void testStudentInfo() throws Exception{
		StudentInfo user=null;
		try{
			user=mAttendanceAPI.setCredentail("user8","qwe123").getStudentInfo(1, "1");
		}catch(Exception ex){
			System.out.print(ex);
			Assert.fail();
		}
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getStudent());
		Assert.assertNotNull(user.getStatistic());
		Assert.assertNotNull(user.getAttendance());
		
		System.out.println(ToStringBuilder.reflectionToString(user.getAttendance().get(0),ToStringStyle.MULTI_LINE_STYLE));
		
		Assert.assertEquals("Santiago", user.getStudent().getFirstName());
		Assert.assertEquals(1, user.getStatistic().getPresent());
		
		Assert.assertEquals(3, user.getAttendance().size());
		Assert.assertEquals(1411230105, user.getAttendance().get(0).getClazz().getDatetimeSeconds());
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
