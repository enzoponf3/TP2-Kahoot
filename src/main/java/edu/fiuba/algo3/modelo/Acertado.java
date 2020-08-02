package edu.fiuba.algo3.modelo;

public class Acertado implements Validez {
    public int puntuar() {
        return 1;
    }

    public boolean esAcertado() { return true; }

    public void evaluarCon(Puntuador puntuador) { puntuador.acierto(); }
}
