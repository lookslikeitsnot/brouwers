package be.vdab.valueobjects;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class Adres implements Serializable {
	private static final long serialVersionUID = 1L;
	@SafeHtml(whitelistType=WhiteListType.NONE)
	@NotBlank
	@Length(min = 1, max = 50)
	private String straat;
	@SafeHtml(whitelistType=WhiteListType.NONE)
	@NotBlank
	@Length(min = 1, max = 10)
	private String huisNr;
	@NotNull
	@NumberFormat(style = Style.NUMBER) // opmaak annotation die er al stond
	@NotNull
	@Min(1000)
	@Max(9999)
	private Integer postcode;
	@SafeHtml(whitelistType=WhiteListType.NONE)
	@NotBlank
	@Length(min = 1, max = 50)
	private String gemeente;
	
	public Adres() {}

	public Adres(String straat, String huisNr, Integer postcode, String gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
	
}