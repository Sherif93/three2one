package com.three2one.assessement.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.three2one.assessement.model.Course;
import com.three2one.assessement.repository.CourseRepository;

@Service
public class CourseService {
	
	private CourseRepository courseRepository;
	
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	@Cacheable("courses")
	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}
	
	public List<Course> getCoursesByStudentId(Long studentId) {
		return courseRepository.findAllBycourseStudents_student_id(studentId);
	}
}
