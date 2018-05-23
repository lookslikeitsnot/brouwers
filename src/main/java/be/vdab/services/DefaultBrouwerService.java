package be.vdab.services;

import java.util.List;

import org.springframework.stereotype.Service;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;
import be.vdab.valueobjects.Naam;

@Service
public class DefaultBrouwerService implements BrouwerService{
	private final BrouwerRepository brouwerRepository;
	
	public DefaultBrouwerService(BrouwerRepository brouwerRepository) {
		this.brouwerRepository = brouwerRepository;
	}
	
	@Override
	public void create(Brouwer brouwer) {
		brouwerRepository.create(brouwer);
	}

	@Override
	public List<Brouwer> findAll() {
		return brouwerRepository.findAll();
	}

	@Override
	public List<Brouwer> findByNaam(Naam beginNaam) {
		return brouwerRepository.findByNaam(beginNaam);
	}

	@Override
	public List<Brouwer> findByLetter(String letter) {
		return brouwerRepository.findByLetter(letter);
	}
}
