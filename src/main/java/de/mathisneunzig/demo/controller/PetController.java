package de.mathisneunzig.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mathisneunzig.demo.entities.Pet;
import de.mathisneunzig.demo.repositories.PetRepository;

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
	PetRepository petRepository;
	
	@GetMapping
	public ResponseEntity<List<Pet>> getAll() {
		return new ResponseEntity<>(petRepository.findAll(), HttpStatus.OK);
	}
	
}
