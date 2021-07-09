package br.com.zupacademy.giovannimoratto.casadocodigo.payment_flow.customer;

import br.com.zupacademy.giovannimoratto.casadocodigo.country.CountryModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.state.StateModel;

import javax.persistence.*;

/**
 * @Author giovanni.moratto
 */

@Entity
@Table(name = "`TB_CLIENTES`")
public class CustomerModel {

    /* Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "NOME", nullable = false)
    private String firstName;
    @Column(name = "SOBRENOME", nullable = false)
    private String lastName;
    @Column(name = "CPF_CNPJ", nullable = false)
    private String document;
    @Column(name = "ENDERECO", nullable = false)
    private String address;
    @Column(name = "COMPLEMENTO", nullable = false)
    private String complement;
    @Column(name = "CIDADE", nullable = false)
    private String city;
    @ManyToOne
    @JoinColumn(name = "ID_PAIS")
    private CountryModel country;
    @ManyToOne
    @JoinColumn(name = "ID_ESTADO")
    private StateModel state;
    @Column(name = "TELEFONE", nullable = false)
    private String phoneNumber;
    @Column(name = "CEP", nullable = false)
    private String zipCode;

    /* Constructors */
    // Default - JPA
    @Deprecated
    public CustomerModel() {
    }

    // Method toModel() * CustomerRequest.class to CustomerModel.class
    public CustomerModel(String email, String firstName, String lastName, String document, String address,
                         String complement, String city, CountryModel country, String phoneNumber,
                         String zipCode) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
               "id=" + id +
               '}';
    }

    /* Getters and Setters */
    // Setter to CustomerRequest.class
    public void setState(StateModel state) {
        this.state = state;
    }
}
