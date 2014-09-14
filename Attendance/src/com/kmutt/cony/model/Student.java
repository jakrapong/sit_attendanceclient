package com.kmutt.cony.model;

import java.util.List;

public class Student extends User{
	private List<Statistic>statistic;
	public Student(){super();}
	public List<Statistic> getStatistic() {
		return statistic;
	}
	public void setStatistic(List<Statistic> statistic) {
		this.statistic = statistic;
	}
	@Override
	public String toString() {
		return "Student [statistic=" + statistic + "]";
	}
	
}
