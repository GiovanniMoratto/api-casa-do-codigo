package br.com.zupacademy.giovannimoratto.casadocodigo.book;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author giovanni.moratto
 */

public class BookDetailDTO {

    /* Attributes */
    private String title;
    private String overview;
    private String summary;
    private BigDecimal price;
    private Integer numberOfPages;
    private String isbn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate publicationDate;
    private String author;

    /* Constructors */
    //Default
    @Deprecated
    public BookDetailDTO() {
    }

    //Get the BookModel values and set in BookDetailDTO
    public BookDetailDTO(BookModel bookModel) {
        this.title = bookModel.getTitle();
        this.overview = bookModel.getOverview();
        this.summary = bookModel.getSummary();
        this.price = bookModel.getPrice();
        this.numberOfPages = bookModel.getNumberOfPages();
        this.isbn = bookModel.getIsbn();
        this.publicationDate = bookModel.getPublicationDate();
        this.author = bookModel.getAuthor().getName();
    }

    /* Methods */
    //Convert a BookModel List in BookDetailDTO List
    public static List<BookDetailDTO> listDetailConverter(List<BookModel> books) {
        return books.stream().map(BookDetailDTO::new).collect(Collectors.toList());
    }

    /* Getters */
    public String getTitle() {
        return title;
    }

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

    public String getAuthor() {
        return author;
    }

}