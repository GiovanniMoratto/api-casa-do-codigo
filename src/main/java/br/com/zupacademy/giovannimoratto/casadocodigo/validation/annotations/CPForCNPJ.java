package br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author giovanni.moratto
 */

@Documented
@Constraint(validatedBy = {})
@ConstraintComposition(CompositionType.OR)
@CPF
@CNPJ
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPForCNPJ {

    String message() default "This field must have the format of a CPF or a CNPJ";

    Class <?>[] groups() default {};

    Class <? extends Payload>[] payload() default {};
}
