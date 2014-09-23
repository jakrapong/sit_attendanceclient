
package com.kmutt.cony.model.zombie;

import java.util.List;

public class StudentInfo{
   	private List<Attendance> attendance;
   	private Statistic statistic;
   	private Student student;

 	public List<Attendance> getAttendance(){
		return this.attendance;
	}
	public void setAttendance(List<Attendance> attendance){
		this.attendance = attendance;
	}
 	public Statistic getStatistic(){
		return this.statistic;
	}
	public void setStatistic(Statistic statistic){
		this.statistic = statistic;
	}
 	public Student getStudent(){
		return this.student;
	}
	public void setStudent(Student student){
		this.student = student;
	}
}
