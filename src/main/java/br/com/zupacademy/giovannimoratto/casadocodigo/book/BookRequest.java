package br.com.zupacademy.giovannimoratto.casadocodigo.book;

import br.com.zupacademy.giovannimoratto.casadocodigo.author.AuthorModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.category.CategoryModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.ExistsId;
import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author giovanni.moratto
 */

public class BookRequest {

    /* Attributes */
    @NotBlank
    @UniqueValue(fieldName = "title", domainClass = BookModel.class)
    private String title;
    @NotBlank
    @Size(max = 500)
    private String overview;
    private String summary;
    @NotNull
    @Min(20)
    private BigDecimal price;
    @NotNull
    @Min(100)
    private Integer numberOfPages;
    @NotBlank
    @UniqueValue(fieldName = "isbn", domainClass = BookModel.class)
    private String isbn;
    @Future
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate publicationDate;
    @NotNull
    @ExistsId(domainClass = CategoryModel.class)
    private Long idCategory;
    @NotNull
    @ExistsId(domainClass = AuthorModel.class)
    private Long idAuthor;

    /* Methods */
    // Convert BookRequest.class in BookModel.class
    public BookModel toModel(EntityManager em) throws ResponseStatusException {
        CategoryModel category = em.find(CategoryModel.class, idCategory);
        AuthorModel author = em.find(AuthorModel.class, idAuthor);

        return new BookModel(title, overview, summary, price, numberOfPages, isbn, publicationDate, category, author);
    }

    /* Getters and Setters */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

}