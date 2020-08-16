package edu.fiuba.algo3.modelo;

public class Jugador {
    private Puntaje puntaje;
    private Multiplicador multActual;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntaje();
        this.multActual = new MultiplicadorNormal();
    }

    public int puntos() {
        return this.puntaje.darPuntosTests();
    }

    public void puntuar(Puntaje puntaje) {
        multActual.aplicar(puntaje);
        this.puntaje.sumar(puntaje);
        this.multActual = new MultiplicadorNormal();
    }

    public String getNombre(){
        return this.nombre;
    }

    public void modificarMultiplicador(Multiplicador unMultiplicador) {
        this.multActual=unMultiplicador;
    }
}
