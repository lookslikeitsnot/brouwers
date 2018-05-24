package be.vdab.valueobjects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;

public class Naam {
	@SafeHtml
	@NotNull
	@be.vdab.constraints.Naam
	private String name;

	public String getName() {
		return name;
	}
}
