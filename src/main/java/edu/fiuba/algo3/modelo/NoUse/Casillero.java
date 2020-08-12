package edu.fiuba.algo3.modelo.NoUse;

import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class Casillero {
    private ArrayList<Respuesta> grupoRespuestas;

    public Casillero (){
        grupoRespuestas = new ArrayList<>();
    }

    public void agregarRespuestaCorrecta(Respuesta unaRespuesta){
        grupoRespuestas.add(unaRespuesta);
    }

    public void introducirRespuesta(Respuesta respuesta) {
        if (grupoRespuestas.contains(respuesta)){
            respuesta.establecerComoRespuestaAcertada();
        }
    }
}
