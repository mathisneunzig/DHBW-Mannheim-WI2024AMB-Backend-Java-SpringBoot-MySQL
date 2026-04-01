package de.mathisneunzig.demo.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mathisneunzig.demo.dto.PetDTO;
import de.mathisneunzig.demo.entities.Pet;
import de.mathisneunzig.demo.service.UserService;

/**
 * Factory for creating {@link Pet} entities from API input DTOs.
 */
@Service
public class PetFactory {

	@Autowired
	UserService userService;

	public Pet fromDTO(PetDTO dto) {
		Pet p = new Pet();

		p.setName(dto.getName());
		p.setColor(dto.getColor());
		p.setAnimalType(dto.getAnimalType());
		p.setOwner(userService.getById(dto.getOwnerId()));
		
		return p;
	}

}
