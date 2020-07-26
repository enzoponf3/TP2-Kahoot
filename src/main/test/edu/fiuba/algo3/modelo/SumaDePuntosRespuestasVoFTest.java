package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumaDePuntosRespuestasVoFTest {

    @Test
    public void PreguntaVoFRecibeDosRespuestasYSumaPuntos(){
        ArrayList <Jugador2> listaDeRespuesta = new ArrayList<Jugador2>();
        Jugador2 jugador1 = new Jugador2(true);
        Jugador2 jugador2 = new Jugador2(false);

        listaDeRespuesta.add(jugador1);
        listaDeRespuesta.add(jugador2);

        PreguntaVoF2 preguntaV = PreguntaVoF2.crearPreguntaVoFConRespuesta(true);

        preguntaV.revisionRespuestas(listaDeRespuesta);

        assertEquals(1,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }

    @Test
    public void PreguntaVoFRecibeUnJugadorYLoPuntua (){
        Jugador2 jugador1 = new Jugador2(true);
        Jugador2 jugador2 = new Jugador2(false);

        PreguntaVoF2 preguntaV = PreguntaVoF2.crearPreguntaVoFConRespuesta(true);

        preguntaV.revisionRespuestaDeUnJugador(jugador1);
        preguntaV.revisionRespuestaDeUnJugador(jugador1);


        assertEquals(2,jugador1.puntos());

    }


}
