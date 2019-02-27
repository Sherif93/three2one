package com.three2one.assessement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table
@JsonIgnoreProperties(value = { "courseStudents" })
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_id")
	private Long id;

	@NotBlank
	@Size(max = 100, min = 2)
	@Column(name = "course_name")
	private String name;

	@Size(max = 500, min = 2)
	@Column(name = "course_desc")
	private String description;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "course_publish_date")
	private Date publishDate;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "course_updated_date")
	private Date lastUpdated;

	@Max(value = 100)
	@Column(name = "course_hours")
	private int totalHours;

	@Size(max = 100, min = 2)
	@Column(name = "course_instructor")
	private String instructor;

	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<StudentCourse> courseStudents;

	public Course() {
	}

	public Course(@NotBlank @Size(max = 100, min = 2) String name, @Size(max = 500, min = 2) String description,
			Date publishDate, Date lastUpdated, @Max(100) int totalHours, @Size(max = 100, min = 2) String instructor,
			List<StudentCourse> courseStudents) {
		super();
		this.name = name;
		this.description = description;
		this.publishDate = publishDate;
		this.lastUpdated = lastUpdated;
		this.totalHours = totalHours;
		this.instructor = instructor;
		this.courseStudents = courseStudents;
	}

	public Long getCourseId() {
		return id;
	}

	public void setCourseId(Long courseId) {
		this.id = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public List<StudentCourse> getCourseStudents() {
		return courseStudents;
	}

	public void setCourseStudents(List<StudentCourse> courseStudents) {
		this.courseStudents = courseStudents;
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
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + id + ", name=" + name + ", description=" + description + ", publishDate="
				+ publishDate + ", lastUpdated=" + lastUpdated + ", totalHours=" + totalHours + ", instructor="
				+ instructor + "]";
	}

}
