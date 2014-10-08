package com.kmutt.cony.test;

import java.util.ArrayList;
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

public class Test {
	public static void main(String[]arg) throws Exception{

		System.out.print(new Gson().toJson(new StudentAttendanceEntry()));
	}
}
