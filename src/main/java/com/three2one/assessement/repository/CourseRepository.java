package com.three2one.assessement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.three2one.assessement.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findAllBycourseStudents_student_id(Long studentId);
}
