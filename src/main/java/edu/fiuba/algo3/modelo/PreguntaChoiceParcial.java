package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaChoiceParcial {
    private ArrayList<Respuesta> listaRespuestasCorrectas;
    private int cantidadCorrectas = 0;
    private int cantidadOpciones = 0;

    public PreguntaChoiceParcial(int numeroDeOpciones) {
        this.listaRespuestasCorrectas= new ArrayList<Respuesta>();
        this.cantidadOpciones = numeroDeOpciones;
    }

    public void agregarRespuestaCorrecta(Respuesta unaRespuesta) {
        unaRespuesta.establecerComoRespuestaAcertada();
        this.listaRespuestasCorrectas.add(unaRespuesta);
        this.cantidadCorrectas+=1;
    }

    public void evaluarRespuesta(ArrayList<ListaRespuesta> listaRespuestasJugadores) {
        for (ListaRespuesta iterador: listaRespuestasJugadores) {
                iterador.puntuarJugador(iterador.puntuarRespuestas());
        }
    }

    protected int cantidadRespuestasCorrectas() {
        return this.cantidadCorrectas;
    }
}
