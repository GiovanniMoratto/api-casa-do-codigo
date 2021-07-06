package br.com.zupacademy.giovannimoratto.casadocodigo.state;

import br.com.zupacademy.giovannimoratto.casadocodigo.country.CountryModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author giovanni.moratto
 */

@Entity
@Table(name = "`TB_ESTADOS`")
public class StateModel {

    /* Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`")
    private Long id;
    @NotBlank
    @Column(name = "`NOME`", nullable = false, unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "`PAIS_ID`")
    private CountryModel country;

    /* Constructor */
    //Default
    @Deprecated
    public StateModel() {
    }

    //Method toModel() * AddStateRequest(DTO) to StateModel(Model)
    public StateModel(@NotBlank String name, @NotNull CountryModel country) {
        this.name = name;
        this.country = country;
    }
}