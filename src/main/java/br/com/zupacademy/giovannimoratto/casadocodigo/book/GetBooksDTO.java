package br.com.zupacademy.giovannimoratto.casadocodigo.book;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author giovanni.moratto
 */

public class GetBooksDTO {

    private Long id;
    private String name;

    /* Constructor */
    @Deprecated
    public GetBooksDTO() {

    }

    public GetBooksDTO(BookModel bookModel) {
        this.id = bookModel.getId();
        this.name = bookModel.getTitle();
    }

    /* Methods */
    public static List<GetBooksDTO> listConverter(List<BookModel> books) {
        return books.stream().map(GetBooksDTO::new).collect(Collectors.toList());
    }

    /* Getters */
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
