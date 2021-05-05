package it.uniroma3.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "cognome", "email"}))
public class Dirigente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;
	
	@Column
	private String email;

	@Column
	private String numeroDiTelefono;

	@Column(nullable = false)
	private String carica;
	
	@ManyToOne 
	private Società societa;

	public Dirigente() {
	}

	public Dirigente(String nome, String cognome, String email, String carica, String numeroDiTelefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.carica = carica;
		this.numeroDiTelefono = numeroDiTelefono;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroDiTelefono() {
		return numeroDiTelefono;
	}

	public void setNumeroDiTelefono(String numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
	}

	public String getCarica() {
		return carica;
	}

	public void setCarica(String carica) {
		this.carica = carica;
	}

	public Società getSocieta() {
		return societa;
	}

	public void setSocieta(Società societa) {
		this.societa = societa;
	}

}
