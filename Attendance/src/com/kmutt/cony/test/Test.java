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
import com.kmutt.cony.model.zombie.Class;
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
		System.out.print(AttendanceAPIZombie.getInstance().setCredentail("user8","qwe123").getCurrentClassSchedule());
		
	}
}
