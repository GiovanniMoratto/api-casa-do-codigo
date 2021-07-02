package br.com.zupacademy.giovannimoratto.casadocodigo.add_book;

import br.com.zupacademy.giovannimoratto.casadocodigo.add_author.AuthorModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.add_category.CategoryModel;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "`TB_LIVROS`")
public class BookModel {

    /* Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`")
    private Long id;
    @Column(name = "`TITULO`", nullable = false, unique = true)
    private String title;
    @Column(name = "`RESUMO`", nullable = false, length = 500)
    private String overview;
    @Column(name = "`SUMARIO`")
    private String summary;
    @Column(name = "`PRECO`", nullable = false)
    private BigDecimal price;
    @Column(name = "`NUMERO_PAGINAS`", nullable = false)
    private Integer numberOfPages;
    @Column(name = "`ISBN`", nullable = false, unique = true)
    private String isbn;
    @Column(name = "`DATA_PUBLICACAO`", nullable = false)
    private LocalDate publicationDate;
    @ManyToOne
    @JoinColumn(name = "`CATEGORIA_ID`")
    private CategoryModel category;
    @ManyToOne
    @JoinColumn(name = "`AUTOR_ID`")
    private AuthorModel author;

    /* Constructor */
    @Deprecated
    public BookModel() {

    }

    public BookModel(String title, String overview, String summary, BigDecimal price, Integer numberOfPages,
                     String isbn, LocalDate publicationDate, CategoryModel category, AuthorModel author) {
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

}
