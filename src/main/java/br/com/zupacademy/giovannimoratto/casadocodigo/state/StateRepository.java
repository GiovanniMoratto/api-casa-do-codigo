package br.com.zupacademy.giovannimoratto.casadocodigo.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author giovanni.moratto
 */

@Repository
public interface StateRepository extends JpaRepository <StateModel, Long> {

    List <StateModel> findCountryById(Long idCountry);

}