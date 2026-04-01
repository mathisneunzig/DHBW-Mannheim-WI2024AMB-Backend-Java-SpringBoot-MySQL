package de.mathisneunzig.demo.dto;

/**
 * Login payload DTO.
 *
 * <p>This DTO can later be used for authentication endpoints where only
 * email/password are required (instead of a full User entity).
 */
public class LoginDTO {

	private String email;
	private String password;

	public LoginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + "]";
	}

}
