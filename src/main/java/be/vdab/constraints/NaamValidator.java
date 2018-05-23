package be.vdab.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NaamValidator implements ConstraintValidator<Naam, String>{

	@Override
	public boolean isValid(String naam, ConstraintValidatorContext context) {
		System.out.println("testing validation");
		return naam != null && !naam.isEmpty();
	}

}
