package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class PreguntaMC implements Pregunta {
    protected ArrayList<Respuesta> respuestasPosibles;
    private final String enunciado;
    ExclusividadPuntaje exclusividad;

    public PreguntaMC(String enunciado){
        this.enunciado = enunciado;
        this.respuestasPosibles = new ArrayList<>();
        this.exclusividad = new ExlusividadNula();
    }

    public abstract void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores);

    public void agregarRespuestaCorrecta(Respuesta respuesta) {
        respuesta.establecerComoRespuestaAcertada();
        this.respuestasPosibles.add(respuesta);
    }

    public void agregarRespuesta(Respuesta respuesta) { this.respuestasPosibles.add(respuesta); }

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
