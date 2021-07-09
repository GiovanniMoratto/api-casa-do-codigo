package br.com.zupacademy.giovannimoratto.casadocodigo.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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