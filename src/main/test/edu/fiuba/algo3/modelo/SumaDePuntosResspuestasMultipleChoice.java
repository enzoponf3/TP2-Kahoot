package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumaDePuntosResspuestasMultipleChoice{

    @Test
    public void testProbandoMultipleChoiceClasica () {
        Jugador3 jugador1 = new Jugador3();
        Jugador3 jugador2 = new Jugador3();
        String[] respuestasCorrectas = {"1", "5"};
        String[] respuestasJugador1 = {"3", "2"};
        String[] respuestasJugador2 = {"1", "5"};
        Clasica pregunta = new Clasica("texto", respuestasCorrectas);
        jugador1.setRespuesta(respuestasJugador1);
        jugador2.setRespuesta(respuestasJugador2);

        pregunta.procesarRespuesta(jugador1, jugador2);

        assertEquals(0, jugador1.getPuntos());
        assertEquals(1, jugador2.getPuntos());
    }
}
