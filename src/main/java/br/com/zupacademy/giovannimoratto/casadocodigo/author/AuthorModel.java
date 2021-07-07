package br.com.zupacademy.giovannimoratto.casadocodigo.author;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author giovanni.moratto
 */

@Entity
@Table(name = "`TB_AUTORES`")
public class AuthorModel {

    /* Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME", nullable = false)
    private String name;
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;
    @Column(name = "DESCRICAO", nullable = false, length = 400)
    private String description;
    @CreationTimestamp
    @Column(name = "DATA_CRIACAO", nullable = false)
    private LocalDateTime createdAt;

    /* Constructors */
    // Default - JPA
    @Deprecated
    public AuthorModel() {
    }

    // Method toModel() * AuthorRequest.class to AuthorModel.class
    public AuthorModel(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    /* Getters and Setters */
    // Getter for BookResponseDetail.class
    public String getName() {
        return name;
    }

}