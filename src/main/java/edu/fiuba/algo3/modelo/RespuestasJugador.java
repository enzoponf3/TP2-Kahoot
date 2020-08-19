package edu.fiuba.algo3.modelo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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

    public void evaluarRespuestasCon(Evaluador evaluador) {
        for(Respuesta r: this.listaRespuestas) {
            r.evaluarCon(evaluador);
        }
        evaluador.sumarPuntosParciales();
    }

    public ArrayList<Respuesta> devolverRespuestas() {
        return this.listaRespuestas;
    }

    public Jugador devolverJugador() {
        return this.jugador;
    }

    public void sacarUltimaRespuesta() {
        this.listaRespuestas.remove(this.listaRespuestas.size()-1);
    }

    public void limpiar() {
        this.listaRespuestas.clear();
    }
}
