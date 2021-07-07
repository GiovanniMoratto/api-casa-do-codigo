package br.com.zupacademy.giovannimoratto.casadocodigo.payment_flow.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author giovanni.moratto
 */

@Repository
public interface CustomerRepository extends JpaRepository <CustomerModel, Long> {

}