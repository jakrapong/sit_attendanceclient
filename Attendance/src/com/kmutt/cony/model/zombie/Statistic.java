
package com.kmutt.cony.model.zombie;

import java.util.List;

public class Statistic{
   	private int absent;
   	private int late;
   	private int present;

 	public int getAbsent(){
		return this.absent;
	}
	public void setAbsent(int absent){
		this.absent = absent;
	}
 	public int getLate(){
		return this.late;
	}
	public void setLate(int late){
		this.late = late;
	}
 	public int getPresent(){
		return this.present;
	}
	public void setPresent(int present){
		this.present = present;
	}
}
