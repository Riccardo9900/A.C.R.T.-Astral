package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String descrizione;
	
	@OneToOne
	private MembroStaff allenatore;
	
	@ManyToOne
	private Società societa;

	@OneToMany(mappedBy = "categoria")
	private List<Giocatore> giocatori;
	
	public Categoria() {
		this.giocatori = new ArrayList<>();
	}

	public Categoria(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.giocatori = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public MembroStaff getAllenatore() {
		return allenatore;
	}

	public void setAllenatore(MembroStaff allenatore) {
		this.allenatore = allenatore;
	}

	public Società getSocieta() {
		return societa;
	}

	public void setSocieta(Società societa) {
		this.societa = societa;
	}

	public List<Giocatore> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}
	
}
