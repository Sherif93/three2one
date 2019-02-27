package com.three2one.assessement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three2one.assessement.model.Course;
import com.three2one.assessement.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	Logger logger = LoggerFactory.getLogger(CourseController.class);

	private CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@GetMapping("/all")
	private List<Course> getAllCourses() {
		List<Course> courses = courseService.getAllCourse();
		logger.info("getting all courses: {}", courses);
		return courses;
	}
	
	@GetMapping("/{studentId}")
	private List<Course> getCoursesByStudentId(@PathVariable Long studentId) {
		List<Course> courses = courseService.getCoursesByStudentId(studentId);
		logger.info("getting courses for a specific student: {}", courses);
		return courses;
	}

}
