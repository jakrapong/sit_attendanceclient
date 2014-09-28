
package com.kmutt.cony.model.zombie;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable{
   	private int courseId;
   	private String courseName;
   	private String courseSemester;
   	private List<Groups> groups;

 	public int getCourseId(){
		return this.courseId;
	}
	public void setCourseId(int courseId){
		this.courseId = courseId;
	}
 	public String getCourseName(){
		return this.courseName;
	}
	public void setCourseName(String courseName){
		this.courseName = courseName;
	}
 	public List<Groups> getGroups(){
		return this.groups;
	}
	public void setGroups(List<Groups> groups){
		this.groups = groups;
	}
	public String getCourseSemester() {
		return courseSemester;
	}
	public void setCourseSemester(String courseSemester) {
		this.courseSemester = courseSemester;
	}
}
