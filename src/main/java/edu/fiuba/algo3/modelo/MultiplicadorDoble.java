package edu.fiuba.algo3.modelo;

public class MultiplicadorDoble implements Multiplicador {

    @Override
    public void aplicar(Puntaje puntaje) {
        puntaje.duplicar();

    }

    @Override
    public void activarMultiplicadorPara(Jugador unJugador) {
        unJugador.modificarMultiplicador(this);
    }
}
