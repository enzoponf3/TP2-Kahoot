package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaOrdenadaTest {


    @Test
    public void TestPreguntaMCOrdererJugador1Con4CorrectasSeLeAsigna1PuntoYJugador2Con0CorrectasSeLeAsigna0Puntos() {
        ArrayList<RespuestasJugador> respuestasJugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador("");
        Jugador jugador2 = new Jugador("");

        PreguntaOrdenada preguntaMC = new PreguntaOrdenada(4);

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaMC.elegirRespuesta(0));
        respuestasJugador1.agregarRespuesta(preguntaMC.elegirRespuesta(1));
        respuestasJugador1.agregarRespuesta(preguntaMC.elegirRespuesta(2));
        respuestasJugador1.agregarRespuesta(preguntaMC.elegirRespuesta(3));

        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaMC.elegirRespuesta(1));
        respuestasJugador2.agregarRespuesta(preguntaMC.elegirRespuesta(3));

        respuestasJugadores.add(respuestasJugador1);
        respuestasJugadores.add(respuestasJugador2);

        preguntaMC.evaluarRespuestas(respuestasJugadores);

        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }
}
