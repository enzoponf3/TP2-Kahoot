package edu.fiuba.algo3.modelo;

import java.util.Stack;

public class PreguntaVoF2 {
    private final Respuesta2 respuestaVerdadera;
    private final Respuesta2 respuestaFalsa;

    public PreguntaVoF2() {
        this.respuestaVerdadera = new Respuesta2();
        this.respuestaFalsa = new Respuesta2();
    }

    static public PreguntaVoF2 crearPreguntaVerdadera() {
        PreguntaVoF2 pregunta = new PreguntaVoF2();
        pregunta.setRespuestaVerdadera();
        return pregunta;
    }

    static public PreguntaVoF2 crearPreguntaFalsa() {
        PreguntaVoF2 pregunta = new PreguntaVoF2();
        pregunta.setRespuestaFalsa();
        return pregunta;
    }

    public void setRespuestaVerdadera() {
        this.respuestaVerdadera.establecerComoRespuestaAcertada();
    }

    public void setRespuestaFalsa() {
        this.respuestaFalsa.establecerComoRespuestaAcertada();
    }

    public void esVerdadero(Jugador3 jugador) {
        jugador.asignarPuntos(this.respuestaVerdadera.puntuar());
    }

    public void esFalso(Jugador3 jugador) {
        jugador.asignarPuntos(this.respuestaFalsa.puntuar());
    }
}
