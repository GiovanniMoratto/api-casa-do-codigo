package br.com.zupacademy.giovannimoratto.casadocodigo.add_category;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nova-categoria")
public class CategoryController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public void addCategory(@RequestBody @Valid AddCategoryRequest request) {

        CategoryModel category = request.toModel();
        em.persist(category);
    }
}
