package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceOrdererTest {

    @Test
    public void TestPreguntaMCOrdererJugador1Con3CorrectasSeLeAsigna1PuntoYJugador2Con0CorrectasSeLeAsigna0Puntos(){

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Opcion opcion1 = new Opcion("1");
        Opcion opcion2 = new Opcion("2");
        Opcion opcion3 = new Opcion("3");

        ArrayList<Opcion> opcionesOrdenadas = new ArrayList<>();

        opcionesOrdenadas.add(opcion1);
        opcionesOrdenadas.add(opcion2);
        opcionesOrdenadas.add(opcion3);

        PreguntaChoiceOrderer pregunta1 = new PreguntaChoiceOrderer(opcionesOrdenadas);

        RespuestasJugador opcionesJugador1 = new RespuestasJugador(jugador1);


        opcionesJugador1.agregarOpcionesElegidas(opcion1);
        opcionesJugador1.agregarOpcionesElegidas(opcion2);
        opcionesJugador1.agregarOpcionesElegidas(opcion3);

        RespuestasJugador opcionesJugador2 = new RespuestasJugador(jugador2);

        opcionesJugador2.agregarOpcionesElegidas(opcion1);
        opcionesJugador2.agregarOpcionesElegidas(opcion3);
        opcionesJugador2.agregarOpcionesElegidas(opcion2);
        

        pregunta1.evaluarRespuestas(opcionesJugador1);
        pregunta1.evaluarRespuestas(opcionesJugador2);


        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }
}
