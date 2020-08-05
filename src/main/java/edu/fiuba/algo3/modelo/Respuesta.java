package edu.fiuba.algo3.modelo;


public class Respuesta {
    private Validez validez;

    public Respuesta(){
        this.validez = new NoAcertado();
    }

    public void establecerComoRespuestaAcertada() {
        this.validez = new Acertado();
    }

    public void establecerComoRespuestalNoAcertadaPenal(){
        this.validez = new NoAcertadoPenal();
    }

    public int puntuar() {
        return this.validez.puntuar();
    }

    public void evaluarCon(Puntuador puntuador) { this.validez.evaluarCon(puntuador); }
}
