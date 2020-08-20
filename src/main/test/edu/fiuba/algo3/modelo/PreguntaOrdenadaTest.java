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

        Respuesta respuesta1 = new Respuesta("Algo");
        Respuesta respuesta2 = new Respuesta("Algo");
        Respuesta respuesta3 = new Respuesta("Algo");
        Respuesta respuesta4 = new Respuesta("Algo");

        PreguntaOrdenada preguntaOrdenada = new PreguntaOrdenada("¿?");
        preguntaOrdenada.agregarRespuesta(respuesta1);
        preguntaOrdenada.agregarRespuesta(respuesta2);
        preguntaOrdenada.agregarRespuesta(respuesta3);
        preguntaOrdenada.agregarRespuesta(respuesta4);

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(respuesta1);
        respuestasJugador1.agregarRespuesta(respuesta2);
        respuestasJugador1.agregarRespuesta(respuesta3);
        respuestasJugador1.agregarRespuesta(respuesta4);

        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(respuesta2);
        respuestasJugador2.agregarRespuesta(respuesta4);

        respuestasJugadores.add(respuestasJugador1);
        respuestasJugadores.add(respuestasJugador2);

        preguntaOrdenada.evaluarRespuestas(respuestasJugadores);

        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }
}
