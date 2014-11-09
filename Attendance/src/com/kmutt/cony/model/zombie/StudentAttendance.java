
package com.kmutt.cony.model.zombie;

import java.io.Serializable;

public class StudentAttendance  implements Serializable{
	
	public static int STATUS_NA = 0;
	public static int STATUS_PRESENT = 1;
	public static int STATUS_LATE = 2;
	public static int STATUS_ABSENCE = 3;
	
   	private int checkInStatus;
   	private User student;

 	public int getCheckInStatus(){
		return this.checkInStatus;
	}
	public void setCheckInStatus(int checkInStatus){
		this.checkInStatus = checkInStatus;
	}
 	public User getStudent(){
		return this.student;
	}
	public void setStudent(User student){
		this.student = student;
	}
	public StudentAttendanceEntry toStudentAttendanceEntry(int classId){
		return new StudentAttendanceEntry(student.getUserId(),checkInStatus,classId);
	}
	@Override
	public String toString() {
		return "StudentAttendance [checkInStatus=" + checkInStatus
				+ ", student=" + student + "]";
	}
	
}
