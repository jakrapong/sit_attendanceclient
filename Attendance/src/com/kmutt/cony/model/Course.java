package com.kmutt.cony.model;

import java.util.List;

public class Course {
	private Integer courseId;
    private String courseName;
    private String description;
    private List<Group>groups;
    public Course(){}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", subject=" + courseName
				+ ", description=" + description + "]";
	}
    
}
