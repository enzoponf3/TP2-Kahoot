package edu.fiuba.algo3.modelo;

public class Jugador {
    private Puntaje puntaje;
    private Multiplicador multActual;

    public Jugador() {
        this.puntaje = new Puntaje();
        multActual = new MultiplicadorNormal();
    }

    public int puntos() {
        return this.puntaje.darPuntosTests();
    }

    public void puntuar(Puntaje puntaje) {
        multActual.aplicar(puntaje);
        this.puntaje.sumar(puntaje);
        this.multActual = new MultiplicadorNormal();
    }

    public void modificarMultiplicador(Multiplicador unMultiplicador) {
        this.multActual=unMultiplicador;
    }
}
