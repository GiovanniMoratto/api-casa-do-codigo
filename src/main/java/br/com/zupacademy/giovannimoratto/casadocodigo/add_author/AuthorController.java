package br.com.zupacademy.giovannimoratto.casadocodigo.add_author;

import org.springframework.web.bind.annotation.*;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/novo-autor")
public class AuthorController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public void addAuthor(@RequestBody @Valid AddAuthorRequest request) {

        AuthorModel author = request.toModel();
        em.persist(author);

    }

}
