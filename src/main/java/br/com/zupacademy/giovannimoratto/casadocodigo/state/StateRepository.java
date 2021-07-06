package br.com.zupacademy.giovannimoratto.casadocodigo.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author giovanni.moratto
 */

@Repository
public interface StateRepository extends JpaRepository<StateModel, Long> {

}