package edu.fiuba.algo3.modelo;

public class Jugador {
    private Puntaje puntaje;
    private Multiplicador multActual;
    private String nombre;

    public Jugador() {
        this.puntaje = new Puntaje();
        this.multActual = new MultiplicadorNormal();
    }

    public static Jugador jugadorConNombre(String nombre) {
        Jugador jugador = new Jugador();
        jugador.nombre=nombre;
        return jugador;
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
