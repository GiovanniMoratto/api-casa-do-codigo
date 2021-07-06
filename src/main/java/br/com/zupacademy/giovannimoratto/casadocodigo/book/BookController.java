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
@RequestMapping("/livro")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    @Transactional
    public void addBook(@RequestBody @Valid AddBookRequest request) {
        BookModel book = request.toModel(authorRepository, categoryRepository);
        bookRepository.save(book);
    }

    @GetMapping
    public ResponseEntity<List<GetBooksDTO>> getBooks() {
        List<BookModel> books = bookRepository.findAll();
        return ResponseEntity.ok(GetBooksDTO.listConverter(books));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailDTO> getBookDetail(@PathVariable Long id) {
        Optional<BookModel> book = bookRepository.findById(id);
        return book.map(bookModel -> ResponseEntity.ok(new BookDetailDTO(bookModel)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}