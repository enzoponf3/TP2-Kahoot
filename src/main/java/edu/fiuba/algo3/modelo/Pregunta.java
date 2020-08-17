package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Iterator;

public interface Pregunta {

    //static Pregunta recuperar(JsonObject asJsonObject);
    Respuesta elegirRespuesta(int idx); // para TEST
    Iterator<Respuesta> devolverRespuestasPosibles();
    void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores);
    public JsonObject guardar();
    String devolverEnunciado();
}
