package com.kmutt.cony.model.zombie;

import java.util.List;

public class AttendanceResult {
	private List<StudentAttendance>updateStatus;
	private Statistic statistic;
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
	
}
