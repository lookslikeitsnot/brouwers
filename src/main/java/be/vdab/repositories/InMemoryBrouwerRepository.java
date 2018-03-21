package be.vdab.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository
public class InMemoryBrouwerRepository implements BrouwerRepository {
	private final Map<Long, Brouwer> brouwers = new ConcurrentHashMap<>();
	
	public InMemoryBrouwerRepository() {
		brouwers.put(1L, new Brouwer(1, "Maredsous", 25000, new Adres("Keizerslaan", "11", 1000, "Brussel")));
		brouwers.put(2L, new Brouwer(2, "Orval", 15000, new Adres("Gasthuisstraat", "31", 1000, "Brussel")));
		brouwers.put(3L, new Brouwer(3, "Sambre", null, new Adres("Koestraat", "44", 9700, "Oudenaarde")));
		brouwers.put(4L, new Brouwer(4, "Sambre", 10000, new Adres("Koestraat", "46", 9700, "Oudenaarde")));
	}

	@Override
	public void create(Brouwer brouwer) {
		brouwer.setBrouwerNr(Collections.max(brouwers.keySet()) + 1);
		brouwers.put(brouwer.getBrouwerNr(), brouwer);
		
	}

	@Override
	public List<Brouwer> findAll() {
		return new ArrayList<>(brouwers.values());
	}

	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		return brouwers.values().stream().filter(brouwer->brouwer.getNaam().equals(beginNaam)).collect(Collectors.toList());
	}
}
