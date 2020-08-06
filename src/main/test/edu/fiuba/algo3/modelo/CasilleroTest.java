package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasilleroTest {

    @Test
    public void TestJugadorIntroduceLasRespuestasEnLosCasillerosYSumaUnPunto() {
        Jugador jugador = new Jugador();
        RespuestasJugador respuestas = new RespuestasJugador(jugador);
        Casillero casillero1 = new Casillero();
        Casillero casillero2 = new Casillero();

        RespuestaGroup respuesta1 = casillero1.crearRespuesta();
        RespuestaGroup respuesta2 = casillero1.crearRespuesta();
        RespuestaGroup respuesta3 = casillero1.crearRespuesta();
        RespuestaGroup respuesta4 = casillero2.crearRespuesta();
        RespuestaGroup respuesta5 = casillero2.crearRespuesta();

        casillero1.introducirRespuesta(respuesta1);
        respuestas.agregarRespuesta(respuesta1);
        casillero1.introducirRespuesta(respuesta2);
        respuestas.agregarRespuesta(respuesta2);
        casillero1.introducirRespuesta(respuesta3);
        respuestas.agregarRespuesta(respuesta3);
        casillero2.introducirRespuesta(respuesta4);
        respuestas.agregarRespuesta(respuesta4);
        casillero2.introducirRespuesta(respuesta5);
        respuestas.agregarRespuesta(respuesta5);
        respuestas.evaluarRespuestasCon(new PuntuadorClasico(5));

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void TestJugadorIntroduceLasRespuestasIncorrectasEnLosCasillerosYSumaCeroPuntos() {
        Jugador jugador = new Jugador();
        RespuestasJugador respuestas = new RespuestasJugador(jugador);
        Casillero casillero1 = new Casillero();
        Casillero casillero2 = new Casillero();

        RespuestaGroup respuesta1 = casillero1.crearRespuesta();
        RespuestaGroup respuesta2 = casillero1.crearRespuesta();
        RespuestaGroup respuesta3 = casillero1.crearRespuesta();
        RespuestaGroup respuesta4 = casillero2.crearRespuesta();
        RespuestaGroup respuesta5 = casillero2.crearRespuesta();

        casillero1.introducirRespuesta(respuesta1);
        respuestas.agregarRespuesta(respuesta1);
        casillero1.introducirRespuesta(respuesta2);
        respuestas.agregarRespuesta(respuesta2);
        casillero2.introducirRespuesta(respuesta3);
        respuestas.agregarRespuesta(respuesta3);
        casillero2.introducirRespuesta(respuesta4);
        respuestas.agregarRespuesta(respuesta4);
        casillero2.introducirRespuesta(respuesta5);
        respuestas.agregarRespuesta(respuesta5);
        respuestas.evaluarRespuestasCon(new PuntuadorClasico(5));

        assertEquals(0, jugador.puntos());
    }
}
