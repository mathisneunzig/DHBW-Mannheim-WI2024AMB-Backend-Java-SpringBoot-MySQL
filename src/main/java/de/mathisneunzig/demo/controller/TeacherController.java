package de.mathisneunzig.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mathisneunzig.demo.dto.RegistrationDTO;
import de.mathisneunzig.demo.entities.Teacher;
import de.mathisneunzig.demo.service.TeacherService;

/**
 * This controller exposes all teacher-related REST endpoints.
 *
 * <p>Important for beginners: this class focuses on HTTP concerns only.
 * It receives requests, forwards work to {@link TeacherService}, and translates
 * results/exceptions into meaningful HTTP status codes.
 */
@RestController
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
	TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAll() {
	    // Return 200 OK with all teachers from the service layer.
    	return new ResponseEntity<>(teacherService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(teacherService.getById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Teacher for ID " + id + " not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching teacher: " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Object> getByEmail(@PathVariable String email) {
        try {
            return new ResponseEntity<>(teacherService.getByEmail(email), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Teacher for email " + email + " not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching teacher: " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/phone/{phoneNr}")
    public ResponseEntity<Object> getByPhone(@PathVariable String phoneNr) {
        try {
            return new ResponseEntity<>(teacherService.getByPhone(phoneNr), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Teacher for phone nr. " + phoneNr + " not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching teacher: " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody RegistrationDTO dto) {
        try {
            // The service handles business logic and persistence. The controller stays thin.
            return new ResponseEntity<>(teacherService.create(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating teacher: " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable UUID id) {
        try {
        	teacherService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Teacher for ID " + id + " not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching teacher: " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
