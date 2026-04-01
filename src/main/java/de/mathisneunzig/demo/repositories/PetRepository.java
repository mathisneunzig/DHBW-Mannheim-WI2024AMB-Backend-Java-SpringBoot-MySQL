package de.mathisneunzig.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.mathisneunzig.demo.entities.Pet;

/**
 * Repository for {@link Pet} entities.
 *
 * <p>Even without custom methods, this interface is powerful because
 * {@link JpaRepository} contributes a complete CRUD API.
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, UUID> {

}
