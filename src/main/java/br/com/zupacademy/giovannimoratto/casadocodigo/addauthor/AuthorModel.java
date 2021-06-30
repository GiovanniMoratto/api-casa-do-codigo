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
@Table(name = "tb_autores")
public class AuthorModel {

	/* Attributes */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome", nullable = false)
	private String name;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "descricao", length = 400, nullable = false)
	private String description;
	@CreationTimestamp
	@Column(name = "data_criacao")
	private LocalDateTime createdAt;

	/* Constructor */
	@Deprecated
	public AuthorModel() {

	}

	public AuthorModel(@NotBlank String name, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String description) {
		this.name = name;
		this.email = email;
		this.description = description;
	}

}
