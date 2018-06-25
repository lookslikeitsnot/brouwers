package be.vdab.restclients;

import java.math.BigDecimal;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import be.vdab.exceptions.KanWeerNietLezenException;

@Component
public class OpenWeatherWeerClient implements WeerClient {
	private final static Logger LOGGER = Logger.getLogger(OpenWeatherWeerClient.class.getName());
	private final URI beginOpenWeatherURL;
	private final URI eindeOpenWeatherURL;
	private final RestTemplate restTemplate;

	OpenWeatherWeerClient(@Value("${beginWeerURL}") URI beginOpenWeatherURL, @Value("${eindeWeerURL}") URI eindeOpenWeatherURL, RestTemplate restTemplate) {
		this.beginOpenWeatherURL = beginOpenWeatherURL;
		this.eindeOpenWeatherURL = eindeOpenWeatherURL;
		this.restTemplate = restTemplate;
	}

	@Override
	public BigDecimal getTemperatuur(String stad) {
		try {
			
			Temperatuur temperatuur = restTemplate.getForObject(beginOpenWeatherURL + stad + eindeOpenWeatherURL, Temperatuur.class);
			return temperatuur.getTemperatuur();
		} catch (RestClientException ex) {
			LOGGER.log(Level.SEVERE, "kan koers niet lezen", ex);
			throw new KanWeerNietLezenException();
		}
	}

}
