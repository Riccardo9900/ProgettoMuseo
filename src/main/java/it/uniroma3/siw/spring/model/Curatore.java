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
public class Curatore {
	
	private static final Logger logger = LogManager.getLogger();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String matricola;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDiNascita;
	
	
	private String luogoDiNascita;
	
	
	private String email;
	
	@Column
	private String numeroDiTelefono;
	
	@OneToMany (mappedBy = "curatore")
	private List<Collezione> collezioni;
	
	public Curatore(String matricola, String nome, String cognome, LocalDate dataDiNascita, String luogoDiNascita, String email, String numeroDiTelefono) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.luogoDiNascita = luogoDiNascita;
		this.email = email;
		this.numeroDiTelefono = numeroDiTelefono;
		this.collezioni = new ArrayList<>();
	}

	public Curatore() {
		this.collezioni = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
		logger.debug("id settato!");
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
		logger.debug("luogo di nascita settato");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		logger.debug("email settata!");
	}

	public String getNumeroDiTelefono() {
		return numeroDiTelefono;
	}

	public void setNumeroDiTelefono(String numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
		logger.debug("numero di telefono settato!");
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola (String matricola) {
		this.matricola = matricola;
		logger.debug("matricola settata!");
	}

	public List<Collezione> getCollezioni() {
		return collezioni;
	}

	public void setCollezioni(List<Collezione> collezioni) {
		this.collezioni = collezioni;
		logger.debug("collezioni dell'artista settate!");
	}
}
