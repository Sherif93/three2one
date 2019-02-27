package com.three2one.assessement.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.three2one.assessement.Exception.EmailOrUsernameAlreadyExistsException;
import com.three2one.assessement.Exception.StudentOrCourseException;
import com.three2one.assessement.model.Course;
import com.three2one.assessement.model.Student;
import com.three2one.assessement.model.StudentCourse;
import com.three2one.assessement.model.StudentCourseKey;
import com.three2one.assessement.repository.CourseRepository;
import com.three2one.assessement.repository.StudentCourseRepository;
import com.three2one.assessement.repository.StudentRepository;

@Service
public class StudentService {

	private StudentRepository studentRepository;
	private CourseRepository courseRepository;
	private StudentCourseRepository studentCourseRepository;

	public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, StudentCourseRepository studentCourseRepository) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
		this.studentCourseRepository = studentCourseRepository;
	}

	public void insertStudent(Student student) throws EmailOrUsernameAlreadyExistsException {
		String email = student.getEmail();
		String username = student.getUsername();
		Optional<Student> optionalStudent = studentRepository.findByEmailOrUsername(email, username);
		if (optionalStudent.isPresent()) {
			throw new EmailOrUsernameAlreadyExistsException("Email or username already exists");
		}
		studentRepository.save(student);
	}

	public void registerCourse(Long studentId, Long courseId) throws StudentOrCourseException {
		Optional<Student> optionalStudent = studentRepository.findById(studentId);
		Optional<Course> optionalCourse = courseRepository.findById(courseId);

		if (!optionalStudent.isPresent() || !optionalCourse.isPresent()) {
			throw new StudentOrCourseException("Student ID and/or Course ID are invalid");
		}
		Student student = optionalStudent.get();
		Course course = optionalCourse.get();

		StudentCourseKey studentCourseKey = new StudentCourseKey(studentId, courseId);
		StudentCourse studentCourse = new StudentCourse(studentCourseKey, student, course);
		student.getStudentCourses().add(studentCourse);
		student = studentRepository.saveAndFlush(student);

	}

	public long unregisterCourse(Long studentId, Long courseId) throws StudentOrCourseException {
		Optional<Student> optionalStudent = studentRepository.findById(studentId);
		Optional<Course> optionalCourse = courseRepository.findById(courseId);

		if (!optionalStudent.isPresent() || !optionalCourse.isPresent()) {
			throw new StudentOrCourseException("Student ID and/or Course ID are invalid");
		}
		
		return studentCourseRepository.deleteAllByStudent_IdAndCourse_Id(studentId, courseId);
	}

}
