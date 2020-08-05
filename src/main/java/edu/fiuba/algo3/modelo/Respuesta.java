package edu.fiuba.algo3.modelo;

public class Respuesta {
    private ValidezRespuesta validez;

    public Respuesta() {
        this.validez = new Incorrecta();
    }

    public void establecerComoRespuestaAcertada() {
        this.validez = new Correcta();
    }

    public void establecerComoRespuestalNoAcertadaPenal(){
        this.validez = new IncorrectaPenal();
    }

    public int puntuar() {
        return this.validez.puntuar();
    }

    public void evaluarCon(Puntuador puntuador) {
        this.validez.evaluarCon(puntuador);
    }
}
