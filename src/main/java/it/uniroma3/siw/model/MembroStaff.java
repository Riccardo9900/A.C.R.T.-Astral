package it.uniroma3.siw.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class MembroStaff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;

	@Column
	private LocalDate dataDiNascita;

	@Column
	private String nazionalita;

	@Column
	private String numeroDiTelefono;

	@Column(nullable = false)
	private String ruolo;
	
	@ManyToOne
	private Società societa;
	
	@OneToOne
	private Categoria categoria;

	public MembroStaff() {
	}

	public MembroStaff(Long id, String nome, String cognome, LocalDate dataDiNascita, String nazionalita, String numeroDiTelefono, String ruolo) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.nazionalita = nazionalita;
		this.numeroDiTelefono = numeroDiTelefono;
		this.ruolo = ruolo;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public String getNumeroDiTelefono() {
		return numeroDiTelefono;
	}

	public void setNumeroDiTelefono(String numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public Società getSocieta() {
		return societa;
	}

	public void setSocieta(Società societa) {
		this.societa = societa;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	

}
