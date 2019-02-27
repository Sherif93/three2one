package com.three2one.assessement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.three2one.assessement.utils.Gender;

@Entity
@Table
@JsonIgnoreProperties(value = { "studentCourses" })
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private Long id;

	@NotBlank
	@Size(max = 100, min = 2)
	@Column(name = "student_full_name")
	private String name;

	@NotBlank
	@Size(max = 40)
	@Email
	@Column(name = "student_email")
	private String email;

	@NotBlank
	@Size(max = 100, min = 2)
	@Column(name = "student_username")
	private String username;

	@NotBlank
	@Size(max = 100)
	@Column(name = "student_password")
	private String password;

	@Past
	@Temporal(value = TemporalType.DATE)
	@Column(name = "student_dob")
	private Date dob;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "student_gender")
	private Gender gender;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<StudentCourse> studentCourses;

	public Student() {
	}

	public Student(@NotBlank @Size(max = 100, min = 2) String name, @NotBlank @Size(max = 40) @Email String email,
			@NotBlank @Size(max = 100, min = 2) String username, @NotBlank @Size(max = 100) String password,
			@Past Date dob, @NotNull Gender gender, List<StudentCourse> studentCourses) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.studentCourses = studentCourses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
				+ password + ", dob=" + dob + ", gender=" + gender + "]";
	}

}
