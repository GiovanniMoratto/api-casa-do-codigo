package br.com.zupacademy.giovannimoratto.casadocodigo.payment_flow.customer;


import br.com.zupacademy.giovannimoratto.casadocodigo.country.CountryModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.state.StateModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.CPForCNPJ;
import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.ExistsId;
import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.UniqueValue;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;

/**
 * @Author giovanni.moratto
 */

public class CustomerRequest {

    /* Attributes */
    @NotBlank
    @Email
    @UniqueValue(fieldName = "email", domainClass = CustomerModel.class)
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @CPForCNPJ
    @UniqueValue(fieldName = "document", domainClass = CustomerModel.class)
    private String document;
    @NotBlank
    private String address;
    @NotBlank
    private String complement;
    @NotBlank
    private String city;
    @NotNull
    @ExistsId(domainClass = CountryModel.class)
    private Long idCountry;
    @ExistsId(domainClass = StateModel.class)
    private Long idState;
    @NotBlank
    @Size(min = 10, max = 14)
    @Digits(fraction = 0, integer = 10)
    private String phoneNumber;
    @NotBlank
    @Size(min = 5, max = 14)
    @Digits(fraction = 0, integer = 10)
    private String zipCode;

    /* Methods */
    // Convert CustomerRequest.class in CustomerModel.class
    public CustomerModel toModel(EntityManager em) throws ResponseStatusException {
        CountryModel country = em.find(CountryModel.class, idCountry);
        CustomerModel customer = new CustomerModel(email, firstName, lastName, document, address, complement
                , city, country, phoneNumber, zipCode
        );

        if (idState != null) {
            StateModel state = em.find(StateModel.class, idState);
            customer.setState(state);
        }

        return customer;
    }

    /* Getters and Setters */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    public Long getIdState() {
        return idState;
    }

    public void setIdState(Long idState) {
        this.idState = idState;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}