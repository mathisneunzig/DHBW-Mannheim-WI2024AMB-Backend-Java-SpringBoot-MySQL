package de.mathisneunzig.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mathisneunzig.demo.dto.RegistrationDTO;
import de.mathisneunzig.demo.entities.Teacher;
import de.mathisneunzig.demo.factories.AccountFactory;
import de.mathisneunzig.demo.repositories.TeacherRepository;

/**
 * Service layer for teacher use-cases.
 *
 * <p>Why this layer matters: if business rules change, we update one service
 * implementation instead of repeating logic in multiple controllers.
 */
@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	AccountFactory accountFactory;

	/**
	 * Reads all teacher entities from persistent storage.
	 */
	public List<Teacher> getAll() {
		return teacherRepository.findAll();
	}

	public Teacher getById(UUID id) {
		return teacherRepository.findById(id).get();
	}

	public Teacher getByEmail(String email) {
		return teacherRepository.findByEmail(email).get();
	}

	public Teacher getByPhone(String phoneNr) {
		return teacherRepository.findByPhoneNr(phoneNr).get();
	}

	/**
	 * Creates a teacher from API input.
	 * The factory is responsible for mapping DTO fields to entity fields.
	 */
	public Teacher create(RegistrationDTO dto) {
		return teacherRepository.save(accountFactory.fromTeacherDTO(dto));
	}

	public void deleteById(UUID id) {
		teacherRepository.delete(teacherRepository.findById(id).get());
	}

}
