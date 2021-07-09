package br.com.zupacademy.giovannimoratto.casadocodigo.category;

import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

/**
 * @Author giovanni.moratto
 */

public class CategoryRequest {

    /* Attributes */
    @NotBlank
    @UniqueValue(fieldName = "name", domainClass = CategoryModel.class)
    private String name;

    /* Methods */
    // Convert CategoryRequest.class in CategoryModel.class
    public CategoryModel toModel() {
        return new CategoryModel(name);
    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}