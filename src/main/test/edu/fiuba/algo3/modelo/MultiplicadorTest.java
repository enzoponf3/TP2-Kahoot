package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorTest {

    @Test
    public void testPreguntaVPenalConMulX2Da2AJugadorQueAcierta() {
        Jugador jugador1 = new Jugador("");
        PreguntaVoFPenal preguntaVPenal = PreguntaVoFPenal.crearPreguntaVerdadera("");
        ArrayList<RespuestasJugador> respuestasJugadores = new <RespuestasJugador>ArrayList();
        MultiplicadorDoble mulX2 = new MultiplicadorDoble();

        mulX2.activarMultiplicadorPara(jugador1); //Botón que indica multiplicador, sólo usable en penal.
        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaVPenal.elegirRespuesta(0));
        respuestasJugadores.add(respuestasJugador1);

        preguntaVPenal.evaluarRespuestas(respuestasJugadores);

        assertEquals(2, jugador1.puntos());
    }

    @Test
    public void testPreguntaVPenalConMulX2DaMenos2AJugadorQueFalla() {
        Jugador jugador1 = new Jugador("");
        PreguntaVoFPenal preguntaVPenal = PreguntaVoFPenal.crearPreguntaVerdadera("");
        ArrayList<RespuestasJugador> respuestasJugadores = new <RespuestasJugador>ArrayList();
        MultiplicadorDoble mulX2 = new MultiplicadorDoble();

        mulX2.activarMultiplicadorPara(jugador1); //Botón que indica multiplicador, sólo usable en penal.

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaVPenal.elegirRespuesta(1));

        respuestasJugadores.add(respuestasJugador1);

        preguntaVPenal.evaluarRespuestas(respuestasJugadores);

        assertEquals(-2, jugador1.puntos());
    }

    @Test
    public void testPreguntaMCPenalConMulX3TriplicaAJugadorQueAcierta(){
        ArrayList <RespuestasJugador> RespuestasJugadores= new <RespuestasJugador>ArrayList();
        Jugador jugador1 = new Jugador("");
        MultiplicadorTriple mulX2 = new MultiplicadorTriple();

        mulX2.activarMultiplicadorPara(jugador1); //Botón que indica multiplicador, sólo usable en penal.
        PreguntaChoicePenal preguntaMCPenal = new PreguntaChoicePenal(4,3);
        preguntaMCPenal.agregarRespuestasCorrectas();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaMCPenal.elegirRespuesta(0));
        respuestasJugador1.agregarRespuesta(preguntaMCPenal.elegirRespuesta(1));
        respuestasJugador1.agregarRespuesta(preguntaMCPenal.elegirRespuesta(2));

        RespuestasJugadores.add( respuestasJugador1);

        preguntaMCPenal.evaluarRespuestas(RespuestasJugadores);

        assertEquals(9, jugador1.puntos());
    }
}
