package be.vdab.entities;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.vdab.constraints.Naam;
import be.vdab.valueobjects.Adres;

public class Brouwer implements Serializable {
	private static final long serialVersionUID = 1L;
	private long brouwerNr;
	@SafeHtml(whitelistType=WhiteListType.NONE)
	@NotNull
	@Naam
	private String naam;
	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@Min(0)
	@Digits(integer = 10, fraction = 2)
	private Integer omzet;
	@NotNull
	@Valid
	private Adres adres;
	
	public Brouwer() {}

	public Brouwer(long brouwerNr, String naam, Integer omzet, Adres adres) {
		this.brouwerNr = brouwerNr;
		this.naam = naam;
		this.omzet = omzet;
		this.adres = adres;
	}

	public long getBrouwerNr() {
		return brouwerNr;
	}

	public void setBrouwerNr(long brouwerNr) {
		this.brouwerNr = brouwerNr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Integer getOmzet() {
		return omzet;
	}

	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

}
