package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

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

    public void evaluarRespuestasCon(Puntuador puntuador) {
        for(Respuesta r: this.listaRespuestas) {
            r.evaluarCon(puntuador);
        }
        puntuador.puntuar(this.jugador);
    }

    public ArrayList<Respuesta> devolverRespuestas() {
        return this.listaRespuestas;
    }

    public Jugador devolverJugador() {
        return this.jugador;
    }
}
