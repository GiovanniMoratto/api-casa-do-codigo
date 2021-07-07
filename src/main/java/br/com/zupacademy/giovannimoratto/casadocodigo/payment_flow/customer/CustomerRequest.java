package br.com.zupacademy.giovannimoratto.casadocodigo.payment_flow.customer;


import br.com.zupacademy.giovannimoratto.casadocodigo.country.CountryModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.country.CountryRepository;
import br.com.zupacademy.giovannimoratto.casadocodigo.state.StateModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.state.StateRepository;
import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.ExistsId;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @Author giovanni.moratto
 */

public class CustomerRequest {

    /* Attributes */
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String document;
    @NotBlank
    private String address;
    private String complement;
    @NotBlank
    private String city;
    @NotNull
    @ExistsId(className = CountryModel.class)
    private Long idCountry;
    @NotNull
    @ExistsId(className = StateModel.class)
    private Long idState;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String zipCode;

    /* Methods */
    // Convert CustomerRequest.class in CustomerModel.class
    public CustomerModel toModel(CountryRepository countryRepository, StateRepository stateRepository) throws ResponseStatusException {
        Optional <CountryModel> countryOptional = countryRepository.findById(idCountry);
        Optional <StateModel> stateOptional = stateRepository.findById(idState);
        CountryModel country;
        StateModel state;
        if (countryOptional.isPresent() & stateOptional.isPresent()) {
            country = countryOptional.get();
            state = stateOptional.get();
        }
        else {
            country = countryOptional.orElse(null);
            state = stateOptional.orElse(null);
        }
        return new CustomerModel(
                email,
                firstName,
                lastName,
                document,
                address,
                complement,
                city,
                country,
                state,
                phoneNumber,
                zipCode
        );
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
