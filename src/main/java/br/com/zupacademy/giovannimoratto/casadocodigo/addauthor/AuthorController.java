package br.com.zupacademy.giovannimoratto.casadocodigo.addauthor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
