package br.com.zupacademy.giovannimoratto.casadocodigo.category;

import javax.persistence.*;

/**
 * @Author giovanni.moratto
 */

@Entity
@Table(name = "`TB_CATEGORIAS`")
public class CategoryModel {

    /* Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME", nullable = false, unique = true)
    private String name;

    /* Constructor */
    // Default - JPA
    @Deprecated
    public CategoryModel() {
    }

    // Method toModel() * CategoryRequest.class to CategoryModel.class
    public CategoryModel(String name) {
        this.name = name;
    }

}