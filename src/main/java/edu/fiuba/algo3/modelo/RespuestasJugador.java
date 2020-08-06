package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class RespuestasJugador {
    private ArrayList<Evaluable> listaRespuestas;
    private Jugador jugador;

    public RespuestasJugador(Jugador unJugador) {
        this.jugador = unJugador;
        this.listaRespuestas = new ArrayList<Evaluable>();
    }

    public void agregarRespuesta(Evaluable unaRespuesta) {
        this.listaRespuestas.add(unaRespuesta);
    }

    public void evaluarRespuestasCon(Puntuador puntuador) {
        for(Evaluable r: this.listaRespuestas) { r.evaluarCon(puntuador); }
        puntuador.puntuar(this.jugador);
    }

    public ArrayList<Evaluable> devolverRespuestas() {
        return this.listaRespuestas;
    }
}
