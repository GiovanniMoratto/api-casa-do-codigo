package br.com.zupacademy.giovannimoratto.casadocodigo.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * @Author giovanni.moratto
 */

@RestController
@RequestMapping("/pais")
public class CountryController {

    @Autowired
    private CountryRepository repository;

    @PostMapping
    @Transactional
    public void addCountry(@RequestBody @Valid AddCountryRequest request) {
        CountryModel country = request.toModel();
        repository.save(country);
    }

}