package br.com.zupacademy.giovannimoratto.casadocodigo.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

	@PersistenceContext
	private EntityManager em;
	private String object;
	private String field;

	@Override
	public void initialize(Unique constraintAnnotation) {
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

		if (query.getResultList().isEmpty()) {
			uniqueValue = true;
		} else {
			uniqueValue = false;
		}

		return uniqueValue;
	}

}
