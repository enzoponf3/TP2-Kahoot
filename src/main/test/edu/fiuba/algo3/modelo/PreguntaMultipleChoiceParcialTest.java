package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceParcialTest {

    @Test
    public void TestPreguntaMCClasicaJugadorUnoRespondeTodoOk3PuntosAJugador2LeFaltaUna0Puntos() {
        ArrayList<RespuestasJugador> respuestasVariosJugadores = new <RespuestasJugador>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaChoiceParcial preguntaMCParcial = new PreguntaChoiceParcial(4, 3);
        preguntaMCParcial.agregarRespuestasCorrectas();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaMCParcial.elegirRespuesta(0));
        respuestasJugador1.agregarRespuesta(preguntaMCParcial.elegirRespuesta(1));
        respuestasJugador1.agregarRespuesta(preguntaMCParcial.elegirRespuesta(2));


        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaMCParcial.elegirRespuesta(1));
        respuestasJugador2.agregarRespuesta(preguntaMCParcial.elegirRespuesta(3));
        respuestasJugador2.agregarRespuesta(preguntaMCParcial.elegirRespuesta(0));

        respuestasVariosJugadores.add(respuestasJugador1);
        respuestasVariosJugadores.add(respuestasJugador2);

        preguntaMCParcial.evaluarRespuesta(respuestasVariosJugadores);

        assertEquals(3, jugador1.devolverPuntaje().devolverPuntos());
        assertEquals(0, jugador2.devolverPuntaje().devolverPuntos());
    }
}
