package com.kmutt.cony.model;

import java.util.Date;
import java.util.List;

public class ClassSchedule {
	private Integer classScheduleId;
    private Date dateTime;
    private Integer period;
    private String description;
    private List<TimeAttendance>timeAttendance;
    private Integer courseId;
    private Integer groupId;
    private Group group;
    public ClassSchedule(){}
	public Integer getClassScheduleId() {
		return classScheduleId;
	}
	public void setClassScheduleId(Integer classScheduleId) {
		this.classScheduleId = classScheduleId;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<TimeAttendance> getTimeAttendance() {
		return timeAttendance;
	}
	public void setTimeAttendance(List<TimeAttendance> timeAttendance) {
		this.timeAttendance = timeAttendance;
	}
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
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	@Override
	public String toString() {
		return "ClassSchedule [classScheduleId=" + classScheduleId
				+ ", dateTime=" + dateTime + ", period=" + period
				+ ", description=" + description + ", timeAttendance="
				+ timeAttendance + ", courseId=" + courseId + ", groupId="
				+ groupId + "]";
	}
    
}
