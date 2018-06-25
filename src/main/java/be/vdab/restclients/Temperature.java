package be.vdab.restclients;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement (name = "temperature")
@XmlAccessorType(XmlAccessType.NONE)
public class Temperature {
	@XmlAttribute
	private BigDecimal value;
	@XmlAttribute
	private BigDecimal min;
	@XmlAttribute
	private BigDecimal max;
	@XmlAttribute
	private String unit;

	public BigDecimal getMin() {
		return min;
	}

	public void setMin(BigDecimal min) {
		this.min = min;
	}

	public BigDecimal getMax() {
		return max;
	}

	public void setMax(BigDecimal max) {
		this.max = max;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Temperature [value=" + value + ", min=" + min + ", max=" + max + ", unit=" + unit + "]";
	}
}
