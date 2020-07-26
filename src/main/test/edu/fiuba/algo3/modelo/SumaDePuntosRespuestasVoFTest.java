package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumaDePuntosRespuestasVoFTest {

    @Test
    public void testJugadorEligeVerdaderoAPreguntaVerdaderaYSumaUnPunto () {
        Jugador3 jugador = new Jugador3();
        PreguntaVoF3 pregunta = PreguntaVoF3.crearPreguntaVerdadera();
        pregunta.esVerdadero(jugador);

        assertEquals(1, jugador.darPuntos());
    }

    @Test
    public void testJugadorEligeFalsoAPreguntaVerdaderaYSumaCeroPuntos () {
        Jugador3 jugador = new Jugador3();
        PreguntaVoF3 pregunta = PreguntaVoF3.crearPreguntaVerdadera();
        pregunta.esFalso(jugador);

        assertEquals(0, jugador.darPuntos());
    }

    @Test
    public void testJugadorEligeFalsoAPreguntaFalsaYSumaUnPunto () {
        Jugador3 jugador = new Jugador3();
        PreguntaVoF3 pregunta = PreguntaVoF3.crearPreguntaFalsa();
        pregunta.esFalso(jugador);

        assertEquals(1, jugador.darPuntos());
    }

    @Test
    public void testJugadorEligeVerdaderoAPreguntaFalsaYSumaCeroPuntos () {
        Jugador3 jugador = new Jugador3();
        PreguntaVoF3 pregunta = PreguntaVoF3.crearPreguntaFalsa();
        pregunta.esVerdadero(jugador);

        assertEquals(0, jugador.darPuntos());
    }

    @Test
    public void testSeCreaUnaPreguntaVerdaderaJugador1SumaUnPuntoYJugador2SumaCeroPuntos () {
        Jugador3 jugador1 = new Jugador3();
        Jugador3 jugador2 = new Jugador3();
        PreguntaVerdadera pregunta = new PreguntaVerdadera();
        pregunta.responderVerdadero(jugador1);
        pregunta.responderFalso(jugador2);
        pregunta.puntuar();

        assertEquals(1, jugador1.darPuntos());
        assertEquals(0, jugador2.darPuntos());
    }

    @Test
    public void testSeCreaUnaPreguntaVerdaderaJugador1SumaUnPuntoYJugador2SumaUnPunto () {
        Jugador3 jugador1 = new Jugador3();
        Jugador3 jugador2 = new Jugador3();
        PreguntaVerdadera pregunta = new PreguntaVerdadera();
        pregunta.responderVerdadero(jugador1);
        pregunta.responderVerdadero(jugador2);
        pregunta.puntuar();

        assertEquals(1, jugador1.darPuntos());
        assertEquals(1, jugador2.darPuntos());
    }

    @Test
    public void testSeCreaUnaPreguntaFalsaJugador1SumaCeroPuntosYJugador2SumaUnPunto () {
        Jugador3 jugador1 = new Jugador3();
        Jugador3 jugador2 = new Jugador3();
        PreguntaFalsa pregunta = new PreguntaFalsa();
        pregunta.responderVerdadero(jugador1);
        pregunta.responderFalso(jugador2);
        pregunta.puntuar();

        assertEquals(0, jugador1.darPuntos());
        assertEquals(1, jugador2.darPuntos());
    }

    @Test
    public void testSeCreaUnaPreguntaFalsaJugador1SumaCeroPuntosYJugador2CeroPuntos () {
        Jugador3 jugador1 = new Jugador3();
        Jugador3 jugador2 = new Jugador3();
        PreguntaFalsa pregunta = new PreguntaFalsa();
        pregunta.responderVerdadero(jugador1);
        pregunta.responderVerdadero(jugador2);
        pregunta.puntuar();

        assertEquals(0, jugador1.darPuntos());
        assertEquals(0, jugador2.darPuntos());
    }
}
