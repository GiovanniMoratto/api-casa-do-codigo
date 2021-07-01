package br.com.zupacademy.giovannimoratto.casadocodigo.add_category;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.giovannimoratto.casadocodigo.validation.Unique;

public class AddCategoryRequest {

	/* Attributes */
	@NotBlank
	@Unique(attribute_name = "name", class_name = CategoryModel.class)
	private String name;

	/* Getters and Setters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* Methods */
	public CategoryModel toModel() {
		return new CategoryModel(name);
	}

}
