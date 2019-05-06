package ar.edu.unlam.tallerweb1.modelo.tp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Continente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String continente;

	public Long getId() {
		return this.id;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}
}
