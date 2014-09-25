
package com.kmutt.cony.model.zombie;

import java.util.List;

public class Course{
   	private int courseId;
   	private String courseName;
   	private List groups;

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
 	public List getGroups(){
		return this.groups;
	}
	public void setGroups(List groups){
		this.groups = groups;
	}
}
