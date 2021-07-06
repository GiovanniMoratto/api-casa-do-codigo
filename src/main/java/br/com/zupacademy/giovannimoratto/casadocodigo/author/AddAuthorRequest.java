package br.com.zupacademy.giovannimoratto.casadocodigo.author;

import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Author giovanni.moratto
 */

public class AddAuthorRequest {

    /* Attributes */
    @NotBlank
    private String name;
    @NotBlank
    @Email
    @UniqueValue(attributeName = "email", className = AuthorModel.class)
    private String email;
    @NotBlank
    @Size(max = 400)
    private String description;

    /* Methods */
    //Convert request in Model
    public AuthorModel toModel() {
        return new AuthorModel(name, email, description);
    }

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

}