package br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations;

import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import javax.validation.*;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

    @PersistenceContext
    private EntityManager em;

    /* Attributes */
    private String object;
    private String field;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        object = constraintAnnotation.className().getSimpleName();
        field = constraintAnnotation.attributeName();
    }

    @Override
    @Transactional
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean uniqueValue = false;

        if (value == null) {
            return false;
        }

        Query query = em.createQuery("SELECT 1 FROM " + object + " WHERE " + field + " = :VALUE");
        query.setParameter("VALUE", value);

        uniqueValue = query.getResultList().isEmpty();

        return uniqueValue;
    }

}
