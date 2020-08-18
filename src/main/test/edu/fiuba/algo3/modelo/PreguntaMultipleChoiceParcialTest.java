package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceParcialTest {

    @Test
    public void TestPreguntaMCParcialClasicaJugador1Puntua3PorContestar3BienJugador2NoPuntuaPorContestarUnaMal(){
        ArrayList <RespuestasJugador> RespuestasJugadores= new ArrayList<>();
        Jugador jugador1 = new Jugador("");
        Jugador jugador2 = new Jugador("");

        Respuesta respuesta1 = new Respuesta("Algo");
        Respuesta respuesta2 = new Respuesta("Algo");
        Respuesta respuesta3 = new Respuesta("Algo");
        Respuesta respuesta4 = new Respuesta("Algo");

        PreguntaChoiceParcial preguntaMCParcial = new PreguntaChoiceParcial("Pregunta");
        preguntaMCParcial.agregarRespuestaCorrecta(respuesta1);
        preguntaMCParcial.agregarRespuesta(respuesta2);
        preguntaMCParcial.agregarRespuestaCorrecta(respuesta3);
        preguntaMCParcial.agregarRespuestaCorrecta(respuesta4);


        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(respuesta1);
        respuestasJugador1.agregarRespuesta(respuesta3);
        respuestasJugador1.agregarRespuesta(respuesta4);


        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(respuesta1);
        respuestasJugador2.agregarRespuesta(respuesta3);
        respuestasJugador2.agregarRespuesta(respuesta2);

        RespuestasJugadores.add( respuestasJugador1);
        RespuestasJugadores.add( respuestasJugador2);

        preguntaMCParcial.evaluarRespuestas(RespuestasJugadores);

        assertEquals(3, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }

}
