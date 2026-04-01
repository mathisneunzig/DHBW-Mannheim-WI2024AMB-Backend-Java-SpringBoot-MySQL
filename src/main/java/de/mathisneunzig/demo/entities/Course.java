package de.mathisneunzig.demo.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Entity that represents a course in the domain model.
 */
@Entity
@Table(name = "courses")
public class Course {

	@Id
	@Column(columnDefinition = "VARBINARY(16)")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column 
	@NotBlank 
	private String title;
	
	@Column 
	@NotBlank 
	private String description;
	
	@Column 
	@NotBlank 
	private int ects;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private CourseType courseType;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private ExamType examType;

	/**
	 * Many courses can be associated with one teacher.
	 *
	 * <p>{@code optional = false} and {@code nullable = false} enforce that every
	 * course must always have a teacher.
	 */
	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id", nullable = false)
	private Teacher teacher;

	/**
	 * Many-to-many relation to students/users.
	 * The owning side is in {@link User} via its `courses` field.
	 */
	@ManyToMany(mappedBy = "courses")
	private Set<User> users = new HashSet<>();

	public Course(@NotBlank String title, @NotBlank String description, @NotBlank int ects,
			@NotNull CourseType courseType, @NotNull ExamType examType, @NotNull Teacher teacher, Set<User> users) {
		super();
		this.title = title;
		this.description = description;
		this.ects = ects;
		this.courseType = courseType;
		this.examType = examType;
		this.teacher = teacher;
		this.users = users;
	}

	public Course() { super(); }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEcts() {
		return ects;
	}

	public void setEcts(int ects) {
		this.ects = ects;
	}

	public CourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

	public ExamType getExamType() {
		return examType;
	}

	public void setExamType(ExamType examType) {
		this.examType = examType;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + ", ects=" + ects
				+ ", courseType=" + courseType + ", examType=" + examType + ", teacher=" + teacher + ", users=" + users
				+ "]";
	}

}
