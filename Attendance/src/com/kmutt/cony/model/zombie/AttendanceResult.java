package com.kmutt.cony.model.zombie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.net.ssl.SSLEngineResult.Status;

public class AttendanceResult {
	private List<StudentAttendanceEntry>updateStatus;
	private Statistic statistic;
	public AttendanceResult(){}
	public AttendanceResult(List<StudentAttendance>updateStatus,int classId){
		this.updateStatus=new ArrayList<StudentAttendanceEntry>();
		for(StudentAttendance stdAtd:updateStatus)this.updateStatus.add(stdAtd.toStudentAttendanceEntry(classId));
		calStatistic();
	}
	public List<StudentAttendanceEntry> getUpdateStatus() {
		return updateStatus;
	}
	public void setUpdateStatus(List<StudentAttendanceEntry> updateStatus) {
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
		int p=0,l=0,a=0,na=0;
		for(StudentAttendanceEntry entry:updateStatus){
			if(entry.getStatus()==StudentAttendance.STATUS_PRESENT)p++;
			else if(entry.getStatus()==StudentAttendance.STATUS_LATE)l++;
			else if(entry.getStatus()==StudentAttendance.STATUS_ABSENCE)a++;
			else na++;
		}statistic.setAbsent(a);
		statistic.setLate(l);
		statistic.setPresent(p);
		statistic.setNa(na);
	}
	public void put(List<StudentAttendanceEntry>sentList,AttendanceResult returnResult,Set<Integer>notSend){
		statistic=returnResult.getStatistic();
		Map<Integer,Integer>returnStatus=returnResult.updateStatusMap();
		Map<Integer,StudentAttendanceEntry>sentMap=new TreeMap<Integer,StudentAttendanceEntry>();
		for(StudentAttendanceEntry entry:sentList){
			entry.setUpdateStatus(returnStatus.get(entry.getUserId()));
			sentMap.put(entry.getUserId(),entry);
		}Map<Integer,StudentAttendanceEntry>updateStatusMap=new TreeMap<Integer,StudentAttendanceEntry>();
		for(StudentAttendanceEntry entry:updateStatus){
			if(notSend!=null&&notSend.contains(entry.getUserId()))
				entry.setUpdateStatus(StudentAttendanceEntry.UPDATE_NOT_SEND);
			else entry.setUpdateStatus(null);
			updateStatusMap.put(entry.getUserId(),entry);
		}updateStatusMap.putAll(sentMap);
		updateStatus=entryMapToList(updateStatusMap);
	}
	public void put(Set<Integer>notSend){
		for(StudentAttendanceEntry entry:updateStatus){
			if(notSend!=null&&notSend.contains(entry.getUserId()))
				entry.setUpdateStatus(StudentAttendanceEntry.UPDATE_NOT_SEND);
			else entry.setUpdateStatus(null);
		}
	}
	public StudentAttendanceEntry getUpdateStatus(int userId){
		if(updateStatus==null||updateStatus.isEmpty())return null;
		for(StudentAttendanceEntry entry:updateStatus)if(entry.getUserId()==userId)return entry;
		return null;
	}
	public boolean isChecked(int userId){
		StudentAttendanceEntry entry=getUpdateStatus(userId);
		return entry!=null&&(entry.getStatus()!=StudentAttendance.STATUS_NA);
	}
	@Override
	public String toString() {
		return "AttendanceResult [updateStatus=" + updateStatus
				+ ", statistic=" + statistic + "]";
	}
	private static List<StudentAttendanceEntry>entryMapToList(Map<Integer,StudentAttendanceEntry>map){
		List<StudentAttendanceEntry>list=new ArrayList<StudentAttendanceEntry>();
		for(Map.Entry<Integer,StudentAttendanceEntry>entry:map.entrySet())list.add(entry.getValue());
		return list;
	}
	private Map<Integer,Integer>updateStatusMap(){
		Map<Integer,Integer>map=new TreeMap<Integer,Integer>();
		if(updateStatus!=null&&!updateStatus.isEmpty())
			for(StudentAttendanceEntry entry:updateStatus)
				map.put(entry.getUserId(),entry.getUpdateStatus());
		return map;
	}
}
