package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceParcialTest {

    @Test
    public void TestCreacionPreguntaMCClasicaConDosRespuestasCorrectas(){
        PreguntaChoiceParcial pregunta1 = new PreguntaChoiceParcial(4);
        ArrayList <ListaRespuesta> listaRespuestasJugadores= new <ListaRespuesta>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Respuesta resp1 = new Respuesta();
        Respuesta resp2 = new Respuesta();
        Respuesta resp3 = new Respuesta();
        Respuesta resp4 = new Respuesta();

        pregunta1.agregarRespuestaCorrecta(resp1);
        pregunta1.agregarRespuestaCorrecta(resp3);
        pregunta1.agregarRespuestaCorrecta(resp2);

        assertEquals(3, pregunta1.cantidadRespuestasCorrectas());
    }

    @Test
    public void TestPreguntaMCClasicaSuma3ParaJugadorCon3CorrectasY0ParaJugadorCon1Incorrectay3Correctas(){
        PreguntaChoiceParcial pregunta1 = new PreguntaChoiceParcial(4);
        ArrayList <ListaRespuesta> listaRespuestasJugadores= new <ListaRespuesta>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Respuesta resp1 = new Respuesta();
        Respuesta resp2 = new Respuesta();
        Respuesta resp3 = new Respuesta();
        Respuesta resp4 = new Respuesta();

        pregunta1.agregarRespuestaCorrecta(resp1);
        pregunta1.agregarRespuestaCorrecta(resp3);
        pregunta1.agregarRespuestaCorrecta(resp4);

        ListaRespuesta listaRespuestasJugador1 = new ListaRespuesta(jugador1);
        listaRespuestasJugador1.agregarRespuesta(resp1);
        listaRespuestasJugador1.agregarRespuesta(resp2);
        listaRespuestasJugador1.agregarRespuesta(resp3);
        listaRespuestasJugador1.agregarRespuesta(resp4);

        ListaRespuesta listaRespuestasJugador2 = new ListaRespuesta(jugador2);
        listaRespuestasJugador2.agregarRespuesta(resp1);
        listaRespuestasJugador2.agregarRespuesta(resp3);
        listaRespuestasJugador2.agregarRespuesta(resp4);


        listaRespuestasJugadores.add( listaRespuestasJugador1);
        listaRespuestasJugadores.add( listaRespuestasJugador2);

        pregunta1.evaluarRespuesta(listaRespuestasJugadores);

        assertEquals(0, jugador1.puntos());
        assertEquals(3, jugador2.puntos());
    }


}
