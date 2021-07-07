package br.com.zupacademy.giovannimoratto.casadocodigo.state;

import br.com.zupacademy.giovannimoratto.casadocodigo.country.CountryModel;

import javax.persistence.*;

/**
 * @Author giovanni.moratto
 */

@Entity
@Table(name = "`TB_ESTADOS`")
public class StateModel {

    /* Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "ID_PAIS", nullable = false)
    private CountryModel country;

    /* Constructor */
    // Default - JPA
    @Deprecated
    public StateModel() {
    }

    // Method toModel() * StateRequest.class to StateModel.class
    public StateModel(String name, CountryModel country) {
        this.name = name;
        this.country = country;
    }

}