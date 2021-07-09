package br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author giovanni.moratto
 */

public class UniqueValueValidator implements ConstraintValidator <UniqueValue, String> {

    @PersistenceContext
    private EntityManager em;

    /* Attributes */
    private String object;
    private String field;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        object = constraintAnnotation.domainClass().getSimpleName();
        field = constraintAnnotation.fieldName();
    }

    @Override
    @Transactional
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return false;
        }

        Query query = em.createQuery("SELECT 1 FROM " + object + " WHERE " + field + " = :VALUE");
        query.setParameter("VALUE", value);

        return query.getResultList().isEmpty();
    }

}