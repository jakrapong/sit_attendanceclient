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
//		AttendanceResult atr=m.getAttendanceCache(1);
//		System.out.println(atr.getUpdateStatus());
		
		StudentAttendanceEntry st1 = new StudentAttendanceEntry();
		st1.setClassId(1);
		st1.setUserId(13);
		st1.setStatus(StudentAttendance.STATUS_PRESENT);
//		
		StudentAttendanceEntry st2 = new StudentAttendanceEntry();
		st2.setClassId(1);
		st2.setUserId(12);
		st2.setStatus(StudentAttendance.STATUS_PRESENT);
//		
		StudentAttendanceEntry st3 = new StudentAttendanceEntry();
		st3.setClassId(1);
		st3.setUserId(11);
		st3.setStatus(StudentAttendance.STATUS_PRESENT);
		
		StudentAttendanceEntry st4 = new StudentAttendanceEntry();
		st4.setClassId(1);
		st4.setUserId(14);
		st4.setStatus(StudentAttendance.STATUS_PRESENT);
//		
		ArrayList<StudentAttendanceEntry> stList = new ArrayList<StudentAttendanceEntry>();
		stList.add(st1);
		stList.add(st2);
		stList.add(st3);
		stList.add(st4);
//		System.out.println(m.updateStudentCheckInStatus(stList));
		List<StudentAttendance>listCSCI1=m.getClassScheduleCheckIn(1);
		System.out.println(listCSCI1);
//		
		
	}
}
