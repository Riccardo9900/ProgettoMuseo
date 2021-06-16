package it.uniroma3.siw.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Entity
@Table(
		uniqueConstraints=@UniqueConstraint(
				columnNames= {"nome","descrizione"}
				)
		)
public class Collezione {

	private static final Logger logger = LogManager.getLogger();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; //L'ho messo senn� da errore nell'esecuzione
	
	@Column(nullable = false)
	private String nome;
	
	@Column
	private String descrizione;
	
	@OneToMany(mappedBy = "collezione")
	private List<Opera> opere;
	
	@ManyToOne
	private Curatore curatore;
	
	public Collezione(String nome, String descrizione, Curatore curatore) {
  		this.nome = nome;
		this.descrizione = descrizione;
		this.curatore = curatore;
		this.opere = new ArrayList<>();
	}

	public Collezione() {
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

	public Curatore getCuratore() {
		return curatore;
	}

	public void setCuratore(Curatore curatore) {
		this.curatore = curatore;
		logger.debug("curatore settato!");
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		logger.debug("descrizione settata!");
	}

	public List<Opera> getOpere() {
		return opere;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
		logger.debug("opere della collezione settate!");
	}
	
}
