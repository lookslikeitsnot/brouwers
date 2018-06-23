package be.vdab.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;
import be.vdab.valueobjects.Naam;

@Service
@ReadOnlyTransactionalService
public class DefaultBrouwerService implements BrouwerService{
	private final BrouwerRepository brouwerRepository;
	
	public DefaultBrouwerService(BrouwerRepository brouwerRepository) {
		this.brouwerRepository = brouwerRepository;
	}
	
	@Override
	@ModifyingTransactionalServiceMethod
	public void create(Brouwer brouwer) {
		brouwerRepository.save(brouwer);
	}

	@Override
	public Page<Brouwer> findAll(Pageable pageable){
		return brouwerRepository.findAll(pageable);
	}

	@Override
	public List<Brouwer> findByNaam(Naam beginNaam) {
		return brouwerRepository.findByNaamStartingWith(beginNaam.getName());
	}

	@Override
	public List<Brouwer> findByLetter(String letter) {
		return brouwerRepository.findByNaamStartingWith(letter);
	}
}
