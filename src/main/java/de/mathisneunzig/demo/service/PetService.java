package de.mathisneunzig.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mathisneunzig.demo.dto.PetDTO;
import de.mathisneunzig.demo.entities.Pet;
import de.mathisneunzig.demo.factories.PetFactory;
import de.mathisneunzig.demo.repositories.PetRepository;

/**
 * Service layer for pet-related business workflows.
 */
@Service
public class PetService {

	@Autowired
	PetRepository petRepository;
	
	@Autowired
	PetFactory petFactory;

	public List<Pet> getAll() {
		return petRepository.findAll();
	}

	public Pet getById(UUID id) {
		return petRepository.findById(id).get();
	}
	
	public Pet create(PetDTO dto) {
		return petRepository.save(petFactory.fromDTO(dto));
	}

	public void deleteById(UUID id) {
		petRepository.delete(getById(id));
	}

}
