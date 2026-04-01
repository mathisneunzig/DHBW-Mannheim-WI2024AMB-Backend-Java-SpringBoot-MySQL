package de.mathisneunzig.demo.dto;

/**
 * DTO = Data Transfer Object.
 *
 * <p>DTOs are lightweight objects used to move data across process/layer boundaries
 * (usually client <-> API). They are not database models.
 *
 * <p>Why DTOs are useful:
 * <ul>
 *   <li>Hide internal entity structure from external callers.</li>
 *   <li>Avoid exposing sensitive fields accidentally.</li>
 *   <li>Shape request/response payloads to fit API needs.</li>
 *   <li>Version API contracts without changing database tables directly.</li>
 * </ul>
 */
public class RegistrationDTO {

	private String userName;
	private String lastName;
	private String firstName;
	private String email;
	private String phoneNr;
	private String password;
	private String passwordConfirm;
	private String street;
	private String houseNr;
	private String zipCode;
	private String city;
	private String country;

	public RegistrationDTO(String userName, String lastName, String firstName, String email, String phoneNr,
			String password, String passwordConfirm, String street, String houseNr, String zipCode, String city,
			String country) {
		super();
		this.userName = userName;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNr = phoneNr;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.street = street;
		this.houseNr = houseNr;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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

	@Override
	public String toString() {
		return "RegistrationDTO [userName=" + userName + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", email=" + email + ", phoneNr=" + phoneNr + ", password=" + password + ", passwordConfirm="
				+ passwordConfirm + ", street=" + street + ", houseNr=" + houseNr + ", zipCode=" + zipCode + ", city="
				+ city + ", country=" + country + "]";
	}

}
