package com.three2one.assessement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.three2one.assessement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findByEmailOrUsername(String email, String username);
	Optional<Student> findByEmail(String email);
}
