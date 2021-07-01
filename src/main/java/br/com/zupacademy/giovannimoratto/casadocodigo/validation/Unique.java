package br.com.zupacademy.giovannimoratto.casadocodigo.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ FIELD })
@Constraint(validatedBy = { UniqueValidator.class })
public @interface Unique {

	Class<?> className();

	String attributeName();

	String message() default "This value already exists!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
