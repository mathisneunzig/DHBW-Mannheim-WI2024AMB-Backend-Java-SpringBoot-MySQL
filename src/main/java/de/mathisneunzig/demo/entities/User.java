package de.mathisneunzig.demo.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

/**
 * JPA Entity mapped to database table "users".
 *
 * <p>Entity classes represent persistent domain objects (DB rows).
 */
@Entity
@Table(name = "users")
public class User {

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
     * Many-to-many relation:
     * one user can attend many courses and one course can have many users.
     *
     * <p>JPA stores this in a dedicated join table named user_course.
     */
	@ManyToMany
	@JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courses = new HashSet<>();

	public User(@NotBlank String userName, @NotBlank String lastName, @NotBlank String firstName,
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

	public User() {
		super();
	}

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
		return "User [id=" + id + ", userName=" + userName + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", email=" + email + ", phoneNr=" + phoneNr + ", password=" + password + ", street=" + street
				+ ", houseNr=" + houseNr + ", zipCode=" + zipCode + ", city=" + city + ", country=" + country
				+ ", courses=" + courses + "]";
	}

}
