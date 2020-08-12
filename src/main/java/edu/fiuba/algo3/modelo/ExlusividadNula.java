package edu.fiuba.algo3.modelo;

public class ExlusividadNula implements ExclusividadPuntaje {
    public Evaluador evaluadorJugador1;
    public Evaluador evaluadorJugador2;

    public void puntuarJugadores() {
        this.evaluadorJugador1.jugador().puntuar(this.evaluadorJugador1.puntaje());
        this.evaluadorJugador2.jugador().puntuar(this.evaluadorJugador2.puntaje());
    }

    public ExclusividadPuntaje cambiarExclusividad(){
        return (new ExclusividadUnJugador());
    }

    @Override
    public void agregarEvaluador(Evaluador evaluadorJugador1, Evaluador evaluadorJugador2) {
        this.evaluadorJugador1=evaluadorJugador1;
        this.evaluadorJugador2=evaluadorJugador2;
    }


}
