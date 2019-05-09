package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.tp.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.tp.Continente;
import ar.edu.unlam.tallerweb1.modelo.tp.Ubicacion;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.tp.Pais;

public class PaisTest extends SpringTest{
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback
	public void testQueBuscaPaisesDeHablaInglesa() {
		Pais miPais = new Pais();
		miPais.setIdioma("Portugues");
		Pais miPais2 = new Pais();
		miPais2.setIdioma("Ingles");
		Session session = getSession();
		
		session.save(miPais);
		session.save(miPais2);
		
		List<Pais> paises = session.createCriteria(Pais.class)
							.add(Restrictions.eq("idioma", "Ingles"))
							.list();
		
		assertThat(paises).hasSize(1);
		assertThat(paises).isNotEmpty();
		assertThat(paises.get(0).getIdioma()).isEqualTo("Ingles");
	}

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @Rollback
    public void testQueBuscaPaisesDelContinenteEuropeo() {
        Continente europa = new Continente();
        Continente asia = new Continente();

        Pais miPais = new Pais();
        Pais miPais2 = new Pais();

        europa.setContinente("Europa");
        asia.setContinente("Asia");

        miPais.setContinente(europa);
        miPais2.setContinente(asia);

        Session session = getSession();

        session.save(miPais);
        session.save(miPais2);

        List<Pais> paises = session.createCriteria(Pais.class)
                .add(Restrictions.eq("continente", europa))
                .list();

        assertThat(paises).hasSize(1);
        assertThat(paises).isNotEmpty();
        assertThat(paises.get(0).getContinente()).isEqualTo(europa);
    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @Rollback
    public void testQueBuscaPaisesConCapitalAlNorteDelTropicoDeCancer() {
        final Double latTropicoCancer = 23.43722;

        Pais canada = new Pais();
        Pais argentina = new Pais();

        Ciudad toronto = new Ciudad();
        Ciudad buenosAires = new Ciudad();

        Ubicacion ubiToronto = new Ubicacion();
        Ubicacion ubiBuenosAires = new Ubicacion();

        canada.setNombre("Canada");
        argentina.setNombre("Argentina");

        ubiToronto.setLatitud(43.7);
        ubiToronto.setLongitud(-79.4);
        ubiBuenosAires.setLatitud(-34.603333);
        ubiBuenosAires.setLongitud(-58.381667);

        buenosAires.setUbicacionGeografica(ubiBuenosAires);
        buenosAires.setPais(argentina);
        toronto.setPais(canada);
        toronto.setUbicacionGeografica(ubiToronto);

        Session session = getSession();

        session.save(buenosAires);
        session.save(toronto);


        List<Ciudad> ciudades = session.createCriteria(Ciudad.class)
                    .createCriteria("ubicacionGeografica")
                        .add(Restrictions.ge("latitud", latTropicoCancer))
                .list();

        assertThat(ciudades).hasSize(1);
        assertThat(ciudades).isNotEmpty();
        assertThat(ciudades.get(0).getPais()).isEqualTo(canada);


    }
    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @Rollback
    public void buscarPaisesDelHemisferioSur() {

        Session session = getSession();

        Ubicacion ubicacionLima = new Ubicacion(-77.0282400, -12.0431800);
        Ubicacion ubicacionOttawa = new Ubicacion(-75.69, 45.4208);

        session.save(ubicacionLima);
        session.save(ubicacionOttawa);

        Pais peru = new Pais();
        Pais canada = new Pais();

        Ciudad lima = new Ciudad("lima", ubicacionLima, peru);
        Ciudad ottawa = new Ciudad("ottawa", ubicacionOttawa, canada);

        peru.setCapital(lima);
        canada.setCapital(ottawa);

        session.save(lima);
        session.save(ottawa);

        session.save(peru);
        session.save(canada);

        List<Pais> Resultado = getSession().createCriteria(Pais.class)
                .createAlias("capital", "capital")
                .createAlias("capital.ubicacionGeografica", "ubicacion")
                .add(Restrictions.lt("ubicacion.latitud", 00.00))
                .list();

        assertThat(Resultado).hasSize(1);
    }

}
