package br.com.zupacademy.giovannimoratto.casadocodigo.payment_flow.customer;

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
@RequestMapping("/cliente") // Endpoint
public class CustomerController {

    @PersistenceContext
    private EntityManager em;

    /* Methods */
    // POST Request - Register a customer
    @PostMapping
    @Transactional
    public String addCategory(@RequestBody @Valid CustomerRequest request) {
        CustomerModel customer = request.toModel(em);
        em.persist(customer);

        return customer.toString();
    }

}