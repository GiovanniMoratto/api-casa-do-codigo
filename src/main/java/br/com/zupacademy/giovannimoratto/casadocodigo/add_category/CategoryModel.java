package br.com.zupacademy.giovannimoratto.casadocodigo.add_category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_categorias")
public class CategoryModel {

	/* Attributes */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome", nullable = false)
	private String name;

	/* Constructor */
	@Deprecated
	public CategoryModel() {

	}

	public CategoryModel(@NotBlank String name) {
		this.name = name;
	}

}
