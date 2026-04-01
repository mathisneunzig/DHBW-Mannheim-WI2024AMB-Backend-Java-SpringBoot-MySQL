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

import de.mathisneunzig.demo.dto.CourseDTO;
import de.mathisneunzig.demo.entities.Course;
import de.mathisneunzig.demo.service.CourseService;

/**
 * REST controller for course endpoints.
 *
 * <p>For beginners: controllers are the "door" of the backend.
 * They should not contain deep domain logic; this is delegated to services.
 */
@RestController
@RequestMapping("/courses") // https://localhost:8080/courses
public class CourseController {

	@Autowired
	CourseService courseService;

    @GetMapping // GET https://localhost:8080/courses
    public ResponseEntity<List<Course>> getAll() {
    	return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") // GET https://localhost:8080/courses/{id}
    public ResponseEntity<Object> getById(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(courseService.getById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Course for ID " + id + " not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching course: " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping // POST https://localhost:8080/courses
    public ResponseEntity<Object> create(@RequestBody CourseDTO dto) {
        try {
            // Input arrives as DTO, then service/factory converts it to an entity.
            return new ResponseEntity<>(courseService.create(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating course: " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}") // DELETE https://localhost:8080/courses/{id}
    public ResponseEntity<Object> deleteById(@PathVariable UUID id) {
        try {
        	courseService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Course for ID " + id + " not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching course: " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
