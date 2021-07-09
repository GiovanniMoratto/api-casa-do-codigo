package br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author giovanni.moratto
 */

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})

@Target({
        ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER, ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {

    Class <?> domainClass();

    String fieldName();

    String message() default "This value already exists!";

    Class <?>[] groups() default {};

    Class <? extends Payload>[] payload() default {};

}