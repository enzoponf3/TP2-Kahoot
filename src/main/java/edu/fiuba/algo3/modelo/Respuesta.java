package edu.fiuba.algo3.modelo;


public class Respuesta implements Evaluable {
    private ValidezRespuesta validez;

    public Respuesta() {
        this.validez = new Incorrecta();
    }

    public void establecerComoRespuestaAcertada() {
        this.validez = new Correcta();
    }

    public int puntuar() {
        return this.validez.puntuar();
    }

    public void evaluarCon(Puntuador puntuador) {
        this.validez.evaluarCon(puntuador);
    }
}
