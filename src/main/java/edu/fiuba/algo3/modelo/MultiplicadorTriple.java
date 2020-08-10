package edu.fiuba.algo3.modelo;

public class MultiplicadorTriple implements Multiplicador {
    @Override
    public void aplicar(Puntaje puntaje) {
        puntaje.triplicar();
    }

    @Override
    public void activarMultiplicadorPara(Jugador unJugador) {
        unJugador.modificarMultiplicador(this);
    }
}
