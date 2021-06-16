package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.repository.OperaRepository;

@Service
public class OperaService {
	
	@Autowired
	private OperaRepository operaRepository;

	@Transactional
	public Opera inserisci(Opera opera) {
		return operaRepository.save(opera);
	}
	
	@Transactional
	public Opera findById(Long id) {
		Optional<Opera> optional = operaRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	@Transactional 
	public List<Opera> operePerCollezione(Collezione collezione) {
		return operaRepository.findByCollezione(collezione);
	}
	
	@Transactional
	public List<Opera> operaPerTitolo(String titolo) {
		return operaRepository.findByTitolo(titolo);
	}
	
	@Transactional
	public List<Opera> operePerArtista(Artista artista) {
		return operaRepository.findByArtista(artista);
	}
	
	@Transactional 
	public List<Opera> tutteLeOpere() {
		return (List<Opera>) operaRepository.findAll();
	}
	
	@Transactional
	public boolean alreadyExists(Opera opera) {
		List<Opera> opere = operaRepository.findByTitoloAndArtista(opera.getTitolo(), opera.getArtista());
		if(opere.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
