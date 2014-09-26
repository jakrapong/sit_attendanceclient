package com.kmutt.cony.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.kmutt.cony.api.AttendanceAPI;

public class Test {
	public static void main(String args[]) throws Exception{
		AttendanceAPI.getInstance().setCredentail("kmutt","cony");
		System.out.print(AttendanceAPI.getInstance().getGroupClasses(1));
	}
}
