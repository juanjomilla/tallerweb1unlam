package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.assertEquals;

import org.hibernate.Session;

// Clase que prueba la conexion a la base de datos. Hereda de SpringTest por lo que corre dentro del contexto
// de spring
public class TestEquipo extends SpringTest{

    @Test
    @Transactional @Rollback(true)
    public void testQueGuardaUnJugadorConEquipo(){
        Session session = getSession();
        Equipo sacachispas = new Equipo("Futbol");
        Jugador roberto = new Jugador("Roberto Carlos", sacachispas);
        
        session.save(roberto);

        Jugador jugadorObtenido = session.get(Jugador.class, roberto.getId());

        assertEquals(jugadorObtenido.getEquipo().getNombre(), roberto.getEquipo().getNombre());
    }
}