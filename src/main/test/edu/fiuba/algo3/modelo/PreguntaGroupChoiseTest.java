package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGroupChoiseTest {

    @Test
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
    }

    @Test
    public void TestJugadorIngresaUnaRespuestaIncorrectaEnCasillero2YCeroPuntos() {
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
        pregunta.introducirRespuestaEnCasillero2(respuesta3);
        RespuestaGroup respuesta4 = pregunta.elegirRespuesta(3);
        respuestasJugador1.agregarRespuesta(respuesta4);
        pregunta.introducirRespuestaEnCasillero2(respuesta4);
        RespuestaGroup respuesta5 = pregunta.elegirRespuesta(4);
        respuestasJugador1.agregarRespuesta(respuesta5);
        pregunta.introducirRespuestaEnCasillero2(respuesta5);

        respuestasJugadores.add( respuestasJugador1);
        pregunta.evaluarRespuestas(respuestasJugadores);

        assertEquals(0, jugador1.puntos());
    }
}
