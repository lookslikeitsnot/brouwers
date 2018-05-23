package be.vdab.valueobjects;

import javax.validation.constraints.NotNull;

public class Naam {
	@NotNull
	@be.vdab.constraints.Naam
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String naam) {
		this.name = naam;
	}
}
