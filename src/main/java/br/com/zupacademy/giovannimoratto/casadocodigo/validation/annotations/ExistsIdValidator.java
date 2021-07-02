package br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Long> {

    @PersistenceContext
    private EntityManager em;

    /* Attributes */
    private String object;

    @Override
    public void initialize(ExistsId constraintAnnotation) {
        object = constraintAnnotation.className().getSimpleName();
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        boolean exists = false;

        if (id == null) {
            return false;
        }

        Query query = em.createQuery("SELECT 1 FROM " + object + " WHERE ID = :VALUE");
        query.setParameter("VALUE", id);

        if (!query.getResultList().isEmpty()) {
            exists = true;
        } else {
            exists = false;
        }

        return exists;
    }

}
