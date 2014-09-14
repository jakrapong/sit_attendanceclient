package com.kmutt.cony.model;

import java.util.List;

public class Statistic {
	private Integer courseId;
    private Integer groupId;
    private Integer present;
    private Integer late;
    private Integer absence;
    private Integer unknow;
    private String studentId;
    private Student student;
    private Group group;
    private List<TimeAttendance>timeAttendance;
    public Statistic(){}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getPresent() {
		return present;
	}
	public void setPresent(Integer present) {
		this.present = present;
	}
	public Integer getLate() {
		return late;
	}
	public void setLate(Integer late) {
		this.late = late;
	}
	public Integer getAbsence() {
		return absence;
	}
	public void setAbsence(Integer absence) {
		this.absence = absence;
	}
	public Integer getUnknow() {
		return unknow;
	}
	public void setUnknow(Integer unknow) {
		this.unknow = unknow;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public List<TimeAttendance> getTimeAttendance() {
		return timeAttendance;
	}
	public void setTimeAttendance(List<TimeAttendance> timeAttendance) {
		this.timeAttendance = timeAttendance;
	}
	@Override
	public String toString() {
		return "Statistic [courseId=" + courseId + ", groupId=" + groupId
				+ ", present=" + present + ", late=" + late + ", absence="
				+ absence + ", unknow=" + unknow + ", studentId=" + studentId
				+ ", timeAttendance=" + timeAttendance + "]";
	}
    
}
