package de.mathisneunzig.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mathisneunzig.demo.dto.RegistrationDTO;
import de.mathisneunzig.demo.entities.User;
import de.mathisneunzig.demo.factories.AccountFactory;
import de.mathisneunzig.demo.repositories.UserRepository;

/**
 * Service layer for user-related use-cases.
 *
 * <p>Why logic is not inside controllers:
 * <ul>
 *   <li>Controllers should only handle HTTP concerns (path, status code, request/response format).</li>
 *   <li>Services hold business logic and orchestration.</li>
 *   <li>This separation improves testability and reuse (same service can be used by REST, CLI, batch jobs, etc.).</li>
 * </ul>
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AccountFactory accountFactory;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User getById(UUID id) {
		return userRepository.findById(id).get();
	}

	public User getByEmail(String email) {
		return userRepository.findByEmail(email).get();
	}

	public User getByPhone(String phoneNr) {
		return userRepository.findByPhoneNr(phoneNr).get();
	}

    /**
     * Creates a new user from input DTO:
     * 1) DTO carries input data from API.
     * 2) Factory converts DTO -> Entity.
     * 3) Repository persists Entity in DB.
     */
	public User create(RegistrationDTO dto) {
		return userRepository.save(accountFactory.fromUserDTO(dto));
	}

	public void deleteById(UUID id) {
		userRepository.delete(userRepository.findById(id).get());
	}

}
