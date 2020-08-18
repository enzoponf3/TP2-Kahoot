package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class PreguntaMC implements Pregunta {
    protected ArrayList<Respuesta> respuestasPosibles;
    protected int cantidadCorrectas;
    protected int cantidadOpciones;
    private final String enunciado;
    ExclusividadPuntaje exclusividad;

    public PreguntaMC(String enunciado){
        this.enunciado = enunciado;
        this.cantidadCorrectas= 0;
        this.cantidadOpciones = 0;
        this.respuestasPosibles = new ArrayList<>();
        this.exclusividad = new ExlusividadNula();
    }

    public abstract void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores);

    public void agregarRespuestaCorrecta(Respuesta respuesta) {
        respuesta.establecerComoRespuestaAcertada();
        this.respuestasPosibles.add(respuesta);
        this.cantidadCorrectas++;
        this.cantidadOpciones++;
    }

    public void agregarRespuesta(Respuesta respuesta) {
        this.respuestasPosibles.add(respuesta);
        this.cantidadOpciones++;
    }

    public void usarExclusividad() {
        this.exclusividad=this.exclusividad.cambiarExclusividad();
    }

    @Override
    public ArrayList<Respuesta> devolverRespuestasPosibles() {
        return this.respuestasPosibles;
    }

    public String devolverEnunciado(){
        return this.enunciado;
    }
}
