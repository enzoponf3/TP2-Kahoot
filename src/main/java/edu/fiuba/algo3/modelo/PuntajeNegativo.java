package edu.fiuba.algo3.modelo;

public class PuntajeNegativo implements Puntaje {
    private int puntos;

    public PuntajeNegativo() {
        this.puntos = 0;
    }

    public void sumarPunto() { this.puntos -= 1; }
    public void puntuar(Jugador jugador) {
        jugador.asignarPuntos(this.puntos);
    }
}
