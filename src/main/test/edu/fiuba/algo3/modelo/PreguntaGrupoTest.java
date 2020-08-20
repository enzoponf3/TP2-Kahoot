package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGrupoTest {

    @Test
    public void TestJugadorIngresaUnaRespuestaIncorrectaEnCasillero2YCeroPuntos() {
        ArrayList<RespuestasJugador> respuestasJugadores= new <RespuestasJugador>ArrayList();
        Jugador jugador1 = new Jugador("");
        Jugador jugador2 = new Jugador("");

        PreguntaGrupo preguntaGroup = new PreguntaGrupo(3,2, "Enunciado pregunta grupo");

        RespuestasJugador respJugador1GrupoA = new RespuestasJugador(jugador1);
        RespuestasJugador respJugador1GrupoB = new RespuestasJugador(jugador1);

        respJugador1GrupoA.agregarRespuesta(preguntaGroup.elegirRespuesta(0));
        respJugador1GrupoA.agregarRespuesta(preguntaGroup.elegirRespuesta(1));
        respJugador1GrupoA.agregarRespuesta(preguntaGroup.elegirRespuesta(2));

        respJugador1GrupoB.agregarRespuesta(preguntaGroup.elegirRespuesta(3));
        respJugador1GrupoB.agregarRespuesta(preguntaGroup.elegirRespuesta(4));

        RespuestasJugador respJugador2GrupoA = new RespuestasJugador(jugador2);
        RespuestasJugador respJugador2GrupoB = new RespuestasJugador(jugador2);

        respJugador2GrupoA.agregarRespuesta(preguntaGroup.elegirRespuesta(0));
        respJugador2GrupoA.agregarRespuesta(preguntaGroup.elegirRespuesta(1));
        //respJugador2GrupoA.agregarRespuesta(preguntaGroup.elegirRespuesta(2));

        respJugador2GrupoB.agregarRespuesta(preguntaGroup.elegirRespuesta(3));
        respJugador2GrupoB.agregarRespuesta(preguntaGroup.elegirRespuesta(4));

        respuestasJugadores.add(respJugador1GrupoA);
        respuestasJugadores.add(respJugador1GrupoB);
        respuestasJugadores.add(respJugador2GrupoA);
        respuestasJugadores.add(respJugador2GrupoB);

        preguntaGroup.evaluarRespuestas(respuestasJugadores);

        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }
}

