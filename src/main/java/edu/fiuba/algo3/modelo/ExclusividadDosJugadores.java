package edu.fiuba.algo3.modelo;

public class ExclusividadDosJugadores implements ExclusividadPuntaje {
    public Evaluador evaluadorJugador1;
    public Evaluador evaluadorJugador2;
    @Override
    public void puntuarJugadores() {
        if (this.evaluadorJugador1.puntaje().esMenor(this.evaluadorJugador2.puntaje())){
            this.evaluadorJugador2.puntaje().duplicar();
            this.evaluadorJugador2.puntaje().duplicar();
            this.evaluadorJugador2.jugador().puntuar(this.evaluadorJugador2.puntaje());
        }
        else if (this.evaluadorJugador2.puntaje().esMenor(this.evaluadorJugador1.puntaje())){
            this.evaluadorJugador1.puntaje().duplicar();
            this.evaluadorJugador1.puntaje().duplicar();
            this.evaluadorJugador1.jugador().puntuar(this.evaluadorJugador1.puntaje());
        }
    }

    @Override
    public ExclusividadPuntaje cambiarExclusividad() {
        return null;
    }

    @Override
    public void agregarEvaluador(Evaluador unEvaluador, Evaluador otroEvaluador) {
        this.evaluadorJugador1=unEvaluador;
        this.evaluadorJugador2=otroEvaluador;

    }


}
