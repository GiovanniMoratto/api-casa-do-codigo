package br.com.zupacademy.giovannimoratto.casadocodigo.book;

import br.com.zupacademy.giovannimoratto.casadocodigo.author.AuthorModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.category.CategoryModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author giovanni.moratto
 */

@Entity
@Table(name = "`TB_LIVROS`")
public class BookModel {

    /* Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITULO", nullable = false, unique = true)
    private String title;
    @Column(name = "RESUMO", nullable = false, length = 500)
    private String overview;
    @Column(name = "SUMARIO")
    private String summary;
    @Column(name = "PRECO", nullable = false)
    private BigDecimal price;
    @Column(name = "NUMERO_PAGINAS", nullable = false)
    private Integer numberOfPages;
    @Column(name = "ISBN", nullable = false, unique = true)
    private String isbn;
    @Column(name = "DATA_PUBLICACAO", nullable = false)
    private LocalDate publicationDate;
    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA", nullable = false)
    private CategoryModel category;
    @ManyToOne
    @JoinColumn(name = "ID_AUTOR", nullable = false)
    private AuthorModel author;

    /* Constructors */
    // Default - JPA
    @Deprecated
    public BookModel() {
    }

    // Method toModel() * BookRequest.class to BookModel.class
    public BookModel(String title, String overview, String summary, BigDecimal price,
                     Integer numberOfPages, String isbn, LocalDate publicationDate,
                     CategoryModel category, AuthorModel author) {
        this.title = title;
        this.overview = overview;
        this.summary = summary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.category = category;
        this.author = author;
    }

    /* Getters and Setters */
    // Getters for BookResponse.class
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // Complete Getters for BookResponseDetail.class
    public String getOverview() {
        return overview;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public AuthorModel getAuthor() {
        return author;
    }

}