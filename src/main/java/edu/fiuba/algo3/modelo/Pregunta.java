package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface Pregunta {
    Respuesta elegirRespuesta(int idx); // para TEST
    void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores);
}
