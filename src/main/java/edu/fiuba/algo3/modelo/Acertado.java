package edu.fiuba.algo3.modelo;

public class Acertado implements Validez {
    public int puntuar() {
        return 1;
    }

    public void evaluarCon(Puntuador puntuador) { puntuador.acierto(); }
}
