package de.mathisneunzig.demo.factories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.mathisneunzig.demo.dto.RegistrationDTO;
import de.mathisneunzig.demo.entities.Teacher;
import de.mathisneunzig.demo.entities.User;

/**
 * Unit tests for AccountFactory.
 *
 * <p>These tests verify pure mapping logic and do not need Spring context.
 */
class AccountFactoryTest {

    private final AccountFactory accountFactory = new AccountFactory();

    @Test
    void fromUserDTOMapsAllRelevantFields() {
        RegistrationDTO dto = new RegistrationDTO(
                "student1", "Doe", "Jane", "jane@example.com", "123",
                "pw", "pw", "Main Street", "10", "12345", "Mannheim", "DE"
        );

        User mapped = accountFactory.fromUserDTO(dto);

        assertEquals("student1", mapped.getUserName());
        assertEquals("Doe", mapped.getLastName());
        assertEquals("jane@example.com", mapped.getEmail());
        assertEquals("Main Street", mapped.getStreet());
    }

    @Test
    void fromTeacherDTOMapsAllRelevantFields() {
        RegistrationDTO dto = new RegistrationDTO(
                "teacher1", "Miller", "Max", "max@example.com", "456",
                "pw", "pw", "Oak Street", "2", "54321", "Heidelberg", "DE"
        );

        Teacher mapped = accountFactory.fromTeacherDTO(dto);

        assertEquals("teacher1", mapped.getUserName());
        assertEquals("Miller", mapped.getLastName());
        assertEquals("max@example.com", mapped.getEmail());
        assertEquals("Oak Street", mapped.getStreet());
    }
}
