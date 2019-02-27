package com.three2one.assessement.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class StudentCourse {

	@EmbeddedId
	private StudentCourseKey id;

	@ManyToOne
	@MapsId("student_id")
	@JoinColumn(name = "student_id")
	Student student;

	@ManyToOne
	@MapsId("course_id")
	@JoinColumn(name = "course_id")
	Course course;

	public StudentCourse() {
	}

	public StudentCourse(StudentCourseKey id, Student student, Course course) {
		this.id = id;
		this.student = student;
		this.course = course;
	}

	public StudentCourseKey getId() {
		return id;
	}

	public void setId(StudentCourseKey id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
