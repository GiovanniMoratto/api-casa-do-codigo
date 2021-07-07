package br.com.zupacademy.giovannimoratto.casadocodigo.validation.annotations;

import br.com.zupacademy.giovannimoratto.casadocodigo.state.StateModel;
import br.com.zupacademy.giovannimoratto.casadocodigo.state.StateRequest;
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
    private Class <StateModel> state;

    @Override
    public void initialize(UniqueStateInCountry annotation) {
        state = annotation.entityName();
    }

    @Override
    public boolean isValid(StateRequest stateRequest, ConstraintValidatorContext context) {
        Query query = em.createQuery("SELECT s FROM " + state.getSimpleName() + " s WHERE s.name = :stateName AND s" +
                                     ".country.id" +
                                     " = :idCountry");
        query.setParameter("stateName", stateRequest.getName());
        query.setParameter("idCountry", stateRequest.getIdCountry());
        List <?> list = query.getResultList();

        Assert.isTrue(list.size() <= 1, "Existe mais de um registro no banco com nome" + stateRequest.getName() + "no" +
                                        " país " +
                                        "de id = " + stateRequest.getIdCountry());

        return list.isEmpty();
        /*
        return query.getResultList().isEmpty();
         */
    }

}
