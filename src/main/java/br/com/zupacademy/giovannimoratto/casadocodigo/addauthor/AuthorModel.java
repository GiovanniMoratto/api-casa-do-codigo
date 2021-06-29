package br.com.zupacademy.giovannimoratto.casadocodigo.addauthor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TB_AUTORES")
public class AuthorModel {

	/* Attributes */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@NotBlank
	@Column(name = "NOME", nullable = false)
	private String name;
	@NotBlank
	@Email
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@NotBlank
	@Size(max = 400)
	@Column(name = "DESCRICAO", length = 400, nullable = false)
	private String description;
	@CreationTimestamp
	@Column(name = "DATA_CRIACAO")
	private LocalDateTime createdAt;

	/* Constructor */
	public AuthorModel(@NotBlank String name, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String description) {
		super();
		this.name = name;
		this.email = email;
		this.description = description;
	}

}
