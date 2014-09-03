package com.kmutt.cony.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kmutt.cony.api.AttendanceAPI;
import com.kmutt.cony.model.ClassSchedule;
import com.kmutt.cony.model.Course;
import com.kmutt.cony.model.StudentInfo;
import com.kmutt.cony.model.StudentStatistic;
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
	public void testGetStudentList() throws Exception{
		List<StudentStatistic>list=null;
		try{
			list=mAttendanceAPI.setCredentail("kmutt","cony").getStudentList(1);
		}catch(Exception ex){}
		Assert.assertNotNull(list);
	}
	@Test
	public void testGetStudentListWith2Param() throws Exception{
		StudentInfo student=null;
		try{
			student=mAttendanceAPI.setCredentail("kmutt","cony").getStudentInfo("1",1);
		}catch(Exception ex){}
		Assert.assertNotNull(student);
	}
	@Test
	public void testGetStudentListWith1Param() throws Exception{
		StudentInfo student=null;
		try{
			student=mAttendanceAPI.setCredentail("kmutt","cony").getStudentInfo("1");
		}catch(Exception ex){}
		Assert.assertNotNull(student);
	}
}
