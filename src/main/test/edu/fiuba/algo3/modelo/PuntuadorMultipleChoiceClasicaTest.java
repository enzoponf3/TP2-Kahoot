package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntuadorMultipleChoiceClasicaTest {

    @Test
    public void TestJugadorElige1RespuestaCorrectaYSuma1Punto(){
        Jugador jugador1 = new Jugador();
        Respuesta respuesta1 = new Respuesta();
        Respuesta respuesta2 = new Respuesta();
        RespuestasJugador respuestas = new RespuestasJugador(jugador1);

        PuntuadorClasico puntuador = new PuntuadorClasico(1);

        respuesta1.establecerComoRespuestaAcertada();
        respuestas.agregarRespuesta(respuesta1);
        respuestas.evaluarRespuestasCon(puntuador);

        assertEquals(1, jugador1.puntos());
    }

    @Test
    public void TestJugadorElige1RespuestaIncorrectaYSuma0Puntos(){
        Jugador jugador1 = new Jugador();
        Respuesta respuesta1 = new Respuesta();
        Respuesta respuesta2 = new Respuesta();
        RespuestasJugador respuestas = new RespuestasJugador(jugador1);

        PuntuadorClasico puntuador = new PuntuadorClasico(1);

        respuesta1.establecerComoRespuestaAcertada();
        respuestas.agregarRespuesta(respuesta2);
        respuestas.evaluarRespuestasCon(puntuador);

        assertEquals(0, jugador1.puntos());
    }

    @Test
    public void TestJugadorElige3RespuestasCorrectasYSuma1Punto(){
        Jugador jugador1 = new Jugador();
        Respuesta respuesta1 = new Respuesta();
        Respuesta respuesta2 = new Respuesta();
        Respuesta respuesta3 = new Respuesta();
        Respuesta respuesta4 = new Respuesta();
        RespuestasJugador respuestas = new RespuestasJugador(jugador1);

        PuntuadorClasico puntuador = new PuntuadorClasico(3);

        respuesta1.establecerComoRespuestaAcertada();
        respuesta3.establecerComoRespuestaAcertada();
        respuesta4.establecerComoRespuestaAcertada();
        respuestas.agregarRespuesta(respuesta1);
        respuestas.agregarRespuesta(respuesta3);
        respuestas.agregarRespuesta(respuesta4);
        respuestas.evaluarRespuestasCon(puntuador);

        assertEquals(1, jugador1.puntos());
    }

    @Test
    public void TestJugadorElige2RespuestasCorrectasYUnaIncorrectaYSuma0Puntos(){
        Jugador jugador1 = new Jugador();
        Respuesta respuesta1 = new Respuesta();
        Respuesta respuesta2 = new Respuesta();
        Respuesta respuesta3 = new Respuesta();
        Respuesta respuesta4 = new Respuesta();
        RespuestasJugador respuestas = new RespuestasJugador(jugador1);

        PuntuadorClasico puntuador = new PuntuadorClasico(3);

        respuesta1.establecerComoRespuestaAcertada();
        respuesta3.establecerComoRespuestaAcertada();
        respuesta4.establecerComoRespuestaAcertada();
        respuestas.agregarRespuesta(respuesta1);
        respuestas.agregarRespuesta(respuesta2);
        respuestas.agregarRespuesta(respuesta3);
        respuestas.evaluarRespuestasCon(puntuador);

        assertEquals(0, jugador1.puntos());
    }

    @Test
    public void TestJugadorElige2RespuestasCorrectasYLeFaltaUnaRespuestaCorrectaYSuma0Puntos(){
        Jugador jugador1 = new Jugador();
        Respuesta respuesta1 = new Respuesta();
        Respuesta respuesta2 = new Respuesta();
        Respuesta respuesta3 = new Respuesta();
        Respuesta respuesta4 = new Respuesta();
        RespuestasJugador respuestas = new RespuestasJugador(jugador1);

        PuntuadorClasico puntuador = new PuntuadorClasico(3);

        respuesta1.establecerComoRespuestaAcertada();
        respuesta3.establecerComoRespuestaAcertada();
        respuesta4.establecerComoRespuestaAcertada();
        respuestas.agregarRespuesta(respuesta1);
        respuestas.agregarRespuesta(respuesta3);
        respuestas.evaluarRespuestasCon(puntuador);

        assertEquals(0, jugador1.puntos());
    }

}
