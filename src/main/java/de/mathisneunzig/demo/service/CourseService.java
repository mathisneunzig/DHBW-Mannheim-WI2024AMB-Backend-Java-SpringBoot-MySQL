package de.mathisneunzig.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mathisneunzig.demo.dto.CourseDTO;
import de.mathisneunzig.demo.entities.Course;
import de.mathisneunzig.demo.factories.CourseFactory;
import de.mathisneunzig.demo.repositories.CourseRepository;

/**
 * Service layer for course-related business workflows.
 */
@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CourseFactory courseFactory;

	public List<Course> getAll() {
		return courseRepository.findAll();
	}

	public Course getById(UUID id) {
		return courseRepository.findById(id).get();
	}

	/**
	 * Converts incoming DTO into a valid entity and persists it.
	 *
	 * <p>This method demonstrates clean layering:
	 * controller -> service -> factory/repository.
	 */
	public Course create(CourseDTO dto) {
		return courseRepository.save(courseFactory.fromDTO(dto));
	}

	public void deleteById(UUID id) {
		courseRepository.delete(courseRepository.findById(id).get());
	}

}
