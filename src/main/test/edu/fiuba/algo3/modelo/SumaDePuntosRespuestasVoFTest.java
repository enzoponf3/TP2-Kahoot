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
}
