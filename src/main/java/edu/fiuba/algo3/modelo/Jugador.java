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
        this.puntaje.sumar(puntaje);
    }

    public void usarDoble() {
        this.multActual = new MultiplicadorDoble();

    }
    public void usarTriple(){
        this.multActual = new MultiplicadorTriple();
    }

    public void usarMultiplicador(Puntaje puntaje) {
        multActual.aplicar(puntaje);
        this.puntuar(puntaje);
        this.multActual = new MultiplicadorNormal();
    }
}
