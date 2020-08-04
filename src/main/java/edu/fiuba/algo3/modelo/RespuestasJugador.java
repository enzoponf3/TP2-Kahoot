package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class RespuestasJugador {
    private ArrayList<Respuesta> listaRespuestas;
    private Jugador jugador;

    public RespuestasJugador(Jugador unJugador) {
        this.jugador = unJugador;
        this.listaRespuestas = new ArrayList<Respuesta>();
    }

    public void agregarRespuesta(Respuesta unaRespuesta) {
        this.listaRespuestas.add(unaRespuesta);
    }

    public void puntuarRespuestas() {
        for (Respuesta r : this.listaRespuestas) {
            r.puntuar(this.devolverJugador().devolverPuntaje());
        }
    }

    public Jugador devolverJugador() {
        return jugador;
    }
}
