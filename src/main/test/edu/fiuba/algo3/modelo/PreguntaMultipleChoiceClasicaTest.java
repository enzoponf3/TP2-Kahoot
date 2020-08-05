package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceClasicaTest {
    @Test
    public void TestCreacionPreguntaMCClasicaConDosRespuestasCorrectas(){
        PreguntaChoiceClasica pregunta1 = new PreguntaChoiceClasica(4,2);

        assertEquals(2, pregunta1.cantidadRespuestasCorrectas());
    }

    @Test
    public void TestPreguntaMCClasicaJugador1PuntuaPorContestarTodoBienJugador2NoPuntuaPorContestarUnaMal(){
        ArrayList <RespuestasJugador> respuestasJugadores= new <RespuestasJugador>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaChoiceClasica preguntaMC = new PreguntaChoiceClasica(4,3);
        preguntaMC.agregarRespuestasCorrectas();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaMC.elegirRespuesta(0));
        respuestasJugador1.agregarRespuesta(preguntaMC.elegirRespuesta(1));
        respuestasJugador1.agregarRespuesta(preguntaMC.elegirRespuesta(2));

        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaMC.elegirRespuesta(1));
        respuestasJugador2.agregarRespuesta(preguntaMC.elegirRespuesta(3));

        respuestasJugadores.add( respuestasJugador1);
        respuestasJugadores.add( respuestasJugador2);

        preguntaMC.evaluarRespuestas(respuestasJugadores);

        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }



}


