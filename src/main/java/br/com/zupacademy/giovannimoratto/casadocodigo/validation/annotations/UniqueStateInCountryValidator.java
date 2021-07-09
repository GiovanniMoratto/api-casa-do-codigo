package br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations;

import br.com.zupacademy.giovannimoratto.casadocodigo.state.StateModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.state.StateRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * @Author giovanni.moratto
 */

public class UniqueStateInCountryValidator implements ConstraintValidator <UniqueStateInCountry, StateRequest> {

    @PersistenceContext
    private EntityManager em;

    /* Attributes */
    private Class<StateModel> domainClass;

    @Override
    public void initialize(UniqueStateInCountry constraintAnnotation) {
        domainClass = constraintAnnotation.domainClass();
    }

    @Override
    @Transactional
    public boolean isValid(StateRequest request, ConstraintValidatorContext context) {

        Query query = em.createQuery("FROM " + domainClass.getSimpleName() +
                                     " x WHERE x.name = :stateName AND x.country.id = :idCountry");
        query.setParameter("stateName", request.getName());
        query.setParameter("idCountry", request.getIdCountry());

        return query.getResultList().isEmpty();
    }

}