
package com.kmutt.cony.model.zombie;

import java.io.Serializable;
import java.util.List;

public class Statistic  implements Serializable{
	private int na;
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
	public int getNa() {
		return na;
	}
	public void setNa(int na) {
		this.na = na;
	}
	@Override
	public String toString() {
		return "Statistic [na=" + na + ", absent=" + absent + ", late=" + late
				+ ", present=" + present + "]";
	}
}
