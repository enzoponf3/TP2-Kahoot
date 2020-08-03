package edu.fiuba.algo3.modelo;

public class NoAcertado implements Validez {
    public int puntuar(){return 0;}

    public void evaluarCon(Puntuador puntuador) { puntuador.fallido(); }
}
