package br.com.zupacademy.giovannimoratto.casadocodigo.addauthor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.giovannimoratto.casadocodigo.validation.Unique;

public class AddAuthorRequest {

	/* Attributes */
	@NotBlank
	private String name;
	@NotBlank
	@Email
	@Unique(attribute_name = "email", class_name = AuthorModel.class)
	private String email;
	@NotBlank
    @Length(max = 400)
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
