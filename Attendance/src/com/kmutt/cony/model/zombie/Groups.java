
package com.kmutt.cony.model.zombie;

import java.io.Serializable;


public class Groups implements Serializable{
   	private String classroom;
   	private String description;
   	private int groupId;
   	private String subject;

// 	public String getClassroom(){
//		return this.classroom;
//	}
//	public void setClassroom(String classroom){
//		this.classroom = classroom;
//	}
 	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
 	public int getGroupId(){
		return this.groupId;
	}
	public void setGroupId(int groupId){
		this.groupId = groupId;
	}
// 	public String getSubject(){
//		return this.subject;
//	}
//	public void setSubject(String subject){
//		this.subject = subject;
//	}
}
