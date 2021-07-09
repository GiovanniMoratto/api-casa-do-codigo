package br.com.zupacademy.giovannimoratto.casadocodigo.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @Author giovanni.moratto
 */

@RestController
@RequestMapping("/livro") // Endpoint
public class BookController {

    @PersistenceContext
    private EntityManager em;

    /* Methods */
    // POST Request - Register a book
    @PostMapping
    @Transactional
    public void addBook(@RequestBody @Valid BookRequest request) {
        BookModel book = request.toModel(em);
        em.persist(book);
    }

    // GET Request - List all books
    @GetMapping
    public ResponseEntity <List <BookResponse>> getBooks() {
        TypedQuery <BookModel> b = em.createQuery("SELECT x FROM BookModel x", BookModel.class);
        List <BookModel> books = b.getResultList();
        return ResponseEntity.ok(BookResponse.listConverter(books));
    }

    // GET Request - Search for a book
    @GetMapping("/{id}")
    public ResponseEntity <BookResponseDetail> getBookDetail(@PathVariable Long id) {
        BookModel book = Optional.ofNullable(em.find(BookModel.class, id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(new BookResponseDetail(book));
    }

}