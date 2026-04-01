package de.mathisneunzig.demo.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

/**
 * Teacher is a persistent domain entity.
 *
 * <p>The class is mapped to the database table {@code teachers}. Every object
 * of this class represents one row in that table.
 */
@Entity
@Table(name = "teachers")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"
)
public class Teacher {

	@Id
	@Column(columnDefinition = "VARBINARY(16)")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column
	@NotBlank
	private String userName;

	@Column
	@NotBlank
	private String lastName;

	@Column
	@NotBlank
	private String firstName;

	@Column
	@NotBlank
	private String email;

	@Column
	@NotBlank
	private String phoneNr;

	@Column
	@NotBlank
	private String password;

	@Column
	@NotBlank
	private String street;

	@Column
	@NotBlank
	private String houseNr;

	@Column
	@NotBlank
	private String zipCode;

	@Column
	@NotBlank
	private String city;

	@Column
	@NotBlank
	private String country;

	/**
	 * This side of the relation is inverse (`mappedBy = "teacher"`).
	 *
	 * <p>Meaning: the {@link Course} entity owns the foreign key column
	 * (`teacher_id`) in the database, while this field is the navigational view
	 * from teacher to all assigned courses.
	 */
	@OneToMany(mappedBy = "teacher")
    @JsonIdentityReference(alwaysAsId = true)
	private Set<Course> courses = new HashSet<>();

	public Teacher(@NotBlank String userName, @NotBlank String lastName, @NotBlank String firstName,
			@NotBlank String email, @NotBlank String phoneNr, @NotBlank String password, @NotBlank String street,
			@NotBlank String houseNr, @NotBlank String zipCode, @NotBlank String city, @NotBlank String country,
			Set<Course> courses) {
		super();
		this.userName = userName;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNr = phoneNr;
		this.password = password;
		this.street = street;
		this.houseNr = houseNr;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.courses = courses;
	}

	/**
	 * JPA requires a no-argument constructor so it can instantiate entities
	 * when loading data from the database.
	 */
	public Teacher() { super(); }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNr() {
		return houseNr;
	}

	public void setHouseNr(String houseNr) {
		this.houseNr = houseNr;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", userName=" + userName + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", email=" + email + ", phoneNr=" + phoneNr + ", password=" + password + ", street=" + street
				+ ", houseNr=" + houseNr + ", zipCode=" + zipCode + ", city=" + city + ", country=" + country
				+ ", courses=" + courses + "]";
	}

}
