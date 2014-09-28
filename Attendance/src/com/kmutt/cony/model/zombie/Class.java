
package com.kmutt.cony.model.zombie;

import java.io.Serializable;


public class Class implements Serializable{
   	private int classId;
//   	private Date datetime;
   	private long datetimeSeconds;
   	private int period;
   	private String classRoom;

 	public int getClassId(){
		return this.classId;
	}
	public void setClassId(int classId){
		this.classId = classId;
	}
// 	public Date getDatetime(){
//		return this.datetime;
//	}
//	public void setDatetime(Date datetime){
//		this.datetime = datetime;
//	}
 	public long getDatetimeSeconds(){
		return this.datetimeSeconds;
	}
	public void setDatetimeSeconds(long datetimeSeconds){
		this.datetimeSeconds = datetimeSeconds;
	}
 	public int getPeriod(){
		return this.period;
	}
	public void setPeriod(int period){
		this.period = period;
	}
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
}
