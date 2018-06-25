package be.vdab.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Naam;

public interface BrouwerService {
	void create(Brouwer brouwer);
	public Page<Brouwer> findAll(Pageable pageable);
	public List<Brouwer> findAll();
	List<Brouwer> findByNaam(Naam beginNaam);
	List<Brouwer> findByLetter(String letter);
}
