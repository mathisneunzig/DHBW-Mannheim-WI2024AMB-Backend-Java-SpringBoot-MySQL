package de.mathisneunzig.demo.dto;

import java.util.UUID;

import de.mathisneunzig.demo.entities.CourseType;
import de.mathisneunzig.demo.entities.ExamType;

/**
 * DTO used to create/update courses from API input.
 *
 * <p>Notice how we transfer {@code teacherId} instead of a full Teacher object.
 * This keeps the API simpler and avoids nested entity payload complexity.
 */
public class CourseDTO {

	private String title;
	private String description;
	private int ects;
	private CourseType courseType;
	private ExamType examType;
	private UUID teacherId;

	public CourseDTO() {
		super();
	}

	public CourseDTO(String title, String description, int ects, CourseType courseType, ExamType examType,
			UUID teacherId) {
		super();
		this.title = title;
		this.description = description;
		this.ects = ects;
		this.courseType = courseType;
		this.examType = examType;
		this.teacherId = teacherId;
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

	public UUID getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(UUID teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return "Course [title=" + title + ", description=" + description + ", ects=" + ects + ", courseType="
				+ courseType + ", examType=" + examType + ", teacherId=" + teacherId + "]";
	}

}
