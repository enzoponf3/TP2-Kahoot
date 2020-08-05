package edu.fiuba.algo3.modelo;

public class PuntuadorPenal implements Puntuador {
    private Puntaje puntaje;

    public PuntuadorPenal() {

        this.puntaje = new Puntaje();
    }

    public void acierto() { this.puntaje.sumarPunto(); }

    public void fallido() { this.puntaje.restarPunto(); }

    public void puntuar(Jugador jugador) { jugador.usarMultiplicador(this.puntaje); }
}
