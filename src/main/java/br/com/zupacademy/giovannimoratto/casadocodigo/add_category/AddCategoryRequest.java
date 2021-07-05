package br.com.zupacademy.giovannimoratto.casadocodigo.add_category;

import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

/**
 * @Author giovanni.moratto
 */

public class AddCategoryRequest {

    /* Attributes */
    @NotBlank
    @UniqueValue(attributeName = "name", className = CategoryModel.class)
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
