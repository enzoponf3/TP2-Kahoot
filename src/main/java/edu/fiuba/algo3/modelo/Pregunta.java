package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public interface Pregunta {
    Respuesta elegirRespuesta(int idx); // para TEST
    Iterator<Respuesta> devolverRespuestasPosibles();
    void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores);
}
