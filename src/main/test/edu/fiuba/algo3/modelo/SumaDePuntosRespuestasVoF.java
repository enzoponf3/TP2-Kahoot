package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumaDePuntosRespuestasVoF {

    @Test
    public void PreguntaVoFRecibeDosRespuestasYSumaPuntos(){
        ArrayList <Jugador> listaDeRespuesta = new ArrayList<Jugador>();
        Jugador jugador1 = new Jugador(true);
        Jugador jugador2 = new Jugador(false);

        listaDeRespuesta.add(jugador1);
        listaDeRespuesta.add(jugador2);

        PreguntaVoF preguntaV = PreguntaVoF.crearPreguntaVoFConRespuesta(true);

        preguntaV.revisionRespuestas(listaDeRespuesta);

        assertEquals(1,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }

    @Test
    public void PreguntaVoFRecibeUnJugadorYLoPuntua (){
        Jugador jugador1 = new Jugador(true);
        Jugador jugador2 = new Jugador(false);

        PreguntaVoF preguntaV = PreguntaVoF.crearPreguntaVoFConRespuesta(true);

        preguntaV.revisionRespuestaDeUnJugador(jugador1);
        preguntaV.revisionRespuestaDeUnJugador(jugador1);


        assertEquals(2,jugador1.puntos());

    }
}
