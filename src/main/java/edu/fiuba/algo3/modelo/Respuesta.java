package edu.fiuba.algo3.modelo;

public class Respuesta {
    private Validez validez;

    public Respuesta() {
        this.validez = new NoAcertado();
    }

    public void establecerComoRespuestaAcertada() {
        this.validez = new Acertado();
    }

    public void establecerComoRespuestaAcertadaParcial() {
        this.validez = new AcertadoParcial();
    }

    public void establecerComoRespuestalNoAcertadaPenal(){
        this.validez = new NoAcertadoPenal();
    }

    public void puntuar(Puntaje puntajeJugador) {this.validez.puntuar(puntajeJugador);}
}
