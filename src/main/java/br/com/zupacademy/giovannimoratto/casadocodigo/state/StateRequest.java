package br.com.zupacademy.giovannimoratto.casadocodigo.state;

import br.com.zupacademy.giovannimoratto.casadocodigo.country.CountryModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.ExistsId;
import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.UniqueStateInCountry;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author giovanni.moratto
 */

@UniqueStateInCountry(domainClass = StateModel.class)
public class StateRequest {

    /* Attributes */
    @NotBlank
    private String name;
    @NotNull
    @ExistsId(domainClass = CountryModel.class)
    private Long idCountry;

    /* Methods */
    // Convert StateRequest.class in StateModel.class
    public StateModel toModel(EntityManager em) {
        CountryModel country = em.find(CountryModel.class, idCountry);

        return new StateModel(name, country);
    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

}