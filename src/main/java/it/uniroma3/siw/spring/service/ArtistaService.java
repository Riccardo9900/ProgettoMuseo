package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.repository.ArtistaRepository;

@Service
public class ArtistaService {

	@Autowired
	private ArtistaRepository artistaRepository;

	@Transactional
	public Artista inserisci(Artista artista) {
		return artistaRepository.save(artista);
	}

	@Transactional 
	public List<Artista> artistiPerNome(String nome) {
		return artistaRepository.findByNome(nome);	
	}

	@Transactional
	public List<Artista> artistiPerNomeECognome(String nome, String cognome) {
		return artistaRepository.findByNomeAndCognome(nome, cognome);
	}
	
	@Transactional
	public List<Artista> tuttiGliArtisti() {
		return (List<Artista>) artistaRepository.findAll();
	}
	
	@Transactional 
	public Artista artistaPerId(Long id) {
		Optional<Artista> optional = artistaRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get(); //Optional è un contenitore che può contenere oggetti esistenti o nulli.
		}
		else {
			return null;
		}
	}
	
	@Transactional
	public boolean alreadyExists(Artista artista) {
		List<Artista> artisti = artistaRepository.findByNomeAndCognome(artista.getNome(), artista.getCognome());
		if(artisti.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
