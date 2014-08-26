package com.kmutt.cony.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kmutt.cony.api.AttendanceAPI;
import com.kmutt.cony.model.ClassModel;

public class TestgetClassList{
	AttendanceAPI mAttendanceAPI;
	@Before
	public void init(){
		mAttendanceAPI = AttendanceAPI.getInstance();
	}
	
	@Test
	public void testGetClassList(){
		// GetClassList
		try {
			ArrayList<ClassModel> listClass= mAttendanceAPI.getClassList();
			Assert.assertNotNull(listClass);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}
