package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ale.Jugador;
import edu.fiuba.algo3.modelo.ale.PreguntaVoF;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PreguntasTest {

    @Test
    public void test01CrearPreguntaExclusivaVoFVerdadera(){

        IPregunta preguntaExclusiva = new PreguntaExclusiva();
        PreguntaVoF preguntaVerdadera = preguntaExclusiva.VoF(true);

        assertTrue( preguntaVerdadera.verdad());

    }
    @Test
    public void test02CrearPreguntaExclusivaVoFFalsa(){
        IPregunta preguntaExclusiva = new PreguntaExclusiva();
        PreguntaVoF preguntaFalsa = preguntaExclusiva.VoF(false);

        assertFalse( preguntaFalsa.verdad());
    }
    @Test
    public void test03PreguntaExlusivaSumaPuntoPorRespuestaCorrecta(){
        boolean respuestaJugador = true;
        IPregunta preguntaExclusiva = new PreguntaExclusiva();
        PreguntaVoF preguntaVerdadera = preguntaExclusiva.VoF(true);
        assertEquals(1,preguntaVerdadera.puntuar(respuestaJugador));
    }
    @Test
    public void test04PreguntaExlusivaRestaPuntoPorRespuestaInorrecta(){
        boolean respuestaJugador = true;
        IPregunta preguntaExclusiva = new PreguntaExclusiva();
        PreguntaVoF preguntaVerdadera = preguntaExclusiva.VoF(false);
        assertEquals(-1,preguntaVerdadera.puntuar(respuestaJugador));
    }
    @Test
    public void test04PreguntaVerdaderaRecibeListaDeRespuestas(){
        Jugador jugador = new Jugador();
        Respuesta respuesta = new Respuesta(true,jugador);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);
        IPregunta pregunta = new PreguntaExclusiva();
        PreguntaVoF preguntaVerdadera = pregunta.VoF(true);
        preguntaVerdadera.evaluarRespuestas(respuestas);
        assertEquals(1,jugador.puntos());
    }
}
