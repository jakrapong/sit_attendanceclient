
package com.kmutt.cony.model.zombie;

import java.io.Serializable;



public class Attendance implements Serializable{
   	private int checkInStatus;
   	@com.google.gson.annotations.SerializedName("class")
   	private Class _class;

 	public int getCheckInStatus(){
		return this.checkInStatus;
	}
	public void setCheckInStatus(int checkInStatus){
		this.checkInStatus = checkInStatus;
	}
 	public Class getClazz(){
		return this._class;
	}
	public void setClass(Class _class){
		this._class = _class;
	}
}
