package be.vdab.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import be.vdab.restclients.WeerClient;

@Service
public class WeerServiceImpl implements WeerService{
	private final WeerClient weerClient;
	public WeerServiceImpl(WeerClient weerClient) {
		this.weerClient = weerClient;
	}
	@Override
	public BigDecimal stadsTemperatuur(String stad) {
		return weerClient.getStadsTemperatuur(stad);
	}
}
