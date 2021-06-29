package br.com.zupacademy.giovannimoratto.casadocodigo.handler_exception;

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
