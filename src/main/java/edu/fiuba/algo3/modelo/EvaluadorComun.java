package edu.fiuba.algo3.modelo;

public class EvaluadorComun implements Evaluador {
    private Puntaje puntajeParcial;
    private Jugador jugador;

    public EvaluadorComun(Jugador unJugador) {
        this.puntajeParcial = new Puntaje();
        this.jugador=unJugador;
    }

    public void acierto() { this.puntajeParcial.sumarPunto(); }

    public void fallido() {}

    @Override
    public void sumarPuntosParciales() {
    }

    public Puntaje puntaje(){
        return this.puntajeParcial;
    }

    public Jugador jugador(){
        return this.jugador;
    }
}
