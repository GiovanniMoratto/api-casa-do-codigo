package br.com.zupacademy.giovannimoratto.casadocodigo.category;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @Author giovanni.moratto
 */

@Entity
@Table(name = "`TB_CATEGORIAS`")
public class CategoryModel {

    /* Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`")
    private Long id;
    @NotBlank
    @Column(name = "`NOME`", nullable = false, unique = true)
    private String name;

    /* Constructor */
    @Deprecated
    public CategoryModel() {

    }

    public CategoryModel(String name) {
        this.name = name;
    }
}