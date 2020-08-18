package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoicePenalTest {

    @Test
    public void TestPreguntaMCPenalSuma1ParaJugadorCon2CorrectasY1IncorrectasY3ParaJugadorCon3Correctas(){
        ArrayList <RespuestasJugador> RespuestasJugadores= new ArrayList<>();
        Jugador jugador1 = new Jugador("");
        Jugador jugador2 = new Jugador("");

        Respuesta respuesta1 = new Respuesta("Algo");
        Respuesta respuesta2 = new Respuesta("Algo");
        Respuesta respuesta3 = new Respuesta("Algo");
        Respuesta respuesta4 = new Respuesta("Algo");

        PreguntaChoicePenal preguntaMCPenal = new PreguntaChoicePenal("Pregunta");
        preguntaMCPenal.agregarRespuestaCorrecta(respuesta1);
        preguntaMCPenal.agregarRespuestaCorrecta(respuesta2);
        preguntaMCPenal.agregarRespuestaCorrecta(respuesta3);
        preguntaMCPenal.agregarRespuesta(respuesta4);

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(respuesta1);
        respuestasJugador1.agregarRespuesta(respuesta2);
        respuestasJugador1.agregarRespuesta(respuesta3);

        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(respuesta2);
        respuestasJugador2.agregarRespuesta(respuesta4);
        respuestasJugador2.agregarRespuesta(respuesta3);

        RespuestasJugadores.add( respuestasJugador1);
        RespuestasJugadores.add( respuestasJugador2);

        preguntaMCPenal.evaluarRespuestas(RespuestasJugadores);

        assertEquals(3, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }
}
