package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Artista {
	
	private static final Logger logger = LogManager.getLogger();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; //L'ho messo senno da errore nell'esecuzione
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDiNascita;
	
	@Column
	private String luogoDiNascita;

	@Column
	private String nazionalita;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDiMorte;

	@Column
	private String luogoDiMorte;
	
	@Column(length=1800)
	private String biografia;
	
	@OneToMany(mappedBy = "artista")
	private List<Opera> opere;
	
	public Artista(String nome, String cognome, LocalDate dataDiNascita, String luogoDiNascita, String nazionalita,	LocalDate dataDiMorte, String luogoDiMorte, String biografia) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.luogoDiNascita = luogoDiNascita;
		this.nazionalita = nazionalita;
		this.dataDiMorte = dataDiMorte;
		this.luogoDiMorte = luogoDiMorte;
		this.biografia = biografia;
		this.opere = new ArrayList<>();
	}

	public Artista() {
         this.opere = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
		logger.debug("Id settato!");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		logger.debug("nome settato!");
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
		logger.debug("cognome settato!");
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
		logger.debug("data di nascita settata!");
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
		logger.debug("luogo di nascita settato!");
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
		logger.debug("nazionalit� settata!");
	}

	public LocalDate getDataDiMorte() {
		return dataDiMorte;
	}

	public void setDataDiMorte(LocalDate dataDiMorte) {
		this.dataDiMorte = dataDiMorte;
		logger.debug("data di morte settata!");
	}

	public String getLuogoDiMorte() {
		return luogoDiMorte;
	}

	public void setLuogoDiMorte(String luogoDiMorte) {
		this.luogoDiMorte = luogoDiMorte;
		logger.debug("luogo di morte settata!");
	}

	public List<Opera> getOpere() {
		return opere;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
		logger.debug("opere dell'artista settate!");
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}	
}
