package br.com.zupacademy.giovannimoratto.casadocodigo.country;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @Author giovanni.moratto
 */

@Entity
@Table(name = "`TB_PAISES`")
public class CountryModel {

    /* Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`")
    private Long id;
    @NotBlank
    @Column(name = "`NOME`", nullable = false, unique = true)
    private String name;

    /* Constructor */
    //Default
    @Deprecated
    public CountryModel() {
    }

    //Method toModel() * AddCountryRequest(DTO) to CountryModel(Model)
    public CountryModel(String name) {
        this.name = name;
    }

}