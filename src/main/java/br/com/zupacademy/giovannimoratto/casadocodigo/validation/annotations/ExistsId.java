package br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations;

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
@Constraint(validatedBy = { ExistsIdValidator.class })
public @interface ExistsId {

    Class<?> className();

    String message() default "This ID does not exists!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
