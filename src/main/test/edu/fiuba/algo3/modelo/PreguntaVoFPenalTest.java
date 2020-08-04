package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVoFPenalTest {

    ///////////////////////////// Creación preguntas VoF ////////////////////////////////////////////////////
    @Test
    public void TestCreacionPreguntaVerderaParcialPuntua1ParaRespuestaVerdadera(){
        PreguntaVoFPenal preguntaV = PreguntaVoFPenal.crearPreguntaVerdadera();

       // assertEquals(1, preguntaV.puntuarRespuestaV());
    }

    @Test
    public void TestCreacionPreguntaFalsaPuntuaMenos1ParaRespuestaVerdadera(){
        PreguntaVoFPenal preguntaF = PreguntaVoFPenal.crearPreguntaFalsa();

      //  assertEquals(-1, preguntaF.puntuarRespuestaV());
    }

    @Test
    public void TestCreacionPreguntaFalsaPuntua1ParaRespuestaFalsa(){
        PreguntaVoFPenal preguntaF = PreguntaVoFPenal.crearPreguntaFalsa();

       // assertEquals(1, preguntaF.puntuarRespuestaF());
    }

    @Test
    public void TestCreacionPreguntaVerdaderaPuntuaMenos1ParaRespuestaFalsa(){
        PreguntaVoFPenal preguntaV = PreguntaVoFPenal.crearPreguntaVerdadera();

        //assertEquals(-1, preguntaV.puntuarRespuestaF());
    }

    ///////////////////////////// Puntuación preguntas VoF ////////////////////////////////////////////////////

    @Test
    public void testJugadorEligeVerdaderoAPreguntaVerdaderaYSumaUnPunto () {
        Jugador jugador = new Jugador();
        PreguntaVoFPenal preguntaV = PreguntaVoFPenal.crearPreguntaVerdadera();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador);
        respuestasJugador1.agregarRespuesta(preguntaV.ElegirRespuestaVerdadera());

        preguntaV.evaluarRespuesta(respuestasJugador1);

        assertEquals(1, jugador.devolverPuntaje().devolverPuntos());
    }

    @Test
    public void testJugadorEligeFalsoAPreguntaVerdaderaYRestaUnPunto () {
        Jugador jugador = new Jugador();
        PreguntaVoFPenal preguntaV = PreguntaVoFPenal.crearPreguntaVerdadera();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador);
        respuestasJugador1.agregarRespuesta(preguntaV.ElegirRespuestaFalsa());

        preguntaV.evaluarRespuesta(respuestasJugador1);

        assertEquals(-1, jugador.devolverPuntaje().devolverPuntos());
    }

}
