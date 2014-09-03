/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kmutt.cony.model;

/**
 *
 * @author ess25_000
 */
public class TimeAttendance {
    private int classId;
    private int status;

    public TimeAttendance() {
    }

    public TimeAttendance(int classId, int status) {
        this.classId = classId;
        this.status = status;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "TimeAttendance [classId=" + classId + ", status=" + status
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classId;
		result = prime * result + status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeAttendance other = (TimeAttendance) obj;
		if (classId != other.classId)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
    
    
}
