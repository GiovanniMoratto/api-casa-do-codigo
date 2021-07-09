package br.com.zupacademy.giovannimoratto.casadocodigo.country;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * @Author giovanni.moratto
 */

@RestController
@RequestMapping("/pais") // Endpoint
public class CountryController {

    @PersistenceContext
    private EntityManager em;

    /* Methods */
    // POST Request - Register a country
    @PostMapping
    @Transactional
    public void addCountry(@RequestBody @Valid CountryRequest request) {
        CountryModel country = request.toModel();
        em.persist(country);
    }

}