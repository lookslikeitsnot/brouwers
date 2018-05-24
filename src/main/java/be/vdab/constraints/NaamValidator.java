package be.vdab.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NaamValidator implements ConstraintValidator<Naam, String>{

	@Override
	public boolean isValid(String naam, ConstraintValidatorContext context) {
		boolean valid = naam != null && !naam.trim().isEmpty();
		return valid;
	}

}
