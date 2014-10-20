
package com.kmutt.cony.model.zombie;

import java.io.Serializable;


public class Class implements Serializable{
	private int status;
   	private int classId;
//   	private Date datetime;
   	private long datetimeSeconds;
   	private String description;
   	private int period;
   	private String classRoom;
   	private Course course;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public long getDatetimeSeconds() {
		return datetimeSeconds;
	}
	public void setDatetimeSeconds(long datetimeSeconds) {
		this.datetimeSeconds = datetimeSeconds;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
   	

}
