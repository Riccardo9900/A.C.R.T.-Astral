package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "anno", "citta"}))
public class Società {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private LocalDate anno;
	
	@Column(nullable = false)
	private String citta;
	
	@Column
	private String indirizzo;
	
	@Column
	private String numeroDiTelefono;
	
	@OneToMany(mappedBy = "societa")
	private List<Abbonato> abbonati;
	
	@OneToMany(mappedBy = "societa") 
	private List<Trofeo> trofei;
	
	@OneToMany(mappedBy = "societa")
	private List<MembroStaff> membriStaff;
	
	@OneToMany(mappedBy = "societa")
	private List<Categoria> categorie;
	
	@OneToMany(mappedBy = "societa")
	private List<Dirigente> dirigenti;
	
	public Società() {
		this.abbonati = new ArrayList<>();
		this.trofei = new ArrayList<>();
		this.membriStaff = new ArrayList<>();
		this.categorie = new ArrayList<>();
		this.dirigenti = new ArrayList<>();
	}
	
	public Società(String nome, LocalDate anno, String città, String indirizzo, String numeroDiTelefono) {
		this.nome = nome;
		this.anno = anno;
		this.citta = città;
		this.indirizzo = indirizzo;
		this.numeroDiTelefono = numeroDiTelefono;
	    this.abbonati = new ArrayList<>();
	    this.trofei = new ArrayList<>();
	    this.membriStaff = new ArrayList<>();
	    this.categorie = new ArrayList<>();
	    this.dirigenti = new ArrayList<>();
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

	public LocalDate getAnno() {
		return anno;
	}

	public void setAnno(LocalDate anno) {
		this.anno = anno;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNumeroDiTelefono() {
		return numeroDiTelefono;
	}

	public void setNumeroDiTelefono(String numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
	}

	public List<Abbonato> getAbbonati() {
		return abbonati;
	}

	public void setAbbonati(List<Abbonato> abbonati) {
		this.abbonati = abbonati;
	}

	public List<Trofeo> getTrofei() {
		return trofei;
	}

	public void setTrofei(List<Trofeo> trofei) {
		this.trofei = trofei;
	}

	public List<MembroStaff> getMembriStaff() {
		return membriStaff;
	}

	public void setMembriStaff(List<MembroStaff> membriStaff) {
		this.membriStaff = membriStaff;
	}

	public List<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}

	public List<Dirigente> getDirigenti() {
		return dirigenti;
	}

	public void setDirigenti(List<Dirigente> dirigenti) {
		this.dirigenti = dirigenti;
	}	
	
}
