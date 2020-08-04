package edu.fiuba.algo3.modelo;

public class Jugador {
    private Puntaje puntajeJugador;

    public Jugador() {
        this.puntajeJugador = new Puntaje();
    }

    public Puntaje devolverPuntaje() {
        return puntajeJugador;
    }

}
