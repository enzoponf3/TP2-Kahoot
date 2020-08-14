package edu.fiuba.algo3.modelo;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVoFClasicaTest {

    @Test
    public void testPreguntaVSumaPuntoAJugador1YNoSumaAJugador2 () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Turno turnoActual = new TurnoPrimerJugador();

        PreguntaVoFClasica preguntaV = PreguntaVoFClasica.crearPreguntaVerdadera("pepegrillo");

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);

        turnoActual.jugar(preguntaV,respuestasJugador1);
        turnoActual=turnoActual.cambiarTurno();

        turnoActual.jugar(preguntaV,respuestasJugador2);
        turnoActual=turnoActual.cambiarTurno();

        turnoActual.jugar2(preguntaV,respuestasJugador1,respuestasJugador2);
        turnoActual=turnoActual.cambiarTurno();

        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

}
