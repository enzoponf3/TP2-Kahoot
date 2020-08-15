package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class PreguntaVoF implements Pregunta{
    protected String enunciadoPregunta;
    private ArrayList<Respuesta> respuestas;

    public PreguntaVoF() {
        this.respuestas = new ArrayList<Respuesta>();
        for (int i = 0; i < 2; i++) {
            this.respuestas.add(new Respuesta());
        }
    }

    public void setRespuestaVerdadera() {
        this.respuestas.get(0).establecerComoRespuestaAcertada();
    }

    public void setRespuestaFalsa() {
        this.respuestas.get(1).establecerComoRespuestaAcertada();
    }

    public abstract void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores);

    public Iterator<Respuesta> devolverRespuestasPosibles(){
        return respuestas.iterator();
    }

    public Respuesta elegirRespuesta(int idx){  // para TEST
        return respuestas.get(idx);
    }

    public String devolverEnunciado() {
        return this.enunciadoPregunta;
    }
}
