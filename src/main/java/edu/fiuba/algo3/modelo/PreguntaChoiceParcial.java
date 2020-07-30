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

    public void evaluarRespuesta(ArrayList<ListaRespuesta> listaRespuestasJugadores) {
        for (ListaRespuesta iterador: listaRespuestasJugadores) {
                iterador.puntuarJugador(iterador.puntuarRespuestas());
        }
    }

    // Refactor con Evaluador

    public void evaluarRespuestaConEvaluador(ArrayList<ListaRespuesta> listaRespuestasJugadores) {
        for (ListaRespuesta iterador: listaRespuestasJugadores) {
            iterador.puntuarJugadorCon(this.evaluador);
        }
    }

    protected int cantidadRespuestasCorrectas() {
        return this.cantidadCorrectas;
    }

    public void agregarRespuestaCorrecta() {
        Respuesta res = new Respuesta();
        res.establecerComoRespuestaAcertada();
        this.listaRespuestasCorrectas.add(res);
        this.cantidadCorrectas+=1;
    }

    public void agregarRespuestaIncorrecta() {
        this.listaRespuestasCorrectas.add(new Respuesta());
    }

    protected void puntuarJugadores(ArrayList<ListaRespuesta> respuestasDeJugadores) {
        for(ListaRespuesta respuestasJugador: respuestasDeJugadores){
            respuestasJugador.puntuarJugador(evaluador,cantidadCorrectas,listaRespuestasCorrectas);
        }
    }


}
