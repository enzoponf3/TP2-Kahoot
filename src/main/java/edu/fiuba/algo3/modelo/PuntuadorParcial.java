package edu.fiuba.algo3.modelo;

public class PuntuadorParcial implements Puntuador {
    private Puntaje puntaje;

    public PuntuadorParcial() {
        this.puntaje = new PuntajePositivo();
    }

    public void acierto() { this.puntaje.sumarPunto(); }

    public void fallido() { this.puntaje = new PuntajeCero(); }

    public void puntuar(Jugador jugador) { this.puntaje.puntuar(jugador); }
}
