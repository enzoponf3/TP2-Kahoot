package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVoFPenalTest {

    ///////////////////////////// Creación preguntas VoF ////////////////////////////////////////////////////
    @Test
    public void TestCreacionPreguntaVerderaParcialPuntua1ParaRespuestaVerdadera(){
        PreguntaVoFPenal preguntaV = PreguntaVoFPenal.crearPreguntaVerdadera();

        assertEquals(1, preguntaV.puntuarRespuestaV());
    }

    @Test
    public void TestCreacionPreguntaFalsaPuntuaMenos1ParaRespuestaVerdadera(){
        PreguntaVoFPenal preguntaF = PreguntaVoFPenal.crearPreguntaFalsa();

        assertEquals(-1, preguntaF.puntuarRespuestaV());
    }

    @Test
    public void TestCreacionPreguntaFalsaPuntua1ParaRespuestaFalsa(){
        PreguntaVoFPenal preguntaF = PreguntaVoFPenal.crearPreguntaFalsa();

        assertEquals(1, preguntaF.puntuarRespuestaF());
    }

    @Test
    public void TestCreacionPreguntaVerdaderaPuntuaMenos1ParaRespuestaFalsa(){
        PreguntaVoFPenal preguntaV = PreguntaVoFPenal.crearPreguntaVerdadera();

        assertEquals(-1, preguntaV.puntuarRespuestaF());
    }

    ///////////////////////////// Puntuación preguntas VoF ////////////////////////////////////////////////////

    @Test
    public void testPreguntaVPenalSumaPuntoAJugador1YRestaAJugador2() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaVoFPenal preguntaVPenal = PreguntaVoFPenal.crearPreguntaVerdadera();
        ArrayList<RespuestasJugador> respuestasJugadores= new <RespuestasJugador>ArrayList();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaVPenal.ElegirRespuestaVerdadera());
        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaVPenal.ElegirRespuestaFalsa());

        respuestasJugadores.add( respuestasJugador1);
        respuestasJugadores.add( respuestasJugador2);

        preguntaVPenal.evaluarRespuestas(respuestasJugadores);

        assertEquals(1, jugador1.puntos());
        assertEquals(-1, jugador2.puntos());
    }
}
