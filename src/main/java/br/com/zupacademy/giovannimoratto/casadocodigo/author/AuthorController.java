package br.com.zupacademy.giovannimoratto.casadocodigo.author;

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
@RequestMapping("/autor")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @PostMapping
    @Transactional
    public void addAuthor(@RequestBody @Valid AddAuthorRequest request) {
        AuthorModel author = request.toModel();
        repository.save(author);
    }
}