package edu.fiuba.algo3.modelo;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVoFClasicaTest {

    @Test
    public void testPreguntaVSumaPuntoAJugador1YNoSumaAJugador2 () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        ArrayList<RespuestasJugador> respuestasJugadores = new ArrayList<>();

        PreguntaVoFClasica preguntaV = PreguntaVoFClasica.crearPreguntaVerdadera("pepegrillo");

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);

        respuestasJugador1.agregarRespuesta(preguntaV.elegirRespuesta(0));
        respuestasJugador2.agregarRespuesta(preguntaV.elegirRespuesta(1));

        respuestasJugadores.add(respuestasJugador1);
        respuestasJugadores.add(respuestasJugador2);

        preguntaV.evaluarRespuestas(respuestasJugadores);

        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

}
