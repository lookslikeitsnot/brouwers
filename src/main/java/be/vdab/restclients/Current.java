package be.vdab.restclients;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "current")
public class Current {
	private Temperature temperature;

	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}
}
