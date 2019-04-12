package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String nombre;
    
    @OneToOne
    private Club club;

    public Equipo(String nombreEquipo){
        this.nombre = nombreEquipo;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}