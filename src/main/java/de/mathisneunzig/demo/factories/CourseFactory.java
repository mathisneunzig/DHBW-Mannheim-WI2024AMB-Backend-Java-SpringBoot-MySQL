package de.mathisneunzig.demo.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mathisneunzig.demo.dto.CourseDTO;
import de.mathisneunzig.demo.entities.Course;
import de.mathisneunzig.demo.repositories.TeacherRepository;

/**
 * Factory for creating {@link Course} entities from API input DTOs.
 */
@Service
public class CourseFactory {

	@Autowired
	TeacherRepository teacherRepository;

	public Course fromDTO(CourseDTO dto) {
		Course c = new Course();

		c.setTitle(dto.getTitle());
		c.setDescription(dto.getDescription());
		c.setEcts(dto.getEcts());
		c.setCourseType(dto.getCourseType());
		c.setExamType(dto.getExamType());
        // DTO contains only teacherId; factory resolves id -> full Teacher entity.
		c.setTeacher(teacherRepository.findById(dto.getTeacherId()).get());

		return c;
	}

}
