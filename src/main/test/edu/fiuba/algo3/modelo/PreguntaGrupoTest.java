package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGrupoTest {

    @Test
    public void TestJugadorIngresaUnaRespuestaIncorrectaEnCasillero2YCeroPuntos() {
        ArrayList <RespuestasJugadorAgrupable> respuestasJugadores= new <RespuestasJugadorAgrupable>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaGrupo preguntaGroup = new PreguntaGrupo(3,2);

        RespuestasJugadorAgrupable respuestasJugador1 = new RespuestasJugadorAgrupable(jugador1);
        respuestasJugador1.agregarRespuestaAContenedorA(preguntaGroup.elegirRespuesta(0));
        respuestasJugador1.agregarRespuestaAContenedorA(preguntaGroup.elegirRespuesta(1));
        respuestasJugador1.agregarRespuestaAContenedorA(preguntaGroup.elegirRespuesta(2));
        respuestasJugador1.agregarRespuestaAContenedorB(preguntaGroup.elegirRespuesta(3));
        respuestasJugador1.agregarRespuestaAContenedorB(preguntaGroup.elegirRespuesta(4));

        RespuestasJugadorAgrupable respuestasJugador2 = new RespuestasJugadorAgrupable(jugador2);
        respuestasJugador2.agregarRespuestaAContenedorA(preguntaGroup.elegirRespuesta(1));
        respuestasJugador2.agregarRespuestaAContenedorA(preguntaGroup.elegirRespuesta(3));
        respuestasJugador2.agregarRespuestaAContenedorA(preguntaGroup.elegirRespuesta(4));
        respuestasJugador2.agregarRespuestaAContenedorB(preguntaGroup.elegirRespuesta(0));
        respuestasJugador2.agregarRespuestaAContenedorB(preguntaGroup.elegirRespuesta(2));

        respuestasJugadores.add(respuestasJugador1);
        respuestasJugadores.add(respuestasJugador2);
        preguntaGroup.evaluarRespuestas(respuestasJugadores);

        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }
}
