package edu.fiuba.algo3.modelo;

public class Respuesta {
    private ValidezRespuesta validez;
    private String enunciado = "algo";

    public Respuesta() {
        this.validez = new Incorrecta();
    }

    public void establecerComoRespuestaAcertada() {
        this.validez = new Correcta();
    }

    public void evaluarCon(Evaluador evaluador) {
        this.validez.evaluarCon(evaluador);
    }

    public String devolverEnunciado() {
        return this.enunciado;
    }
}
