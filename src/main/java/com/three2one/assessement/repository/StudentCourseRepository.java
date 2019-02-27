package com.three2one.assessement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.three2one.assessement.model.Course;
import com.three2one.assessement.model.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long>{

	@Query("SELECT sc.course FROM StudentCourse sc WHERE sc.student.id =:studentId")
	List<Course> getAllCoursesByStudentId(@Param("studentId") Long studentId);
	
	@Transactional
	long deleteAllByStudent_IdAndCourse_Id(Long courseId, Long studentId);
}
