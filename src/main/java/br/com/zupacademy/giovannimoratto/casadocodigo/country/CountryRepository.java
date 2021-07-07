package br.com.zupacademy.giovannimoratto.casadocodigo.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author giovanni.moratto
 */

@Repository
public interface CountryRepository extends JpaRepository <CountryModel, Long> {

}