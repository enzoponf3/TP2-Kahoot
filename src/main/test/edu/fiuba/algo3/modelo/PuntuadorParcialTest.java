package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntuadorParcialTest {
    @Test
    public void TestJugadorEligeUnaRespuestaCorrectaYSumaUnPunto() {
        Jugador jugador = new Jugador();
        RespuestasJugador respuestas = new RespuestasJugador(jugador);
        Respuesta respuesta1 = new Respuesta();
        Respuesta respuesta2 = new Respuesta();
        Respuesta respuesta3 = new Respuesta();
        Respuesta respuesta4 = new Respuesta();
        Puntuador puntuadorParcial = new PuntuadorParcial();

        respuesta2.establecerComoRespuestaAcertada();
        respuesta3.establecerComoRespuestaAcertada();
        respuestas.agregarRespuesta(respuesta2);
        respuestas.evaluarRespuestasCon(puntuadorParcial);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void TestJugadorEligeDosRespuestasCorrectasYSumaDosPuntos() {
        Jugador jugador = new Jugador();
        RespuestasJugador respuestas = new RespuestasJugador(jugador);
        Respuesta respuesta1 = new Respuesta();
        Respuesta respuesta2 = new Respuesta();
        Respuesta respuesta3 = new Respuesta();
        Respuesta respuesta4 = new Respuesta();
        Puntuador puntuadorParcial = new PuntuadorParcial();

        respuesta1.establecerComoRespuestaAcertada();
        respuesta3.establecerComoRespuestaAcertada();
        respuestas.agregarRespuesta(respuesta1);
        respuestas.agregarRespuesta(respuesta3);
        respuestas.evaluarRespuestasCon(puntuadorParcial);

        assertEquals(2, jugador.puntos());
    }

    @Test
    public void TestJugadorEligeDosRespuestasCorrectasYUnaIncorrectaYsumaCeroPuntos() {
        Jugador jugador = new Jugador();
        RespuestasJugador respuestas = new RespuestasJugador(jugador);
        Respuesta respuesta1 = new Respuesta();
        Respuesta respuesta2 = new Respuesta();
        Respuesta respuesta3 = new Respuesta();
        Respuesta respuesta4 = new Respuesta();
        Puntuador puntuadorParcial = new PuntuadorParcial();

        respuesta3.establecerComoRespuestaAcertada();
        respuesta4.establecerComoRespuestaAcertada();
        respuestas.agregarRespuesta(respuesta3);
        respuestas.agregarRespuesta(respuesta2);
        respuestas.agregarRespuesta(respuesta4);
        respuestas.evaluarRespuestasCon(puntuadorParcial);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void TestJugadorEligeUnaRespuestaIncorrectaYSumaCeroPuntos() {
        Jugador jugador = new Jugador();
        RespuestasJugador respuestas = new RespuestasJugador(jugador);
        Respuesta respuesta1 = new Respuesta();
        Respuesta respuesta2 = new Respuesta();
        Respuesta respuesta3 = new Respuesta();
        Respuesta respuesta4 = new Respuesta();
        Puntuador puntuadorParcial = new PuntuadorParcial();

        respuesta2.establecerComoRespuestaAcertada();
        respuesta4.establecerComoRespuestaAcertada();
        respuestas.agregarRespuesta(respuesta3);
        respuestas.evaluarRespuestasCon(puntuadorParcial);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void TestJugadorEligeTresRespuestasCorrectasYSumaTresPuntos() {
        Jugador jugador = new Jugador();
        RespuestasJugador respuestas = new RespuestasJugador(jugador);
        Respuesta respuesta1 = new Respuesta();
        Respuesta respuesta2 = new Respuesta();
        Respuesta respuesta3 = new Respuesta();
        Respuesta respuesta4 = new Respuesta();
        Puntuador puntuadorParcial = new PuntuadorParcial();

        respuesta1.establecerComoRespuestaAcertada();
        respuesta3.establecerComoRespuestaAcertada();
        respuesta4.establecerComoRespuestaAcertada();
        respuestas.agregarRespuesta(respuesta1);
        respuestas.agregarRespuesta(respuesta3);
        respuestas.agregarRespuesta(respuesta4);
        respuestas.evaluarRespuestasCon(puntuadorParcial);

        assertEquals(3, jugador.puntos());
    }
}
