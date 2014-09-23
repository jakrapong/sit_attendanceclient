package com.kmutt.cony.model;

import java.util.List;

public class Group {
	private Integer groupId;
    private Integer courseId;
    private String description;
    private String classroom;
    private String teacherId;
    private Teacher teacher;
    private List<ClassSchedule>classSchedule;
    private List<Student>students;
    private Course course;
    public Group(){}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<ClassSchedule> getClassSchedule() {
		return classSchedule;
	}
	public void setClassSchedule(List<ClassSchedule> classSchedule) {
		this.classSchedule = classSchedule;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", courseId=" + courseId
				+ ", description=" + description + ", classroom=" + classroom
				+ ", teacherId=" + teacherId + ", teacher=" + teacher
				+ ", classSchedule=" + classSchedule + ", students=" + students
				+ ", course=" + course + "]";
	}
    
}
