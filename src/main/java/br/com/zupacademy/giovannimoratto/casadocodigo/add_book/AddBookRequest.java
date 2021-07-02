package br.com.zupacademy.giovannimoratto.casadocodigo.add_book;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.validation.constraints.*;

import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.UniqueValue;
import br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations.ExistsId;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.zupacademy.giovannimoratto.casadocodigo.add_author.AuthorModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.add_category.CategoryModel;

public class AddBookRequest {

    /* Attributes */
    @NotBlank
    @UniqueValue(attributeName = "title", className = BookModel.class)
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
    @UniqueValue(attributeName = "isbn", className = BookModel.class)
    private String isbn;
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate publicationDate;
    @NotNull
    @ExistsId(className = CategoryModel.class)
    private Long idCategory;
    @NotNull
    @ExistsId(className = AuthorModel.class)
    private Long idAuthor;

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

    /* Methods */
    public BookModel toModel(EntityManager em) {

        CategoryModel category = em.find(CategoryModel.class, this.idCategory);
        AuthorModel author = em.find(AuthorModel.class, this.idAuthor);

        return new BookModel(title, overview, summary, price, numberOfPages, isbn, publicationDate, category, author);
    }
}
