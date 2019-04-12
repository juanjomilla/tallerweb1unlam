package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String nombre;

    @ManyToOne
    private Equipo equipo;

    public Jugador(String nombre, Equipo e){
        this.nombre = nombre;
        this.equipo = e;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setEquipo(Equipo e){
        this.equipo = e;
    }

    public Equipo getEquipo(){
        return this.equipo;
    }

    public Long getId(){
        return this.id;
    }
}