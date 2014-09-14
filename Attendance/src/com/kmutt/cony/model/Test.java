package com.kmutt.cony.model;

import com.kmutt.cony.api.AttendanceAPI;

public class Test {
	public static void main(String args[]){
		String json="{\"classScheduleId\":1,\"dateTime\":\"2014-09-14 11:46 -+0000\",\"period\":2,\"description\":\"class at Sun Sep 14 11:46:26 UTC 2014\",\"timeAttendance\":[{\"studentId\":\"S0001\",\"status\":2,\"checkInTime\":\"2014-09-14 11:46 -+0000\",\"student\":{\"userId\":\"S0001\",\"lastName\":\"last_name_S0001\",\"firstName\":\"first_name_S0001\",\"gender\":false,\"address\":\"address_S0001\",\"phoneNumber\":\"0694186716\",\"photo\":\"http://kmutt.cony/S0001.png\"}},{\"studentId\":\"S0002\",\"status\":1,\"checkInTime\":\"2014-09-14 11:46 -+0000\",\"student\":{\"userId\":\"S0002\",\"lastName\":\"last_name_S0002\",\"firstName\":\"first_name_S0002\",\"gender\":false,\"address\":\"address_S0002\",\"phoneNumber\":\"0946184264\",\"photo\":\"http://kmutt.cony/S0002.png\"}},{\"studentId\":\"S0003\",\"status\":1,\"checkInTime\":\"2014-09-14 11:46 -+0000\",\"student\":{\"userId\":\"S0003\",\"lastName\":\"last_name_S0003\",\"firstName\":\"first_name_S0003\",\"gender\":false,\"address\":\"address_S0003\",\"phoneNumber\":\"0180240309\",\"photo\":\"http://kmutt.cony/S0003.png\"}},{\"studentId\":\"S0004\",\"status\":4,\"checkInTime\":\"2014-09-14 11:46 -+0000\",\"student\":{\"userId\":\"S0004\",\"lastName\":\"last_name_S0004\",\"firstName\":\"first_name_S0004\",\"gender\":false,\"address\":\"address_S0004\",\"phoneNumber\":\"0351308948\",\"photo\":\"http://kmutt.cony/S0004.png\"}}]}";
		ClassSchedule cs=AttendanceAPI.GSON.fromJson(json,ClassSchedule.class);
		System.out.print(cs);
	}
}
