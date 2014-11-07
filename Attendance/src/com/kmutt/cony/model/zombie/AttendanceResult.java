package com.kmutt.cony.model.zombie;

import java.util.ArrayList;
import java.util.List;

public class AttendanceResult {
	private List<StudentAttendance>updateStatus;
	private Statistic statistic;
	public AttendanceResult(){}
	public AttendanceResult(List<StudentAttendance>updateStatus){
		this.updateStatus=updateStatus;
		calStatistic();
	}
	public List<StudentAttendance> getUpdateStatus() {
		return updateStatus;
	}
	public void setUpdateStatus(List<StudentAttendance> updateStatus) {
		this.updateStatus = updateStatus;
	}
	public Statistic getStatistic() {
		return statistic;
	}
	public void setStatistic(Statistic statistic) {
		this.statistic = statistic;
	}
	public void calStatistic(){
		statistic=new Statistic();
		if(updateStatus==null||updateStatus.isEmpty())return;
		int p=0,l=0,a=0;
		for(StudentAttendance stdAtd:updateStatus){
			if(stdAtd.getCheckInStatus()==StudentAttendance.STATUS_PRESENT)p++;
			else if(stdAtd.getCheckInStatus()==StudentAttendance.STATUS_LATT)l++;
			else if(stdAtd.getCheckInStatus()==StudentAttendance.STATUS_ABSENCE)a++;
		}statistic.setAbsent(a);
		statistic.setLate(l);
		statistic.setPresent(p);
	}
	public void put(AttendanceResult atr){
		List<StudentAttendance>newSta=new ArrayList<StudentAttendance>();
		for(StudentAttendance sta:atr.getUpdateStatus())if(getUpdateStatus(sta.getStudent().getUserId())==null)newSta.add(sta);
		newSta.addAll(atr.getUpdateStatus());
		updateStatus=newSta;
		calStatistic();
	}
	public StudentAttendance getUpdateStatus(int userId){
		if(updateStatus==null||updateStatus.isEmpty())return null;
		for(StudentAttendance sta:updateStatus)if(sta.getStudent().getUserId()==userId)return sta;
		return null;
	}
	@Override
	public String toString() {
		return "AttendanceResult [updateStatus=" + updateStatus
				+ ", statistic=" + statistic + "]";
	}

}
