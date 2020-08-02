package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaChoiceParcial {
    private ArrayList<Respuesta> listaRespuestasCorrectas;
    private int cantidadCorrectas = 0;
    private int cantidadOpciones = 0;
    Evaluador evaluador;

    public PreguntaChoiceParcial(int numeroDeOpciones) {
        this.listaRespuestasCorrectas= new ArrayList<Respuesta>();
        this.cantidadOpciones = numeroDeOpciones;
        this.evaluador = new EvaluadorParcial();
    }

    public void agregarRespuestaCorrecta(Respuesta unaRespuesta) {
        unaRespuesta.establecerComoRespuestaAcertada();
        this.listaRespuestasCorrectas.add(unaRespuesta);
        this.cantidadCorrectas+=1;
    }

    public void evaluarRespuesta(ArrayList<RespuestasJugador> listaRespuestasJugadores) {
        for (RespuestasJugador iterador: listaRespuestasJugadores) {
                iterador.puntuarJugador(iterador.puntuarRespuestas());
        }
    }

    // Refactor con Evaluador

    public void evaluarRespuestaConEvaluador(ArrayList<RespuestasJugador> listaRespuestasJugadores) {
        for (RespuestasJugador iterador: listaRespuestasJugadores) {
            iterador.puntuarJugadorCon(this.evaluador);
        }
    }

    protected int cantidadRespuestasCorrectas() {
        return this.cantidadCorrectas;
    }

}
