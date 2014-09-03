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
public class StudentStatistic {
    private User student;
    private Integer present;
    private Integer late;
    private Integer absence;
    private Integer unknow;

    public StudentStatistic() {
    }

    public StudentStatistic(User student) {
        this.student = student;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Integer getPresent() {
        return present;
    }

    public void setPresent(Integer present) {
        this.present = present;
    }

    public Integer getLate() {
        return late;
    }

    public void setLate(Integer late) {
        this.late = late;
    }

    public Integer getAbsence() {
        return absence;
    }

    public void setAbsence(Integer absence) {
        this.absence = absence;
    }

    public Integer getUnknow() {
        return unknow;
    }

    public void setUnknow(Integer unknow) {
        this.unknow = unknow;
    }

	@Override
	public String toString() {
		return "StudentStatistic [student=" + student + ", present=" + present
				+ ", late=" + late + ", absence=" + absence + ", unknow="
				+ unknow + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((absence == null) ? 0 : absence.hashCode());
		result = prime * result + ((late == null) ? 0 : late.hashCode());
		result = prime * result + ((present == null) ? 0 : present.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		result = prime * result + ((unknow == null) ? 0 : unknow.hashCode());
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
		StudentStatistic other = (StudentStatistic) obj;
		if (absence == null) {
			if (other.absence != null)
				return false;
		} else if (!absence.equals(other.absence))
			return false;
		if (late == null) {
			if (other.late != null)
				return false;
		} else if (!late.equals(other.late))
			return false;
		if (present == null) {
			if (other.present != null)
				return false;
		} else if (!present.equals(other.present))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		if (unknow == null) {
			if (other.unknow != null)
				return false;
		} else if (!unknow.equals(other.unknow))
			return false;
		return true;
	}
    
    
}
