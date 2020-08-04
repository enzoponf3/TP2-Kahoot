package edu.fiuba.algo3.modelo;

public class PuntuadorPenal implements Puntuador {
    private Puntaje puntaje;

    public PuntuadorPenal() {
        this.puntaje = new PuntajePositivo();
    }

    public void acierto() {
        this.puntaje.sumarPunto();
    }

    public void fallido() {
        this.puntaje = new PuntajeNegativo();
    }

    public void falla(){
        this.puntaje.sumarPunto();
    }

    public void puntuar(Jugador jugador) {
        this.puntaje.puntuar(jugador);
    }
}
