package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoicePenalTest {

    @Test
    public void TestPreguntaMCPenalSuma1ParaJugadorCon2CorrectasY1IncorrectasY3ParaJugadorCon3Correctas(){
        ArrayList <RespuestasJugador> RespuestasJugadores= new <RespuestasJugador>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaChoicePenal preguntaMCPenal = new PreguntaChoicePenal(4,3);
        preguntaMCPenal.agregarRespuestasCorrectas();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaMCPenal.elegirRespuesta(0));
        respuestasJugador1.agregarRespuesta(preguntaMCPenal.elegirRespuesta(1));
        respuestasJugador1.agregarRespuesta(preguntaMCPenal.elegirRespuesta(2));

        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaMCPenal.elegirRespuesta(1));
        respuestasJugador2.agregarRespuesta(preguntaMCPenal.elegirRespuesta(3));
        respuestasJugador2.agregarRespuesta(preguntaMCPenal.elegirRespuesta(2));

        RespuestasJugadores.add( respuestasJugador1);
        RespuestasJugadores.add( respuestasJugador2);

        preguntaMCPenal.evaluarRespuestas(RespuestasJugadores);

        assertEquals(3, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void Testjugador1MultiplicaPorTresYRespondeCorrectamente(){
        ArrayList <RespuestasJugador> RespuestasJugadores= new <RespuestasJugador>ArrayList();
        Jugador jugador1 = new Jugador();

        PreguntaChoicePenal preguntaMCPenal = new PreguntaChoicePenal(4,3);
        preguntaMCPenal.agregarRespuestasCorrectas();
        jugador1.usarTriple();
        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaMCPenal.elegirRespuesta(0));
        respuestasJugador1.agregarRespuesta(preguntaMCPenal.elegirRespuesta(1));
        respuestasJugador1.agregarRespuesta(preguntaMCPenal.elegirRespuesta(2));


        RespuestasJugadores.add( respuestasJugador1);

        preguntaMCPenal.evaluarRespuestas(RespuestasJugadores);

        assertEquals(9, jugador1.puntos());
    }


}
