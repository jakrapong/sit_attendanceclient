package com.kmutt.cony.model.zombie;


public class StudentAttendanceEntry {
	@com.google.gson.annotations.SerializedName("user_id")
	private int userId;
	private int status;
	@com.google.gson.annotations.SerializedName("class_id")
	private int classId;
	private Integer updateStatus;
	
	public static final int UPDATE_SUCCESS=1;
	public static final int UPDATE_SUCCESS_NOT_CHANGE=2;
	public static final int UPDATE_ERROR=3;
	public static final int UPDATE_NOT_SEND=-1;
	
	public StudentAttendanceEntry() {}
	public StudentAttendanceEntry(int userId, Integer status, Integer classId) {
		this.userId = userId;
		this.status = status;
		this.classId = classId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getUpdateStatus() {
		return updateStatus;
	}
	public void setUpdateStatus(Integer updateStatus) {
		this.updateStatus = updateStatus;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	@Override
	public String toString() {
		return "StudentAttendanceEntry [userId=" + userId + ", status="
				+ status + ", updateStatus=" + updateStatus + "]";
	}
	
}
