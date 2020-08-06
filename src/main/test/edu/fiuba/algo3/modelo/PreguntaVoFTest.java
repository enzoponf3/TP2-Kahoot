package edu.fiuba.algo3.modelo;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVoFTest {

    @Test
    public void testPreguntaVSumaPuntoAJugador1YNoSumaAJugador2 () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaVoF preguntaV = PreguntaVoF.crearPreguntaVerdadera();
        ArrayList<RespuestasJugador> respuestasJugadores= new <RespuestasJugador>ArrayList();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaV.ElegirRespuestaVerdadera());
        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaV.ElegirRespuestaFalsa());

        respuestasJugadores.add( respuestasJugador1);
        respuestasJugadores.add( respuestasJugador2);

        preguntaV.evaluarRespuestas(respuestasJugadores);

        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

}
