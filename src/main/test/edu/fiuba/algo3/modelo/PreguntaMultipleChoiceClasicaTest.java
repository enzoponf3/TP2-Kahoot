package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceClasicaTest {

    @Test
    public void TestPreguntaMCClasicaJugadorUnoRespondeTodoOk1PuntoJugador2LeFaltaUna0Puntos(){
        ArrayList <RespuestasJugador> RespuestasJugadores= new <RespuestasJugador>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaChoiceClasica preguntaMC = new PreguntaChoiceClasica(4,3);
        preguntaMC.agregarRespuestasCorrectas();

        RespuestasJugador RespuestasJugador1 = new RespuestasJugador(jugador1);
        RespuestasJugador1.agregarRespuesta(preguntaMC.elegirRespuesta(0));
        RespuestasJugador1.agregarRespuesta(preguntaMC.elegirRespuesta(1));
        RespuestasJugador1.agregarRespuesta(preguntaMC.elegirRespuesta(2));


        RespuestasJugador RespuestasJugador2 = new RespuestasJugador(jugador2);
        RespuestasJugador2.agregarRespuesta(preguntaMC.elegirRespuesta(1));
        RespuestasJugador2.agregarRespuesta(preguntaMC.elegirRespuesta(3));
        RespuestasJugador2.agregarRespuesta(preguntaMC.elegirRespuesta(0));

        RespuestasJugadores.add( RespuestasJugador1);
        RespuestasJugadores.add( RespuestasJugador2);

        preguntaMC.evaluarRespuesta(RespuestasJugadores);

        assertEquals(1, jugador1.devolverPuntaje().devolverPuntos());
        assertEquals(0, jugador2.devolverPuntaje().devolverPuntos());

    }



}


