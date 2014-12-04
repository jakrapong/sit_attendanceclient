
package com.kmutt.cony.model.zombie;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable{
   	private int courseId;
   	private String courseName;
   	private String courseSemester;
   	private List<Groups> groups;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseSemester() {
		return courseSemester;
	}
	public void setCourseSemester(String courseSemester) {
		this.courseSemester = courseSemester;
	}
	public List<Groups> getGroups() {
		return groups;
	}
	public void setGroups(List<Groups> groups) {
		this.groups = groups;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName
				+ ", courseSemester=" + courseSemester + ", groups=" + groups
				+ "]";
	}
	
   	
}
