package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadDePuntajeTest {

    @Test
    public void testPreguntaVoFConExclusividadPuntua2ParaJugadorQueEligioYAcerto () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaVoFClasica preguntaV = PreguntaVoFClasica.crearPreguntaVerdadera();
        ArrayList<RespuestasJugador> respuestasJugadores = new <RespuestasJugador>ArrayList();

        preguntaV.usarExclusividad();  //La usa el jugador1

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaV.ElegirRespuestaVerdadera());
        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaV.ElegirRespuestaFalsa());

        respuestasJugadores.add( respuestasJugador1);
        respuestasJugadores.add( respuestasJugador2);

        preguntaV.evaluarRespuestas(respuestasJugadores);

        assertEquals(2, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }

    @Test
    public void testPreguntaVoFConDobleExclusividadPuntua4ParaJugadorQueEligioYAcerto () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaVoFClasica preguntaV = PreguntaVoFClasica.crearPreguntaVerdadera();
        ArrayList<RespuestasJugador> respuestasJugadores = new <RespuestasJugador>ArrayList();

        preguntaV.usarExclusividad();  //La usa el jugador1
        preguntaV.usarExclusividad();  //La usa el jugador2

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaV.ElegirRespuestaVerdadera());
        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaV.ElegirRespuestaFalsa());

        respuestasJugadores.add( respuestasJugador1);
        respuestasJugadores.add( respuestasJugador2);

        preguntaV.evaluarRespuestas(respuestasJugadores);

        assertEquals(4, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }
}
