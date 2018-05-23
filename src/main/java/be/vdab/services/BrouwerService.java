package be.vdab.services;

import java.util.List;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Naam;

public interface BrouwerService {
	void create(Brouwer brouwer);
	List<Brouwer> findAll();
	List<Brouwer> findByNaam(Naam beginNaam);
	List<Brouwer> findByLetter(String letter);
}
