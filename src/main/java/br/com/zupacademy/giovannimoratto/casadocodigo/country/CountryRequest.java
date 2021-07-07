package br.com.zupacademy.giovannimoratto.casadocodigo.country;

import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

/**
 * @Author giovanni.moratto
 */

public class CountryRequest {

    /* Attributes */
    @NotBlank
    @UniqueValue(attributeName = "name", className = CountryModel.class)
    private String name;

    /* Methods */
    // Convert CountryRequest.class in CountryModel.class
    public CountryModel toModel() {
        return new CountryModel(name);
    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}