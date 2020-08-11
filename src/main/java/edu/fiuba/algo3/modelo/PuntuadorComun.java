package edu.fiuba.algo3.modelo;

public class PuntuadorComun implements Puntuador {
    private Puntaje puntaje;

    public PuntuadorComun() {
        this.puntaje = new Puntaje();
    }

    public void acierto() { this.puntaje.sumarPunto(); }

    public void fallido() {}

    public void puntuar(Jugador jugador) { jugador.puntuar(this.puntaje); }

    public Puntaje darPuntaje(){
        return this.puntaje;
    }
}
