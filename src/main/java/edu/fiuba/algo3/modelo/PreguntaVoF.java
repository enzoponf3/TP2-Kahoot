package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class PreguntaVoF {
    private Respuesta respuestaVerdadera;
    private Respuesta respuestaFalsa;

    public PreguntaVoF() {
        this.respuestaVerdadera = new Respuesta();
        this.respuestaFalsa = new Respuesta();
    }

    public void setRespuestaVerdadera() {
        this.respuestaVerdadera.establecerComoRespuestaAcertada();
    }

    public void setRespuestaFalsa() {
        this.respuestaFalsa.establecerComoRespuestaAcertada();
    }

    public abstract void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores);

    public Respuesta ElegirRespuestaFalsa() {
        return respuestaFalsa;
    }
    public Respuesta ElegirRespuestaVerdadera() {
        return respuestaVerdadera;
    }
}
