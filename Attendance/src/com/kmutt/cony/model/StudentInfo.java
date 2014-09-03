package com.kmutt.cony.model;

import java.util.List;

public class StudentInfo {
	private User student;
	private StudentStatistic statistic;
	private List<StudentCheckIn> attendance;
	private List<Group> groupRegistered;
	
	public StudentInfo() {
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public StudentStatistic getStatistic() {
		return statistic;
	}
	public void setStatistic(StudentStatistic statistic) {
		this.statistic = statistic;
	}
	public List<StudentCheckIn> getAttendance() {
		return attendance;
	}
	public void setAttendance(List<StudentCheckIn> attendance) {
		this.attendance = attendance;
	}
	public List<Group> getGroupRegistered() {
		return groupRegistered;
	}
	public void setGroupRegistered(List<Group> groupRegistered) {
		this.groupRegistered = groupRegistered;
	}
	@Override
	public String toString() {
		return "StudentInfo [student=" + student + ", statistic=" + statistic
				+ ", attendance=" + attendance + ", groupRegistered="
				+ groupRegistered + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attendance == null) ? 0 : attendance.hashCode());
		result = prime * result
				+ ((groupRegistered == null) ? 0 : groupRegistered.hashCode());
		result = prime * result
				+ ((statistic == null) ? 0 : statistic.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentInfo other = (StudentInfo) obj;
		if (attendance == null) {
			if (other.attendance != null)
				return false;
		} else if (!attendance.equals(other.attendance))
			return false;
		if (groupRegistered == null) {
			if (other.groupRegistered != null)
				return false;
		} else if (!groupRegistered.equals(other.groupRegistered))
			return false;
		if (statistic == null) {
			if (other.statistic != null)
				return false;
		} else if (!statistic.equals(other.statistic))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}
	
	
}
