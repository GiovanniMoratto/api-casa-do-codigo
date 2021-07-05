package br.com.zupacademy.giovannimoratto.casadocodigo.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author giovanni.moratto
 */

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

}
