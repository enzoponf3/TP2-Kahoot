package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class PreguntaVoF implements Pregunta{
    protected String enunciadoPregunta;
    private final ArrayList<Respuesta> respuestas;

    public PreguntaVoF() {
        this.respuestas = new ArrayList<>();
        this.respuestas.add(new Respuesta("V"));
        this.respuestas.add(new Respuesta("F"));
    }

    public void setRespuestaVerdadera() {
        this.respuestas.get(0).establecerComoRespuestaAcertada();
    }

    public void setRespuestaFalsa() {
        this.respuestas.get(1).establecerComoRespuestaAcertada();
    }

    public abstract void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores);

    @Override
    public ArrayList<Respuesta> devolverRespuestasPosibles() {
        return this.respuestas;
    }

    public Respuesta elegirRespuesta(int idx){  // para TEST
        return respuestas.get(idx);
    }

    public String devolverEnunciado() {
        return this.enunciadoPregunta;
    }
}
