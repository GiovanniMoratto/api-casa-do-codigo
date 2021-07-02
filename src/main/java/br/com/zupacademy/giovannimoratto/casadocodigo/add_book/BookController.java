package br.com.zupacademy.giovannimoratto.casadocodigo.add_book;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/novo-livro")
public class BookController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public void addBook(@RequestBody @Valid AddBookRequest request) {

        BookModel book = request.toModel(em);
        em.persist(book);
    }
}
