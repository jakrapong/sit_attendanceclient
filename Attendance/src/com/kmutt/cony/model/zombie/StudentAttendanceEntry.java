package com.kmutt.cony.model.zombie;


public class StudentAttendanceEntry {
	@com.google.gson.annotations.SerializedName("user_id")
	private int userId;
	private Integer status;
	@com.google.gson.annotations.SerializedName("class_id")
	private Integer classId;
	private Integer updateStatus;
	public StudentAttendanceEntry() {}
	public StudentAttendanceEntry(int userId, Integer status, Integer classId) {
		super();
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
}
