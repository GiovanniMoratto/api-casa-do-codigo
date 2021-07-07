package br.com.zupacademy.giovannimoratto.casadocodigo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * @Author giovanni.moratto
 */

@RestController
@RequestMapping("/categoria") // Endpoint
public class CategoryController {

    /* Dependencies Injection */
    @Autowired
    private CategoryRepository repository;

    /* Methods */
    // POST Request - Register a category
    @PostMapping
    @Transactional
    public void addCategory(@RequestBody @Valid CategoryRequest request) {
        CategoryModel category = request.toModel();
        repository.save(category);
    }

}