package de.mathisneunzig.demo.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * JPA Entity mapped to database table "users".
 *
 * <p>Entity classes represent persistent domain objects (DB rows).
 */
@Entity
@Table(name = "pets")
public class Pet {

	@Id
	@Column(columnDefinition = "VARBINARY(16)")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column
	@NotBlank
	private String name;

	@Column
	@NotBlank
	private String color;

	@Column
	@Enumerated(EnumType.STRING)
	@NotBlank
	private AnimalType animalType;

    @NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id", nullable = false)
    private User owner;

	public Pet(@NotBlank String name, @NotBlank String color, @NotBlank AnimalType animalType, @NotNull User owner) {
		super();
		this.name = name;
		this.color = color;
		this.animalType = animalType;
		this.owner = owner;
	}
	
	public Pet() {}

	public UUID getId() {
		return id;
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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", color=" + color + ", animalType=" + animalType + ", owner="
				+ owner + "]";
	}

}
