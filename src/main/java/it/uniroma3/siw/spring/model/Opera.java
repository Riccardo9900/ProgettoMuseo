package it.uniroma3.siw.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Entity
@Table(
		uniqueConstraints=@UniqueConstraint(
				columnNames= {"titolo","annoRealizzazione", "descrizione"}
				)
		)
public class Opera {

	private static final Logger logger = LogManager.getLogger();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String titolo;
	
	@Column(nullable = false)
	private String annoRealizzazione;
	
	@Column(length=1000)
	private String descrizione;
	
	@ManyToOne
	private Artista artista;
	
	@ManyToOne
	private Collezione collezione;
	
	public Opera() {
		
	}
	
	public Opera(String titolo, String annoRealizzazione, String descrizione, Artista artista, Collezione collezione) {
		this.titolo = titolo;
		this.annoRealizzazione = annoRealizzazione;
		this.descrizione = descrizione;
		this.artista = artista;
		this.collezione = collezione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
		logger.debug("id settato!");
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
		logger.debug("titolo settato!");
	}

	public String getAnnoRealizzazione() {
		return annoRealizzazione;
	}

	public void setAnnoRealizzazione(String annoRealizzazione) {
		this.annoRealizzazione = annoRealizzazione;
		logger.debug("anno di realizzazione settato!");
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		logger.debug("descrizione settata!");
	}

	public Collezione getCollezione() {
		return collezione;
	}

	public void setCollezione(Collezione collezione) {
		this.collezione = collezione;
		logger.debug("collezione settata!");
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
		logger.debug("artista settato!");
	}
	
	

}
