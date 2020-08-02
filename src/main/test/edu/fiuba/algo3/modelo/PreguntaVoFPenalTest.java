package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

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
    public void testJugadorEligeVerdaderoAPreguntaVerdaderaYSumaUnPunto () {
        Jugador jugador = new Jugador();
        PreguntaVoFPenal preguntaV = PreguntaVoFPenal.crearPreguntaVerdadera();

        RespuestasJugador listaRespuestasJugador1 = new RespuestasJugador(jugador);
        listaRespuestasJugador1.agregarRespuesta(preguntaV.ElegirRespuestaVerdadera());

        preguntaV.evaluarRespuesta(listaRespuestasJugador1);

        assertEquals(1, jugador.darPuntos());
    }

    @Test
    public void testJugadorEligeFalsoAPreguntaVerdaderaYSumaCeroPuntos () {
        Jugador jugador = new Jugador();
        PreguntaVoFPenal preguntaV = PreguntaVoFPenal.crearPreguntaVerdadera();

        RespuestasJugador listaRespuestasJugador1 = new RespuestasJugador(jugador);
        listaRespuestasJugador1.agregarRespuesta(preguntaV.ElegirRespuestaFalsa());

        preguntaV.evaluarRespuesta(listaRespuestasJugador1);

        assertEquals(-1, jugador.darPuntos());
    }

}
