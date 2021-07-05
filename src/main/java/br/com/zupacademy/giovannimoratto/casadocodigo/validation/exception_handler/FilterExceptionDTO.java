package br.com.zupacademy.giovannimoratto.casadocodigo.validation.exception_handler;

/**
 * @Author giovanni.moratto
 */

public class FilterExceptionDTO {

    /* Attributes */
    private String field;
    private String error;

    /* Constructor */
    public FilterExceptionDTO(String field, String error) {
        super();
        this.field = field;
        this.error = error;
    }

    /* Getters */
    public String getField() {
        return field;
    }

    public String getError() {

        return error;
    }

}
