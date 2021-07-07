package br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author giovanni.moratto
 */

@Documented
@Retention(RUNTIME)
@Target({FIELD})
@Constraint(validatedBy = {UniqueValueValidator.class})
public @interface UniqueValue {

    Class <?> className();

    String attributeName();

    String message() default "This value already exists!";

    Class <?>[] groups() default {};

    Class <? extends Payload>[] payload() default {};

}