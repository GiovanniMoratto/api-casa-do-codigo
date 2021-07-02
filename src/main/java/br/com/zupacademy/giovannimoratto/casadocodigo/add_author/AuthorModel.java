package br.com.zupacademy.giovannimoratto.casadocodigo.add_author;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

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

    public AuthorModel(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

}
