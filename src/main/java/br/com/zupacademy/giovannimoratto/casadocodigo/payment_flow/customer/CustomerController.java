package br.com.zupacademy.giovannimoratto.casadocodigo.payment_flow.customer;

import br.com.zupacademy.giovannimoratto.casadocodigo.country.CountryRepository;
import br.com.zupacademy.giovannimoratto.casadocodigo.state.StateRepository;
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
@RequestMapping("/cliente") // Endpoint
public class CustomerController {

    /* Dependencies Injection */
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private StateRepository stateRepository;

    /* Methods */
    // POST Request - Register a customer
    @PostMapping
    @Transactional
    public void addCategory(@RequestBody @Valid CustomerRequest request) {
        CustomerModel customer = request.toModel(countryRepository, stateRepository);
        repository.save(customer);
    }

}