package com.three2one.assessement.payload;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class CourseRegistrationRequest {

	@NotNull
	@Digits(integer = 1, fraction = 0)
	private Long studentId;

	@NotNull
	@Digits(integer = 1, fraction = 0)
	private Long courseId;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

}
