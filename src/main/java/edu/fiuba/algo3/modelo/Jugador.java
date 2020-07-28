package edu.fiuba.algo3.modelo;

public class Jugador {
    private int puntos;

    public Jugador() {
        this.puntos = 0;
    }

    public void asignarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int darPuntos() {
        return this.puntos;
    }
}
