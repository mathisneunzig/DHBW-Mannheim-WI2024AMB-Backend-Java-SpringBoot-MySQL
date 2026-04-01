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

import de.mathisneunzig.demo.dto.PetDTO;
import de.mathisneunzig.demo.entities.Pet;
import de.mathisneunzig.demo.service.PetService;

/**
 * REST controller for course endpoints.
 *
 * <p>For beginners: controllers are the "door" of the backend.
 * They should not contain deep domain logic; this is delegated to services.
 */
@RestController
@RequestMapping("/pets") // https://localhost:8080/pets
public class PetController {
	
	@Autowired
	PetService petService;
	
	@GetMapping // GET https://localhost:8080/pets
	public ResponseEntity<List<Pet>> getAll() { 
		return new ResponseEntity<>(petService.getAll(), HttpStatus.OK);
	}

    @GetMapping("/{id}") // GET https://localhost:8080/pets/{id}
    public ResponseEntity<Object> getById(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(petService.getById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Pet for ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping // POST https://localhost:8080/pets
    public ResponseEntity<Object> create(@RequestBody PetDTO dto) {
        try {
            // Input arrives as DTO, then service/factory converts it to an entity.
            return new ResponseEntity<>(petService.create(dto), HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("User for ID " + dto.getOwnerId() + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}") // DELETE https://localhost:8080/pets/{id}
    public ResponseEntity<Object> deleteById(@PathVariable UUID id) {
        try {
        	petService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Pet for ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
	
}
