package br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations;

import br.com.zupacademy.giovannimoratto.casadocodigo.state.StateModel;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author giovanni.moratto
 */

@Documented
@Retention(RUNTIME)
@Target({TYPE, FIELD})
@Constraint(validatedBy = {UniqueStateInCountryValidator.class})
public @interface UniqueStateInCountry {

    Class <StateModel> entityName();

    String message() default "This State value already exists for this Country!";

    Class <?>[] groups() default {};

    Class <? extends Payload>[] payload() default {};

}
