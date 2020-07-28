package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.NoUse.PreguntaFalsa;
import edu.fiuba.algo3.modelo.NoUse.PreguntaVerdadera;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumaDePuntosRespuestasVoFTest {

    @Test
    public void testJugadorEligeVerdaderoAPreguntaVerdaderaYSumaUnPunto () {
        Jugador jugador = new Jugador();
        PreguntaVoF pregunta = PreguntaVoF.crearPreguntaVerdadera();
        pregunta.esVerdadero(jugador);

        assertEquals(1, jugador.darPuntos());
    }

    @Test
    public void testJugadorEligeFalsoAPreguntaVerdaderaYSumaCeroPuntos () {
        Jugador jugador = new Jugador();
        PreguntaVoF pregunta = PreguntaVoF.crearPreguntaVerdadera();
        pregunta.esFalso(jugador);

        assertEquals(0, jugador.darPuntos());
    }

    @Test
    public void testJugadorEligeFalsoAPreguntaFalsaYSumaUnPunto () {
        Jugador jugador = new Jugador();
        PreguntaVoF pregunta = PreguntaVoF.crearPreguntaFalsa();
        pregunta.esFalso(jugador);

        assertEquals(1, jugador.darPuntos());
    }

    @Test
    public void testJugadorEligeVerdaderoAPreguntaFalsaYSumaCeroPuntos () {
        Jugador jugador = new Jugador();
        PreguntaVoF pregunta = PreguntaVoF.crearPreguntaFalsa();
        pregunta.esVerdadero(jugador);

        assertEquals(0, jugador.darPuntos());
    }

    @Test
    public void testSeCreaUnaPreguntaVerdaderaJugador1SumaUnPuntoYJugador2SumaCeroPuntos () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaVerdadera pregunta = new PreguntaVerdadera();
        pregunta.responderVerdadero(jugador1);
        pregunta.responderFalso(jugador2);
        pregunta.puntuar();

        assertEquals(1, jugador1.darPuntos());
        assertEquals(0, jugador2.darPuntos());
    }

    @Test
    public void testSeCreaUnaPreguntaVerdaderaJugador1SumaUnPuntoYJugador2SumaUnPunto () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaVerdadera pregunta = new PreguntaVerdadera();
        pregunta.responderVerdadero(jugador1);
        pregunta.responderVerdadero(jugador2);
        pregunta.puntuar();

        assertEquals(1, jugador1.darPuntos());
        assertEquals(1, jugador2.darPuntos());
    }

    @Test
    public void testSeCreaUnaPreguntaFalsaJugador1SumaCeroPuntosYJugador2SumaUnPunto () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaFalsa pregunta = new PreguntaFalsa();
        pregunta.responderVerdadero(jugador1);
        pregunta.responderFalso(jugador2);
        pregunta.puntuar();

        assertEquals(0, jugador1.darPuntos());
        assertEquals(1, jugador2.darPuntos());
    }

    @Test
    public void testSeCreaUnaPreguntaFalsaJugador1SumaCeroPuntosYJugador2CeroPuntos () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaFalsa pregunta = new PreguntaFalsa();
        pregunta.responderVerdadero(jugador1);
        pregunta.responderVerdadero(jugador2);
        pregunta.puntuar();

        assertEquals(0, jugador1.darPuntos());
        assertEquals(0, jugador2.darPuntos());
    }
}
