package br.com.zupacademy.giovannimoratto.casadocodigo.state;

import br.com.zupacademy.giovannimoratto.casadocodigo.country.CountryModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.country.CountryRepository;
import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.ExistsId;
import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.UniqueValue;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @Author giovanni.moratto
 */

public class StateRequest {

    /* Attributes */
    @NotBlank
    @UniqueValue(attributeName = "name", className = StateModel.class)
    private String name;
    @NotNull
    @ExistsId(className = CountryModel.class)
    private Long idCountry;

    /* Methods */
    // Convert StateRequest.class in StateModel.class
    public StateModel toModel(CountryRepository countryRepository) throws ResponseStatusException {
        Optional <CountryModel> countryOptional = countryRepository.findById(idCountry);
        CountryModel country;
        country = countryOptional.orElseGet(() -> countryOptional.orElse(null));
        return new StateModel(
                name,
                country
        );
    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdPais() {
        return idCountry;
    }

    public void setIdPais(Long idPais) {
        this.idCountry = idPais;
    }

}
