package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVoFPenalTest {

    ///////////////////////////// Puntuación preguntas VoF ////////////////////////////////////////////////////

    @Test
    public void testPreguntaVPenalSumaPuntoAJugador1YRestaAJugador2() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaVoFPenal preguntaVPenal = PreguntaVoFPenal.crearPreguntaVerdadera();
        ArrayList<RespuestasJugador> respuestasJugadores = new <RespuestasJugador>ArrayList();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaVPenal.elegirRespuesta(0));
        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaVPenal.elegirRespuesta(1));

        respuestasJugadores.add(respuestasJugador1);
        respuestasJugadores.add(respuestasJugador2);

        preguntaVPenal.evaluarRespuestas(respuestasJugadores);

        assertEquals(1, jugador1.puntos());
        assertEquals(-1, jugador2.puntos());
    }

    @Test
    public void testPreguntaFPenalSumaPuntoAJugador1YRestaAJugador2() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaVoFPenal preguntaVPenal = PreguntaVoFPenal.crearPreguntaFalsa();
        ArrayList<RespuestasJugador> respuestasJugadores = new <RespuestasJugador>ArrayList();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaVPenal.elegirRespuesta(0));
        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaVPenal.elegirRespuesta(1));

        respuestasJugadores.add(respuestasJugador1);
        respuestasJugadores.add(respuestasJugador2);

        preguntaVPenal.evaluarRespuestas(respuestasJugadores);

        assertEquals(-1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());

    }
}
