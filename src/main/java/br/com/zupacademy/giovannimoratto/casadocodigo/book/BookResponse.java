package br.com.zupacademy.giovannimoratto.casadocodigo.book;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author giovanni.moratto
 */

public class BookResponse {

    /* Attributes */
    private Long id;
    private String name;

    /* Constructor */
    // Default
    @Deprecated
    public BookResponse() {
    }

    // Get the BookModel.class values and set in BookResponse.class
    public BookResponse(BookModel bookModel) {
        this.id = bookModel.getId();
        this.name = bookModel.getTitle();
    }

    /* Methods */
    // Convert a BookModel.class List in BookResponse.class List
    public static List <BookResponse> listConverter(List <BookModel> books) {
        return books.stream().map(BookResponse::new).collect(Collectors.toList());
    }

    /* Getters */
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}