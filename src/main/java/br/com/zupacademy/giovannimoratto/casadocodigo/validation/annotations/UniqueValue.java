package br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations;

import javax.validation.*;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({FIELD})
@Constraint(validatedBy = {UniqueValueValidator.class})
public @interface UniqueValue {

    Class<?> className();

    String attributeName();

    String message() default "This value already exists!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
