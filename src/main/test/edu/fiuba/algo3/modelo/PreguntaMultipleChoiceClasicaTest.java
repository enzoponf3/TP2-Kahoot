package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceClasicaTest {
    @Test
    public void TestCreacionPreguntaMCClasicaConDosRespuestasCorrectas(){
        PreguntaChoiceClasica pregunta1 = new PreguntaChoiceClasica(4,2);
        ArrayList <RespuestasJugador> listaRespuestasJugadores= new <RespuestasJugador>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Respuesta resp1 = new Respuesta();
        Respuesta resp2 = new Respuesta();
        Respuesta resp3 = new Respuesta();
        Respuesta resp4 = new Respuesta();

        pregunta1.agregarRespuestaCorrecta(resp1);
        pregunta1.agregarRespuestaCorrecta(resp3);

        assertEquals(2, pregunta1.cantidadRespuestasCorrectas());
    }

    @Test
    public void TestPreguntaMCClasicaSuma1ParaJugadorConTodasCorrectasY0ParaJugadorConUnaIncorrecta(){
        PreguntaChoiceClasica pregunta1 = new PreguntaChoiceClasica(4,2);
        ArrayList <RespuestasJugador> listaRespuestasJugadores= new <RespuestasJugador>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Respuesta resp1 = new Respuesta();
        Respuesta resp2 = new Respuesta();
        Respuesta resp3 = new Respuesta();
        Respuesta resp4 = new Respuesta();

        pregunta1.agregarRespuestaCorrecta(resp1);
        pregunta1.agregarRespuestaCorrecta(resp3);

        RespuestasJugador listaRespuestasJugador1 = new RespuestasJugador(jugador1);
        listaRespuestasJugador1.agregarRespuesta(resp1);
        listaRespuestasJugador1.agregarRespuesta(resp2);
        listaRespuestasJugador1.agregarRespuesta(resp3);

        RespuestasJugador listaRespuestasJugador2 = new RespuestasJugador(jugador2);
        listaRespuestasJugador2.agregarRespuesta(resp1);
        listaRespuestasJugador2.agregarRespuesta(resp3);

        listaRespuestasJugadores.add( listaRespuestasJugador1);
        listaRespuestasJugadores.add( listaRespuestasJugador2);

        pregunta1.evaluarRespuesta(listaRespuestasJugadores);

        assertEquals(0, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }



    @Test
    public void TestPreguntaMCClasica(){
        ArrayList <RespuestasJugador> RespuestasJugadores= new <RespuestasJugador>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaChoiceClasica preguntaMC = new PreguntaChoiceClasica(4,3);
        preguntaMC.agregarRespuestasCorrectas();

        RespuestasJugador listaRespuestasJugador1 = new RespuestasJugador(jugador1);
        listaRespuestasJugador1.agregarRespuesta(preguntaMC.elegirRespuesta(0));
        listaRespuestasJugador1.agregarRespuesta(preguntaMC.elegirRespuesta(1));
        listaRespuestasJugador1.agregarRespuesta(preguntaMC.elegirRespuesta(2));


        RespuestasJugador listaRespuestasJugador2 = new RespuestasJugador(jugador2);
        listaRespuestasJugador2.agregarRespuesta(preguntaMC.elegirRespuesta(1));
        listaRespuestasJugador2.agregarRespuesta(preguntaMC.elegirRespuesta(3));

        RespuestasJugadores.add( listaRespuestasJugador1);
        RespuestasJugadores.add( listaRespuestasJugador2);

        preguntaMC.evaluarRespuesta(RespuestasJugadores);

        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }



}


