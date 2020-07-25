package edu.fiuba.algo3.modelo;

public class Respuesta2 {
    private Validez validez;

    public Respuesta2() {
        this.validez = new NoAcertado();
    }

    public void establecerComoRespuestaAcertada() {
        this.validez = new Acertado();
    }

    public int puntuar() {
        return this.validez.puntuar();
    }
}
