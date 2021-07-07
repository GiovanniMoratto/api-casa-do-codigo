package br.com.zupacademy.giovannimoratto.casadocodigo.book;

import br.com.zupacademy.giovannimoratto.casadocodigo.author.AuthorRepository;
import br.com.zupacademy.giovannimoratto.casadocodigo.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /* Dependencies Injection */
    @Autowired
    private BookRepository repository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /* Methods */
    // POST Request - Register a book
    @PostMapping
    @Transactional
    public void addBook(@RequestBody @Valid BookRequest request) {
        BookModel book = request.toModel(authorRepository, categoryRepository);
        repository.save(book);
    }

    // GET Request - List all books
    @GetMapping
    public ResponseEntity <List <BookResponse>> getBooks() {
        List <BookModel> books = repository.findAll();
        return ResponseEntity.ok(BookResponse.listConverter(books));
    }

    // GET Request - Search for a book
    @GetMapping("/{id}")
    public ResponseEntity <BookResponseDetail> getBookDetail(@PathVariable Long id) {
        Optional <BookModel> book = repository.findById(id);
        return book.map(bookModel -> ResponseEntity.ok(new BookResponseDetail(bookModel)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}