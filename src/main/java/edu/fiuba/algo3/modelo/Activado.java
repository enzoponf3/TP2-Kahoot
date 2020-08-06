package edu.fiuba.algo3.modelo;

public class Activado implements Identificable {
    public void identificar(Evaluable respuesta) { respuesta.establecerComoRespuestaAcertada(); }
}
