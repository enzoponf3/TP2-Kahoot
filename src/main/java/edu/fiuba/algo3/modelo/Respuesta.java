package edu.fiuba.algo3.modelo;

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
