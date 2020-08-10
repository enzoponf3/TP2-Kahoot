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
        respuestasJugador1.agregarRespuesta(preguntaVPenal.ElegirRespuestaVerdadera());
        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaVPenal.ElegirRespuestaFalsa());

        respuestasJugadores.add(respuestasJugador1);
        respuestasJugadores.add(respuestasJugador2);

        preguntaVPenal.evaluarRespuestas(respuestasJugadores);

        assertEquals(1, jugador1.puntos());
        assertEquals(-1, jugador2.puntos());

    }
    @Test
    public void testPreguntaVPenalConMulX2Da2AJugadorQueAcierta() {
        Jugador jugador1 = new Jugador();
        PreguntaVoFPenal preguntaVPenal = PreguntaVoFPenal.crearPreguntaVerdadera();
        ArrayList<RespuestasJugador> respuestasJugadores = new <RespuestasJugador>ArrayList();
        MultiplicadorDoble mulX2 = new MultiplicadorDoble();

        mulX2.activarMultiplicadorPara(jugador1); //Botón que indica multiplicador, sólo usable en penal.
        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaVPenal.ElegirRespuestaVerdadera());
        respuestasJugadores.add(respuestasJugador1);

        preguntaVPenal.evaluarRespuestas(respuestasJugadores);

        assertEquals(2, jugador1.puntos());

    }
    @Test
    public void testPreguntaVPenalConMulX2DaMenos2AJugadorQueFalla() {
        Jugador jugador1 = new Jugador();
        PreguntaVoFPenal preguntaVPenal = PreguntaVoFPenal.crearPreguntaVerdadera();
        ArrayList<RespuestasJugador> respuestasJugadores = new <RespuestasJugador>ArrayList();
        MultiplicadorDoble mulX2 = new MultiplicadorDoble();

        mulX2.activarMultiplicadorPara(jugador1); //Botón que indica multiplicador, sólo usable en penal.

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaVPenal.ElegirRespuestaFalsa());

        respuestasJugadores.add(respuestasJugador1);

        preguntaVPenal.evaluarRespuestas(respuestasJugadores);

        assertEquals(-2, jugador1.puntos());

    }
}
