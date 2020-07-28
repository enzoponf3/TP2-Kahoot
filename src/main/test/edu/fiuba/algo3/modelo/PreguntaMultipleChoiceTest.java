package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceTest {
    @Test
    public void TestCreacionPreguntaMC(){
        PreguntaChoiceClasica pregunta1 = new PreguntaChoiceClasica();
        ArrayList <ListaRespuesta> listaRespuestaGeneral= new <ListaRespuesta>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Respuesta resp1 = new Respuesta();
        Respuesta resp2 = new Respuesta();
        Respuesta resp3 = new Respuesta();
        Respuesta resp4 = new Respuesta();

        resp1.establecerComoRespuestaAcertada();
        resp3.establecerComoRespuestaAcertada();

        ListaRespuesta listaRespuestasJugador1 = new ListaRespuesta(jugador1);
        listaRespuestasJugador1.agregarRespuesta(resp1);
        listaRespuestasJugador1.agregarRespuesta(resp2);

        ListaRespuesta listaRespuestasJugador2 = new ListaRespuesta(jugador2);
        listaRespuestasJugador2.agregarRespuesta(resp1);
        listaRespuestasJugador2.agregarRespuesta(resp3);

        listaRespuestaGeneral.add( listaRespuestasJugador1);
        listaRespuestaGeneral.add( listaRespuestasJugador2);

        pregunta1.evaluarRespuesta(listaRespuestaGeneral);
    }
}
