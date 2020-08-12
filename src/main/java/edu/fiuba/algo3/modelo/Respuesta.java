package edu.fiuba.algo3.modelo;

public class Respuesta {
    private ValidezRespuesta validez;

    public Respuesta() {
        this.validez = new Incorrecta();
    }

    public void establecerComoRespuestaAcertada() {
        this.validez = new Correcta();
    }

    public void evaluarCon(Evaluador evaluador) {
        this.validez.evaluarCon(evaluador);
    }
}
