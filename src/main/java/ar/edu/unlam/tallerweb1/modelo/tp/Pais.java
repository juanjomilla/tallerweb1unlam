package ar.edu.unlam.tallerweb1.modelo.tp;

import javax.persistence.*;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private long habitantes;
	private String idioma;
	private String capital;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Continente continente;

	public Long getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Continente getContinente() {
		return continente;
	}

	public void setContinente(Continente continente) {
		this.continente = continente;
	}

	public long getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(long habitantes) {
		this.habitantes = habitantes;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
}
