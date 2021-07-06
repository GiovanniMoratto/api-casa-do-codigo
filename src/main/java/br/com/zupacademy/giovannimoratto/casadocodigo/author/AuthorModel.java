package br.com.zupacademy.giovannimoratto.casadocodigo.author;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @Author giovanni.moratto
 */

@Entity
@Table(name = "`TB_AUTORES`")
public class AuthorModel {

    /*Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`")
    private Long id;
    @NotBlank
    @Column(name = "`NOME`", nullable = false)
    private String name;
    @NotBlank
    @Email
    @Column(name = "`EMAIL`", nullable = false, unique = true)
    private String email;
    @NotBlank
    @Size(max = 400)
    @Column(name = "`DESCRICAO`", nullable = false, length = 400)
    private String description;
    @CreationTimestamp
    @Column(name = "`DATA_CRIACAO`", nullable = false)
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

    /* Getter for BookDetailDTO.class */
    public String getName() {
        return name;
    }
}
