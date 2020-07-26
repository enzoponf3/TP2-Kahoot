package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ale.Jugador;

public class Respuesta {
    private boolean resp;
    private Jugador jug;
    public Respuesta(boolean b, Jugador jugador) {
        resp=b;
        jug=jugador;
    }

    public boolean valor() {
        return resp;
    }

    public void sumarPuntos(int puntaje) {
        this.jug.sumarPuntos(puntaje);
    }
}
