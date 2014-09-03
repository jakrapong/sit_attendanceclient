/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kmutt.cony.model;

import com.kmutt.cony.util.DateTimeService;

import java.util.Date;

/**
 *
 * @author ess25_000
 */
public class ClassSchedule {
    private int classScheduleId;
    private String date;
    private String time;
    private Integer period;
    private String description;

    public ClassSchedule() {
    }

    public ClassSchedule(int classScheduleId, Date dateTime) {
        this.classScheduleId = classScheduleId;
        this.date = DateTimeService.DATE_FORMAT.format(dateTime);
        this.time = DateTimeService.TIME_FORMAT.format(dateTime);
    }

    public int getClassScheduleId() {
        return classScheduleId;
    }

    public void setClassScheduleId(int classScheduleId) {
        this.classScheduleId = classScheduleId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public String toString() {
		return "ClassSchedule [classScheduleId=" + classScheduleId + ", date="
				+ date + ", time=" + time + ", period=" + period
				+ ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classScheduleId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		ClassSchedule other = (ClassSchedule) obj;
		if (classScheduleId != other.classScheduleId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
    
    
}
