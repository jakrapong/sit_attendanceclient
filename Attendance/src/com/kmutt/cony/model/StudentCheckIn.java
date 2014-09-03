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
public class StudentCheckIn {
    private User student;
    private ClassSchedule schedule;
    private int checkInStatus;
    public static final int PRESENT=1;
    public static final int LATE=2;
    public static final int ABSENCE=3;
    public static final int UNKNOW=4;

    public StudentCheckIn() {
    }

    public StudentCheckIn(User student, int checkInStatus) {
        this.student = student;
        this.checkInStatus = checkInStatus;
    }

    public StudentCheckIn(ClassSchedule schedule, int checkInStatus) {
        this.schedule = schedule;
        this.checkInStatus = checkInStatus;
    }

    public ClassSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(ClassSchedule schedule) {
        this.schedule = schedule;
    }
    

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public int getCheckInStatus() {
        return checkInStatus;
    }

    public void setCheckInStatus(int checkInStatus) {
        this.checkInStatus = checkInStatus;
    }

	@Override
	public String toString() {
		return "StudentCheckIn [student=" + student + ", schedule=" + schedule
				+ ", checkInStatus=" + checkInStatus + "]";
	}
    
}
