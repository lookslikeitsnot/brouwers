package be.vdab.restclients;

import java.math.BigDecimal;
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
	private final String openWeatherURL;
	private final RestTemplate restTemplate;

	OpenWeatherWeerClient(@Value("${openWeatherURL}") String openWeatherURL, RestTemplate restTemplate) {
		this.openWeatherURL = openWeatherURL;
		this.restTemplate = restTemplate;
	}

	@Override
	public BigDecimal getStadsTemperatuur(String stad) {
		try {
			Current current = restTemplate.getForObject(openWeatherURL, Current.class, stad);
			return current.getTemperature().getValue();
		} catch (RestClientException ex) {
			LOGGER.log(Level.SEVERE, "kan weer niet lezen", ex);
			throw new KanWeerNietLezenException();
		}
	}

}
