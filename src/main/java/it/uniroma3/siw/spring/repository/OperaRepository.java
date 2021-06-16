package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.*;

public interface OperaRepository extends CrudRepository<Opera, Long> {
	
	public List<Opera> findByTitolo(String titolo);

	public List<Opera> findByArtista(Artista artista);
	
	public List<Opera> findByCollezione(Collezione collezione);
	
	public List<Opera> findByTitoloAndArtista(String titolo, Artista artista);

}
