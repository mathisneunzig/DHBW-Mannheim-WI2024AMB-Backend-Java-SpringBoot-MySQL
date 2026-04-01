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
import de.mathisneunzig.demo.entities.User;
import de.mathisneunzig.demo.service.UserService;

/**
 * Controller = API layer.
 *
 * <p>Responsibilities:
 * <ul>
 *   <li>Map HTTP requests to Java methods.</li>
 *   <li>Delegate business work to service classes.</li>
 *   <li>Build HTTP responses with proper status codes.</li>
 * </ul>
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
    	return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("User for ID " + id + " not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching User: " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Object> getByEmail(@PathVariable String email) {
        try {
            return new ResponseEntity<>(userService.getByEmail(email), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("User for email " + email + " not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching User: " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/phone/{phoneNr}")
    public ResponseEntity<Object> getByPhone(@PathVariable String phoneNr) {
        try {
            return new ResponseEntity<>(userService.getByPhone(phoneNr), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("User for phone nr. " + phoneNr + " not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching User: " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    /**
     * Receives registration data as DTO, not as entity.
     * DTO keeps API contract stable and avoids exposing full internal model.
     */
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody RegistrationDTO dto) {
        try {
            return new ResponseEntity<>(userService.create(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating User: " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable UUID id) {
        try {
        	userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("User for ID " + id + " not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching User: " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
