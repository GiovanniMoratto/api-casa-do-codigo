package br.com.zupacademy.giovannimoratto.casadocodigo.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author giovanni.moratto
 */

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {

}