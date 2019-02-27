package com.three2one.assessement.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.three2one.assessement.Exception.EmailOrUsernameAlreadyExistsException;
import com.three2one.assessement.Exception.StudentOrCourseException;
import com.three2one.assessement.model.Student;
import com.three2one.assessement.payload.CourseRegistrationRequest;
import com.three2one.assessement.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	Logger logger = LoggerFactory.getLogger(StudentController.class);

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/add")
	private String addStudent(@Valid @RequestBody Student student, BindingResult bindingResult) {

		try {
			studentService.insertStudent(student);
			logger.info("New student inserted");
		} catch (EmailOrUsernameAlreadyExistsException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
		}

		return student.getId().toString();
	}

	@PutMapping("/register")
	private ResponseEntity<String> registerCourse(@RequestBody CourseRegistrationRequest request) {

		try {
			studentService.registerCourse(request.getStudentId(), request.getCourseId());
			logger.info("student with id {} registered to course with id {}", request.getStudentId(),
					request.getCourseId());
			return ResponseEntity.ok().body("Done");
		} catch (StudentOrCourseException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
		}

	}

	@PutMapping("/unregister")
	private ResponseEntity<String> unregisterCourse(@RequestBody CourseRegistrationRequest request) {
		ResponseEntity<String> response;
		try {
			long result = studentService.unregisterCourse(request.getStudentId(), request.getCourseId());
			if (result == 1) {
				response = ResponseEntity.ok().body(String.valueOf(result));
				logger.info("student with id {} unregistered from course with id {}", request.getStudentId(),
						request.getCourseId());
			} else {
				response = ResponseEntity.badRequest().body("Student is not registered for this course");
			}
		} catch (StudentOrCourseException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
		}

		return response;
	}
}
