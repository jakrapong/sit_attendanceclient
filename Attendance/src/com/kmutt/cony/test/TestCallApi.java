package com.kmutt.cony.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kmutt.cony.api.AttendanceAPI;
import com.kmutt.cony.model.ClassSchedule;
import com.kmutt.cony.model.Course;
import com.kmutt.cony.model.Statistic;
import com.kmutt.cony.model.Student;
import com.kmutt.cony.model.User;

public class TestCallApi{
	AttendanceAPI mAttendanceAPI;
	@Before
	public void init(){
		mAttendanceAPI = AttendanceAPI.getInstance();
	}
	
	@Test
	public void testCallApiWithoutAuthentication(){
		try {
			mAttendanceAPI.getMyInfo();
		} catch (Exception e) {
			Assert.assertEquals("403",e.getMessage());
		}
	}
	@Test
	public void testCallApiWithAuthenticationPasswordMismatch(){
		try {
			mAttendanceAPI.setCredentail("kmutt","sally").getMyInfo();
		} catch (Exception e) {
			Assert.assertEquals("401",e.getMessage());
		}
	}
	@Test
	public void testGetMyInfo(){
		User user=null;
		try{
			user=mAttendanceAPI.setCredentail("kmutt","cony").getMyInfo();
		}catch(Exception ex){}
		Assert.assertNotNull(user);
	}
	@Test
	public void testGetCourseList() throws Exception{
		List<Course>list=null;
		try{
			list=mAttendanceAPI.setCredentail("kmutt","cony").getCourseList();
		}catch(Exception ex){}
		Assert.assertNotNull(list);
	}
	@Test
	public void testGetClassSchedule() throws Exception{
		List<ClassSchedule>list=null;
		try{
			list=mAttendanceAPI.setCredentail("kmutt","cony").getClassSchedule(1);
		}catch(Exception ex){}
		Assert.assertNotNull(list);
	}
	@Test
	public void testGetClassScheduleCheckIn() throws Exception{
		ClassSchedule classScd=null;
		try{
			classScd=mAttendanceAPI.setCredentail("kmutt","cony").getClassScheduleCheckIn(1,1);
		}catch(Exception ex){}
		Assert.assertNotNull(classScd);
	}
	@Test
	public void testGetStudentList() throws Exception{
		List<Statistic>list=null;
		try{
			list=mAttendanceAPI.setCredentail("kmutt","cony").getStudentList(1);
		}catch(Exception ex){}
		Assert.assertNotNull(list);
	}
	@Test
	public void testGetStudentListWith2Param() throws Exception{
		Statistic student=null;
		try{
			student=mAttendanceAPI.setCredentail("kmutt","cony").getStudentInfo("S0001",1);
		}catch(Exception ex){}
		Assert.assertNotNull(student);
	}
	@Test
	public void testGetStudentListWith1Param() throws Exception{
		Student student=null;
		try{
			student=mAttendanceAPI.setCredentail("kmutt","cony").getStudentInfo("S0001");
		}catch(Exception ex){}
		Assert.assertNotNull(student);
	}
	@Test
	public void testGetCurrentClassSchedule() throws Exception{
		ClassSchedule classScd=null;
		try{
			classScd=mAttendanceAPI.setCredentail("kmutt","cony").getCurrentClassSchedule("09092014","1600");
		}catch(Exception ex){}
		Assert.assertNotNull(classScd);
	}
	@Test
	public void testGetCurrentClassScheduleWithNoClass() throws Exception{
		ClassSchedule classScd=null;
		try{
			classScd=mAttendanceAPI.setCredentail("kmutt","cony").getCurrentClassSchedule("09092014","0000");
		}catch(Exception ex){}
		Assert.assertNull(classScd);
	}
	@Test
	public void testGetUserInfo() throws Exception{
		User user=null;
		try{
			user=mAttendanceAPI.setCredentail("kmutt","cony").getUserInfo("1");
		}catch(Exception ex){}
		Assert.assertNotNull(user);
	}
}
