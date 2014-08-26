package com.kmutt.cony.api;

import java.util.ArrayList;

import com.kmutt.cony.model.ClassModel;

public class AttendanceAPI {
	private AttendanceAPI(){}
	private static AttendanceAPI sAttendanceAPI;
	private String mUserName,mPassword;
	public static AttendanceAPI getInstance(){
		if(sAttendanceAPI == null){
			sAttendanceAPI = new AttendanceAPI();
		}
		return sAttendanceAPI;
	}
	
	private void setCredentail(String username,String password){
		mUserName = username;
		mPassword = password;
	}
	
	public ArrayList<ClassModel> getClassList() throws Exception{
		//TODO: if respone status is not equals to "200" then throw new exception with error code
		//if (status == 401) throw new Exception("401");
		return null;
	}
	
}
