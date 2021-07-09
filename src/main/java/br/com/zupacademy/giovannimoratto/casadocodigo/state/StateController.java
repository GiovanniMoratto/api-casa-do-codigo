package br.com.zupacademy.giovannimoratto.casadocodigo.state;

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
@RequestMapping("/estado") // Endpoint
public class StateController {

    @PersistenceContext
    private EntityManager em;

    /* Methods */
    // POST Request - Register a state
    @PostMapping
    @Transactional
    public void addState(@RequestBody @Valid StateRequest request) {
        StateModel state = request.toModel(em);
        em.persist(state);
    }

}