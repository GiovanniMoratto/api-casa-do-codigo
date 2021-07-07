package br.com.zupacademy.giovannimoratto.casadocodigo.country;

import javax.persistence.*;

/**
 * @Author giovanni.moratto
 */

@Entity
@Table(name = "`TB_PAISES`")
public class CountryModel {

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
    public CountryModel() {
    }

    // Method toModel() * CountryRequest.class to CountryModel.class
    public CountryModel(String name) {
        this.name = name;
    }

}