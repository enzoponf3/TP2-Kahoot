package edu.fiuba.algo3.modelo;

public class EvaluadorPenal implements Evaluador {
    private Puntaje puntaje;

    public EvaluadorPenal() {

        this.puntaje = new Puntaje();
    }

    public void acierto() { this.puntaje.sumarPunto(); }

    public void fallido() { this.puntaje.restarPunto(); }

    @Override
    public void sumarPuntosParciales() {
    }

    @Override
    public Puntaje puntaje() {
        return this.puntaje;
    }

    @Override
    public Jugador jugador() {
        return null;
    }
}
