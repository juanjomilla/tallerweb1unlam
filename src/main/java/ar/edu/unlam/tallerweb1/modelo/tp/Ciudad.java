package ar.edu.unlam.tallerweb1.modelo.tp;

import javax.persistence.*;

@Entity
public class Ciudad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@OneToOne(cascade = CascadeType.ALL)
	private Ubicacion ubicacionGeografica;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Pais pais;

	public Ciudad(String nombre, Ubicacion ubicacionGeografica, Pais pais) {
		this.nombre = nombre;
		this.ubicacionGeografica = ubicacionGeografica;
		this.pais = pais;
	}

	public Ciudad() {
	}
	public Long getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ubicacion getUbicacionGeografica() {
		return ubicacionGeografica;
	}

	public void setUbicacionGeografica(Ubicacion ubicacion) {
		this.ubicacionGeografica = ubicacion;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
