package de.mathisneunzig.demo.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.mathisneunzig.demo.entities.User;

/**
 * Repository = "data access layer" for the {@link User} entity.
 *
 * <p>Spring Data creates the implementation automatically at runtime. By extending
 * {@link JpaRepository}, we instantly get common CRUD methods such as:
 * <ul>
 *   <li>{@code findAll()} – read all users</li>
 *   <li>{@code findById(...)} – read one user by primary key</li>
 *   <li>{@code save(...)} – insert/update a user</li>
 *   <li>{@code delete(...)} – remove a user</li>
 * </ul>
 *
 * <p>Why repositories exist: they isolate database-specific logic from business logic.
 * Services can focus on rules/use-cases, while repositories focus on persistence.
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Derived query method: Spring Data parses the method name and generates
     * SQL/JPQL automatically (no manual query required).
     */
	Optional<User> findByEmail(String email);

    /**
     * Another derived query for looking up users by phone number.
     */
	Optional<User> findByPhoneNr(String phoneNr);

}
