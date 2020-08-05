package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceOrdererTest {

    @Test
    public void TestPreguntaMCOrdererJugador1Con3CorrectasSeLeAsigna1PuntoYJugador2Con0CorrectasSeLeAsigna0Puntos(){
        //List<RespuestasJugador> listaRespuestasJugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Opcion opcion1 = new Opcion("1");
        Opcion opcion2 = new Opcion("2");
        Opcion opcion3 = new Opcion("3");

        ArrayList<Opcion> opcionesOrdenadas = new ArrayList<>();

        opcionesOrdenadas.add(opcion1);
        opcionesOrdenadas.add(opcion2);
        opcionesOrdenadas.add(opcion3);

        PreguntaOrdererChoice pregunta1 = new PreguntaOrdererChoice(opcionesOrdenadas);

        RespuestasJugador opcionesJugador1 = new RespuestasJugador(jugador1);
        ArrayList<Opcion> listaRespuestasJugador1 = new ArrayList<>();
        listaRespuestasJugador1.add(opcion1);
        listaRespuestasJugador1.add(opcion2);
        listaRespuestasJugador1.add(opcion3);

        opcionesJugador1.agregarOpcionesElegidas(listaRespuestasJugador1);

        pregunta1.evaluarRespuestas(opcionesJugador1);

        assertEquals(1, jugador1.puntos());

        RespuestasJugador opcionesJugador2 = new RespuestasJugador(jugador2);
        ArrayList<Opcion> listaRespuestasJugador2 = new ArrayList<>();
        listaRespuestasJugador1.add(opcion3);
        listaRespuestasJugador1.add(opcion2);
        listaRespuestasJugador1.add(opcion1);


        opcionesJugador2.agregarOpcionesElegidas(listaRespuestasJugador2);

        //listaRespuestasJugadores.add(opcionesJugador1);
        //listaRespuestasJugadores.add(opcionesJugador2);

        pregunta1.evaluarRespuestas(opcionesJugador2);

        assertEquals(0, jugador2.puntos());
    }
}
