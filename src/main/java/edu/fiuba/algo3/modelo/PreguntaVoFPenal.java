package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVoFPenal {
    private  Respuesta respuestaVerdadera;
    private  Respuesta respuestaFalsa;

    public PreguntaVoFPenal(){
        this.respuestaVerdadera = new Respuesta();
        this.respuestaFalsa = new Respuesta();
        this.respuestaVerdadera.establecerComoRespuestaNoAcertadaPenal();
        this.respuestaFalsa.establecerComoRespuestaNoAcertadaPenal();
    }

    static public PreguntaVoFPenal crearPreguntaVerdadera() {
        PreguntaVoFPenal pregunta = new PreguntaVoFPenal();
        pregunta.setRespuestaVerdadera();
        return pregunta;
    }

    static public PreguntaVoFPenal crearPreguntaFalsa() {
        PreguntaVoFPenal pregunta = new PreguntaVoFPenal();
        pregunta.setRespuestaFalsa();
        return pregunta;
    }

    public void setRespuestaVerdadera() {
        this.respuestaVerdadera.establecerComoRespuestaAcertada();
    }

    public void setRespuestaFalsa() {
        this.respuestaFalsa.establecerComoRespuestaAcertada();
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            iterador.evaluarRespuestasCon(new PuntuadorPenal());
        }
    }

    public Respuesta ElegirRespuestaFalsa() {
        return respuestaFalsa;
    }
    public Respuesta ElegirRespuestaVerdadera() {
        return respuestaVerdadera;
    }

    protected int puntuarRespuestaV(){
        return this.respuestaVerdadera.puntuar();
    }

    protected int puntuarRespuestaF(){
        return this.respuestaFalsa.puntuar();
    }
}


