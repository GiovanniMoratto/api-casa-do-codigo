package br.com.zupacademy.giovannimoratto.casadocodigo.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author giovanni.moratto
 */

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

}
