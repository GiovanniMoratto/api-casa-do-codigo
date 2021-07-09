package br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations;

import br.com.zupacademy.giovannimoratto.casadocodigo.state.StateModel;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author giovanni.moratto
 */

@Documented
@Constraint(validatedBy = {UniqueStateInCountryValidator.class})
@Target({
        ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER, ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueStateInCountry {

    Class <StateModel> domainClass();

    String message() default "This State value already exists for this Country!";

    Class <?>[] groups() default {};

    Class <? extends Payload>[] payload() default {};

}
