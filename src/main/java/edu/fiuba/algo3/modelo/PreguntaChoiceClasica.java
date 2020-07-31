package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PreguntaChoiceClasica {
    private ArrayList<Respuesta> listaRespuestasCorrectas;
    private int cantidadCorrectas = 0;
    private int cantidadOpciones = 0;
    private EvaluadorClasico evaluador;

    public PreguntaChoiceClasica(int numeroDeOpciones){
        this.listaRespuestasCorrectas= new ArrayList<Respuesta>();
        this.cantidadOpciones = numeroDeOpciones;
        this.evaluador = new EvaluadorClasico();
    }

    public void agregarRespuestaCorrecta(Respuesta unaRespuesta) {
        unaRespuesta.establecerComoRespuestaAcertada();
        this.listaRespuestasCorrectas.add(unaRespuesta);
        this.cantidadCorrectas+=1;       
    }

    public void evaluarRespuesta(ArrayList<ListaRespuesta> listaRespuestasJugadores) {
        for (ListaRespuesta iterador: listaRespuestasJugadores) {
            if (iterador.puntuarRespuestas() == this.cantidadCorrectas) {
                iterador.puntuarJugador(1);
            }
        }
    }

    protected int cantidadRespuestasCorrectas() {
        return this.cantidadCorrectas;
    }

}
