
package com.kmutt.cony.model.zombie;

public class StudentAttendance{
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
}
