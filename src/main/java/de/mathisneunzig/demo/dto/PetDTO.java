package de.mathisneunzig.demo.dto;

import java.util.UUID;

import de.mathisneunzig.demo.entities.AnimalType;

/**
 * DTO used to create/update courses from API input.
 *
 * <p>Notice how we transfer {@code ownerId} instead of a full User object.
 * This keeps the API simpler and avoids nested entity payload complexity.
 */
public class PetDTO {

	private String name;
	private String color;
	private AnimalType animalType;
	private UUID ownerId;

	public PetDTO() {
		super();
	}

	public PetDTO(String name, String color, AnimalType animalType, UUID ownerId) {
		super();
		this.name = name;
		this.color = color;
		this.animalType = animalType;
		this.ownerId = ownerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public AnimalType getAnimalType() {
		return animalType;
	}

	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}

	public UUID getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(UUID ownerId) {
		this.ownerId = ownerId;
	}
	
}
