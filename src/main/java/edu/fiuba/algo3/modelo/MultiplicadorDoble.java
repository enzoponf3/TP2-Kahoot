package edu.fiuba.algo3.modelo;

public class MultiplicadorDoble implements Multiplicador {

    @Override
    public void aplicar(Puntaje puntaje) {
        puntaje.duplicar();

    }
}
