
package com.kmutt.cony.model.zombie;

public class StudentAttendance{
   	private int checkInStatus;
   	private Student student;

 	public int getCheckInStatus(){
		return this.checkInStatus;
	}
	public void setCheckInStatus(int checkInStatus){
		this.checkInStatus = checkInStatus;
	}
 	public Student getStudent(){
		return this.student;
	}
	public void setStudent(Student student){
		this.student = student;
	}
}
