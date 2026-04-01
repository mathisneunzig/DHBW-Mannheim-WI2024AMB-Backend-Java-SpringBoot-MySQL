package de.mathisneunzig.demo.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.mathisneunzig.demo.entities.Teacher;

/**
 * Repository abstraction for {@link Teacher} persistence operations.
 *
 * <p>A repository is a dedicated component for database access. It prevents
 * controller/service classes from having to write query code directly.
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, UUID> {

	/**
	 * Spring Data derives the query from the method name.
	 */
	Optional<Teacher> findByEmail(String email);

	Optional<Teacher> findByPhoneNr(String phoneNr);

}
