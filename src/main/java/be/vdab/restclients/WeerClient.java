package be.vdab.restclients;

import java.math.BigDecimal;

public interface WeerClient {
	BigDecimal getStadsTemperatuur(String stad);
}
