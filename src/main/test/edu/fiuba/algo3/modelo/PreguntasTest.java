package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PreguntasTest {

    @Test
    public void test01CrearPreguntaExclusivaVoFVerdadera(){

        IPregunta preguntaExclusiva = new PreguntaExclusiva();
        VoF preguntaVerdadera = preguntaExclusiva.VoF(true);

        assertTrue( preguntaVerdadera.verdad());

    }
    @Test
    public void test02CrearPreguntaExclusivaVoFFalsa(){
        IPregunta preguntaExclusiva = new PreguntaExclusiva();
        VoF preguntaFalsa = preguntaExclusiva.VoF(false);

        assertFalse( preguntaFalsa.verdad());
    }
    @Test
    public void test03PreguntaExlusivaSumaPuntoPorRespuestaCorrecta(){
        boolean respuestaJugador = true;
        IPregunta preguntaExclusiva = new PreguntaExclusiva();
        VoF preguntaVerdadera = preguntaExclusiva.VoF(true);
        assertEquals(1,preguntaVerdadera.puntuar(respuestaJugador));
    }
    @Test
    public void test04PreguntaExlusivaRestaPuntoPorRespuestaInorrecta(){
        boolean respuestaJugador = true;
        IPregunta preguntaExclusiva = new PreguntaExclusiva();
        VoF preguntaVerdadera = preguntaExclusiva.VoF(false);
        assertEquals(-1,preguntaVerdadera.puntuar(respuestaJugador));
    }
    @Test
    public void test04PreguntaVerdaderaRecibeListaDeRespuestas(){
        Jugador jugador = new Jugador();
        Respuesta respuesta = new Respuesta(true,jugador);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);
        IPregunta pregunta = new PreguntaExclusiva();
        VoF preguntaVerdadera = pregunta.VoF(true);
        preguntaVerdadera.evaluarRespuestas(respuestas);
        assertEquals(1,jugador.puntos());
    }
}
