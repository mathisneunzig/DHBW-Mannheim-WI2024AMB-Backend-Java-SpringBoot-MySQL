package de.mathisneunzig.demo.factories;

import org.springframework.stereotype.Service;

import de.mathisneunzig.demo.dto.RegistrationDTO;
import de.mathisneunzig.demo.entities.Teacher;
import de.mathisneunzig.demo.entities.User;

/**
 * Factory implementing a simple Factory Design Pattern.
 *
 * <p>Why use a factory:
 * <ul>
 *   <li>Central place for object creation/mapping rules.</li>
 *   <li>Avoid duplicated DTO -> Entity mapping code in multiple services/controllers.</li>
 *   <li>Easy to extend with defaults, validation, password hashing, etc.</li>
 * </ul>
 */
@Service
public class AccountFactory {

	public User fromUserDTO(RegistrationDTO dto) {
		User u = new User();

		u.setCity(dto.getCity());
		u.setCountry(dto.getCountry());
		u.setEmail(dto.getEmail());
		u.setFirstName(dto.getFirstName());
		u.setHouseNr(dto.getHouseNr());
		u.setLastName(dto.getLastName());
		u.setPassword(dto.getPassword());
		u.setPhoneNr(dto.getPhoneNr());
		u.setStreet(dto.getStreet());
		u.setUserName(dto.getUserName());
		u.setZipCode(dto.getZipCode());

		return u;
	}

	public Teacher fromTeacherDTO(RegistrationDTO dto) {
		Teacher t = new Teacher();

		t.setCity(dto.getCity());
		t.setCountry(dto.getCountry());
		t.setEmail(dto.getEmail());
		t.setFirstName(dto.getFirstName());
		t.setHouseNr(dto.getHouseNr());
		t.setLastName(dto.getLastName());
		t.setPassword(dto.getPassword());
		t.setPhoneNr(dto.getPhoneNr());
		t.setStreet(dto.getStreet());
		t.setUserName(dto.getUserName());
		t.setZipCode(dto.getZipCode());

		return t;
	}

}
