package edu.fiuba.algo3.modelo;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVoFTest {


    ///////////////////////////// Creación preguntas VoF ////////////////////////////////////////////////////
    @Test
    public void TestCreacionPreguntaVerderaPuntua1ParaRespuestaVerdadera(){
        PreguntaVoF preguntaV = PreguntaVoF.crearPreguntaVerdadera();

        assertEquals(1, preguntaV.puntuarRespuestaV());
    }

    @Test
    public void TestCreacionPreguntaFalsaPuntua0ParaRespuestaVerdadera(){
        PreguntaVoF preguntaF = PreguntaVoF.crearPreguntaFalsa();

        assertEquals(0, preguntaF.puntuarRespuestaV());
    }

    @Test
    public void TestCreacionPreguntaFalsaPuntua1ParaRespuestaFalsa(){
        PreguntaVoF preguntaF = PreguntaVoF.crearPreguntaFalsa();

        assertEquals(1, preguntaF.puntuarRespuestaF());
    }


    ///////////////////////////// Puntuación preguntas VoF ////////////////////////////////////////////////////

    @Test
    public void testJugadorEligeVerdaderoAPreguntaVerdaderaYSumaUnPunto () {
        Jugador jugador = new Jugador();
        PreguntaVoF preguntaV = PreguntaVoF.crearPreguntaVerdadera();

        RespuestasJugador listaRespuestasJugador1 = new RespuestasJugador(jugador);
        listaRespuestasJugador1.agregarRespuesta(preguntaV.ElegirRespuestaVerdadera());

        preguntaV.evaluarRespuesta(listaRespuestasJugador1);

        assertEquals(1, jugador.darPuntos());
    }

    @Test
    public void testJugadorEligeFalsoAPreguntaVerdaderaYSumaCeroPuntos () {
        Jugador jugador = new Jugador();
        PreguntaVoF preguntaV = PreguntaVoF.crearPreguntaVerdadera();

        RespuestasJugador listaRespuestasJugador1 = new RespuestasJugador(jugador);
        listaRespuestasJugador1.agregarRespuesta(preguntaV.ElegirRespuestaFalsa());

        preguntaV.evaluarRespuesta(listaRespuestasJugador1);

        assertEquals(0, jugador.darPuntos());
    }

}
