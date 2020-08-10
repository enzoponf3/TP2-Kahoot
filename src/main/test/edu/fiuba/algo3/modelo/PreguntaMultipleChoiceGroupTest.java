package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceGroupTest {

    /*@Test
    public void TestJugadorIngresaLasRespuestasCorrectasEnLosCasillerosYSumaUnPunto() {
        ArrayList <RespuestasJugador> respuestasJugadores= new <RespuestasJugador>ArrayList();
        Jugador jugador1 = new Jugador();

        PreguntaChoiceGroup pregunta = new PreguntaChoiceGroup(3, 2);

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        RespuestaGroup respuesta1 = pregunta.elegirRespuesta(0);
        respuestasJugador1.agregarRespuesta(respuesta1);
        pregunta.introducirRespuestaEnCasillero1(respuesta1);
        RespuestaGroup respuesta2 = pregunta.elegirRespuesta(1);
        respuestasJugador1.agregarRespuesta(respuesta2);
        pregunta.introducirRespuestaEnCasillero1(respuesta2);
        RespuestaGroup respuesta3 = pregunta.elegirRespuesta(2);
        respuestasJugador1.agregarRespuesta(respuesta3);
        pregunta.introducirRespuestaEnCasillero1(respuesta3);
        RespuestaGroup respuesta4 = pregunta.elegirRespuesta(3);
        respuestasJugador1.agregarRespuesta(respuesta4);
        pregunta.introducirRespuestaEnCasillero2(respuesta4);
        RespuestaGroup respuesta5 = pregunta.elegirRespuesta(4);
        respuestasJugador1.agregarRespuesta(respuesta5);
        pregunta.introducirRespuestaEnCasillero2(respuesta5);

        respuestasJugadores.add( respuestasJugador1);
        pregunta.evaluarRespuestas(respuestasJugadores);

        assertEquals(1, jugador1.puntos());
    }*/

    @Test
    public void TestJugadorIngresaUnaRespuestaIncorrectaEnCasillero2YCeroPuntos() {
        ArrayList <RespuestasJugadorAgrupable> respuestasJugadores= new <RespuestasJugadorAgrupable>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaChoiceGroup preguntaGroup = new PreguntaChoiceGroup(3,2);

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
