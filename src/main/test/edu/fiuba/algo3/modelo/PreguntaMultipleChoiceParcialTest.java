package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceParcialTest {

    @Test
    public void TestPreguntaMCClasicaSuma3ParaJugadorCon3CorrectasY0ParaJugadorCon1Incorrectay3Correctas(){
        PreguntaChoiceParcial pregunta1 = new PreguntaChoiceParcial();
        ArrayList <RespuestasJugador> listaRespuestasJugadores= new <RespuestasJugador>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Respuesta resp1 = new Respuesta();
        Respuesta resp2 = new Respuesta();
        Respuesta resp3 = new Respuesta();
        Respuesta resp4 = new Respuesta();

        resp1.establecerComoRespuestaAcertada();
        resp3.establecerComoRespuestaAcertada();
        resp4.establecerComoRespuestaAcertada();

        RespuestasJugador listaRespuestasJugador1 = new RespuestasJugador(jugador1);
        listaRespuestasJugador1.agregarRespuesta(resp1);
        listaRespuestasJugador1.agregarRespuesta(resp2);
        listaRespuestasJugador1.agregarRespuesta(resp3);
        listaRespuestasJugador1.agregarRespuesta(resp4);

        RespuestasJugador listaRespuestasJugador2 = new RespuestasJugador(jugador2);
        listaRespuestasJugador2.agregarRespuesta(resp1);
        listaRespuestasJugador2.agregarRespuesta(resp3);
        listaRespuestasJugador2.agregarRespuesta(resp4);


        listaRespuestasJugadores.add( listaRespuestasJugador1);
        listaRespuestasJugadores.add( listaRespuestasJugador2);

        pregunta1.evaluarRespuestas(listaRespuestasJugadores);

        assertEquals(0, jugador1.puntos());
        assertEquals(3, jugador2.puntos());
    }
}
