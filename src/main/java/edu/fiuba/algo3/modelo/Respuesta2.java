package edu.fiuba.algo3.modelo;

public class Respuesta2 {
    private Validez validez;

    static public Respuesta2 crearRespuestaAcertada() {
        Respuesta2 respuesta = new Respuesta2();
        respuesta.setValidezAcertado();
        return respuesta;
    }

    static public Respuesta2 crearRespuestaNoAcertada() {
        Respuesta2 respuesta = new Respuesta2();
        respuesta.setValidezNoAcertado();
        return respuesta;
    }

    public void setValidezAcertado() {
        this.validez = new Acertado();
    }

    public void setValidezNoAcertado() {
        this.validez = new NoAcertado();
    }

    public int puntuar() {
        return this.validez.puntuar();
    }
}
