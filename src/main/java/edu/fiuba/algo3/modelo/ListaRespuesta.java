package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ListaRespuesta {
    private ArrayList<Respuesta> listaRespuestas;
    private Jugador jugador;

    public ListaRespuesta(Jugador unJugador) {
        this.jugador=unJugador;
    }

    public void agregarRespuesta(Respuesta unaRespuesta) {
        this.listaRespuestas.add(unaRespuesta);
    }
}
