package br.com.zupacademy.giovannimoratto.casadocodigo.addauthor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorFormDTO {

	/* Attributes */
	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;
	@NotBlank
    @Size(max = 400)
	private String description;

	/* Getters and Setters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/* Methods */
	public AuthorModel toModel() {
		return new AuthorModel(name, email, description);
	}
}
