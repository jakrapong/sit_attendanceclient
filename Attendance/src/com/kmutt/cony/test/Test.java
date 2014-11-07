package com.kmutt.cony.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.Gson;
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

public class Test {
	/**
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String[]arg) throws Exception{
		AttendanceAPIZombie m=AttendanceAPIZombie.getInstance().setCredentail("user8","qwe123");
		AttendanceResult atr=m.getAttendanceCache(1);
		System.out.println(atr.getUpdateStatus());
		StudentAttendanceEntry st1 = new StudentAttendanceEntry();
		st1.setClassId(1);
		st1.setUserId(11);
		st1.setStatus(StudentAttendance.STATUS_LATT);
		
		StudentAttendanceEntry st2 = new StudentAttendanceEntry();
		st2.setClassId(1);
		st2.setUserId(12);
		st2.setStatus(StudentAttendance.STATUS_LATT);
		
		StudentAttendanceEntry st3 = new StudentAttendanceEntry();
		st3.setClassId(1);
		st3.setUserId(14);
		st3.setStatus(StudentAttendance.STATUS_LATT);
		
		ArrayList<StudentAttendanceEntry> stList = new ArrayList<StudentAttendanceEntry>();
		stList.add(st1);
		stList.add(st2);
		stList.add(st3);
		System.out.println(m.updateStudentCheckInStatus(stList));
		
		
		
	}
}
