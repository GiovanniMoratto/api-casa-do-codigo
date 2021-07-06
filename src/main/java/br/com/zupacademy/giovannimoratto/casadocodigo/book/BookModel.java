package br.com.zupacademy.giovannimoratto.casadocodigo.book;

import br.com.zupacademy.giovannimoratto.casadocodigo.author.AuthorModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.category.CategoryModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Column(name = "`ID`")
    private Long id;
    @NotBlank
    @Column(name = "`TITULO`", nullable = false, unique = true)
    private String title;
    @NotBlank
    @Size(max = 500)
    @Column(name = "`RESUMO`", nullable = false, length = 500)
    private String overview;
    @Column(name = "`SUMARIO`")
    private String summary;
    @NotNull
    @Min(20)
    @Column(name = "`PRECO`", nullable = false)
    private BigDecimal price;
    @NotNull
    @Min(100)
    @Column(name = "`NUMERO_PAGINAS`", nullable = false)
    private Integer numberOfPages;
    @NotBlank
    @Column(name = "`ISBN`", nullable = false, unique = true)
    private String isbn;
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "`DATA_PUBLICACAO`", nullable = false)
    private LocalDate publicationDate;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "`CATEGORIA_ID`")
    private CategoryModel category;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "`AUTOR_ID`")
    private AuthorModel author;

    /* Constructors */
    @Deprecated
    public BookModel() {

    }

    public BookModel(@NotBlank String title, @NotBlank @Size(max = 500) String overview,
                     String summary, @NotNull @Min(20) BigDecimal price,
                     @NotNull @Min(100) Integer numberOfPages, @NotBlank String isbn,
                     @Future @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") LocalDate publicationDate,
                     @NotNull CategoryModel category, @NotNull AuthorModel author) {
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

    /* Getters for GetBookDTO.class */
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    /* Complete Getters for BookDatailDTO.class */
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
