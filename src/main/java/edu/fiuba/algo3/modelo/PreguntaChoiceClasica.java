package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaChoiceClasica {
    private ArrayList<Respuesta> respuestaPosibles;
    private int cantidadCorrectas = 0;
    private int cantidadOpciones = 0;
    private EvaluadorClasico evaluador;

    public PreguntaChoiceClasica(int numeroDeOpciones,int cantidadCorrectasDeseadas){
        this.cantidadCorrectas= cantidadCorrectasDeseadas;
        this.cantidadOpciones = numeroDeOpciones;
        this.evaluador = new EvaluadorClasico();
        this.respuestaPosibles = new ArrayList<Respuesta>();
        for (int i=0;i < this.cantidadOpciones; i++){
            respuestaPosibles.add(new Respuesta());
        }
    }

    public void agregarRespuestaCorrecta(Respuesta unaRespuesta) {
        unaRespuesta.establecerComoRespuestaAcertada();
        this.respuestaPosibles.add(unaRespuesta);
    }

    public void evaluarRespuesta(ArrayList<RespuestasJugador> listaRespuestasJugadores) {
        for (RespuestasJugador iterador: listaRespuestasJugadores) {
            if (iterador.puntuarRespuestas() == this.cantidadCorrectas) {
                iterador.puntuarJugador(1);
            }
        }
    }

    protected int cantidadRespuestasCorrectas() {
        return this.cantidadCorrectas;
    }

    public void agregarRespuestasCorrectas() {
        int i=0;
        for (Respuesta r : this.respuestaPosibles) {
            if (i < this.cantidadCorrectas) {
                r.establecerComoRespuestaAcertada();
                i++;
            }
        }
    }

    public Respuesta elegirRespuesta(int idx){
        return respuestaPosibles.get(idx);
    }
}
