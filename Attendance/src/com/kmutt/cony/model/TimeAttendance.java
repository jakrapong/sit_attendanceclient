package com.kmutt.cony.model;

import java.util.Date;

public class TimeAttendance {
	private Integer courseId;
    private Integer groupId;
    private Integer classScheduleId;
    private String studentId;
    private Integer status;
    private Date checkInTime;
    private Group group;
    private Student student;
    private ClassSchedule classSchedule;
    public TimeAttendance(){}
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
	public Integer getClassScheduleId() {
		return classScheduleId;
	}
	public void setClassScheduleId(Integer classScheduleId) {
		this.classScheduleId = classScheduleId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public ClassSchedule getClassSchedule() {
		return classSchedule;
	}
	public void setClassSchedule(ClassSchedule classSchedule) {
		this.classSchedule = classSchedule;
	}
	@Override
	public String toString() {
		return "TimeAttendance [courseId=" + courseId + ", groupId=" + groupId
				+ ", classScheduleId=" + classScheduleId + ", studentId="
				+ studentId + ", status=" + status + ", checkInTime="
				+ checkInTime + "]";
	}
    
}
