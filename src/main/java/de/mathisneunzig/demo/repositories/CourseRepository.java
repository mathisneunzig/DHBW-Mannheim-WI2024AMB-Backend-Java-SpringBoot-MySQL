package de.mathisneunzig.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.mathisneunzig.demo.entities.Course;

/**
 * Repository for {@link Course} entities.
 *
 * <p>Even without custom methods, this interface is powerful because
 * {@link JpaRepository} contributes a complete CRUD API.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

}
