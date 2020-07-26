package edu.fiuba.algo3.modelo;

public class Jugador3 {
    private int puntos;

    public Jugador3() {
        this.puntos = 0;
    }

    public void asignarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int darPuntos() {
        return this.puntos;
    }
}
