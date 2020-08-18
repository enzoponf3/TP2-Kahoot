package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

import java.util.ArrayList;

public interface Pregunta {

    //static Pregunta recuperar(JsonObject asJsonObject);
    ArrayList<Respuesta> devolverRespuestasPosibles();
    void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores);
    JsonObject guardar();
    String devolverEnunciado();
}
