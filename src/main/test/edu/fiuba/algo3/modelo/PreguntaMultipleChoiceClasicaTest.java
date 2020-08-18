package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceClasicaTest {

    @Test
    public void TestPreguntaMCClasicaJugador1PuntuaPorContestarTodoBienJugador2NoPuntuaPorContestarUnaMal(){
        ArrayList <RespuestasJugador> respuestasJugadores= new ArrayList<>();
        Jugador jugador1 = new Jugador("");
        Jugador jugador2 = new Jugador("");

        Respuesta respuesta1 = new Respuesta("Algo");
        Respuesta respuesta2 = new Respuesta("Algo");
        Respuesta respuesta3 = new Respuesta("Algo");
        Respuesta respuesta4 = new Respuesta("Algo");

        PreguntaChoiceClasica preguntaMC = new PreguntaChoiceClasica("Pregunta");
        preguntaMC.agregarRespuestaCorrecta(respuesta1);
        preguntaMC.agregarRespuestaCorrecta(respuesta2);
        preguntaMC.agregarRespuestaCorrecta(respuesta3);
        preguntaMC.agregarRespuesta(respuesta4);

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(respuesta1);
        respuestasJugador1.agregarRespuesta(respuesta2);
        respuestasJugador1.agregarRespuesta(respuesta3);

        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(respuesta2);
        respuestasJugador2.agregarRespuesta(respuesta4);

        respuestasJugadores.add( respuestasJugador1);
        respuestasJugadores.add( respuestasJugador2);

        preguntaMC.evaluarRespuestas(respuestasJugadores);

        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }



}


