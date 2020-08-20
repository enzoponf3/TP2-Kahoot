package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class PreguntaChoiceClasica extends PreguntaMC{
    private int cantidadCorrectas;

    public PreguntaChoiceClasica(String enunciado){
        super(enunciado);
        this.cantidadCorrectas = 0;
    }

    public void agregarRespuestaCorrecta(Respuesta respuesta) {
        respuesta.establecerComoRespuestaAcertada();
        this.respuestasPosibles.add(respuesta);
        this.cantidadCorrectas++;
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        ArrayList<Evaluador> evaluadores = new ArrayList<>();
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            EvaluadorMCClasica evaluador= new EvaluadorMCClasica(cantidadCorrectas,iterador.devolverJugador());
            iterador.evaluarRespuestasCon(evaluador);
            evaluadores.add(evaluador);
        }
        exclusividad.agregarEvaluador(evaluadores.get(0),evaluadores.get(1));
        exclusividad.puntuarJugadores();
    }

    private void establecerCantidadCorrectas(int cantidadCorrectas) { this.cantidadCorrectas = cantidadCorrectas; }

    public JsonObject guardar() {
        JsonObject jsonPreguntaChoiceClasica = new JsonObject();
        jsonPreguntaChoiceClasica.addProperty("Tipo", "PreguntaChoiceClasica");
        jsonPreguntaChoiceClasica.addProperty("Pregunta", this.devolverEnunciado());
        jsonPreguntaChoiceClasica.addProperty("Correctas", this.cantidadCorrectas);
        JsonArray jsonRespuestas = new JsonArray();
        for(Respuesta r: this.respuestasPosibles) { jsonRespuestas.add(r.guardar()); }
        jsonPreguntaChoiceClasica.add("Respuestas", jsonRespuestas);
        return jsonPreguntaChoiceClasica;
    }

    public static PreguntaChoiceClasica recuperar(JsonObject jsonPreguntaChoiceClasica) {
        String enunciado = jsonPreguntaChoiceClasica.get("Pregunta").getAsString();
        PreguntaChoiceClasica pregunta = new PreguntaChoiceClasica(enunciado);
        int cantidadCorrectas = jsonPreguntaChoiceClasica.get("Correctas").getAsInt();
        pregunta.establecerCantidadCorrectas(cantidadCorrectas);
        JsonArray jsonRespuestas = jsonPreguntaChoiceClasica.getAsJsonArray("Respuestas");
        for(JsonElement jsonRespuesta: jsonRespuestas) {
            Respuesta respuesta = Respuesta.recuperar(jsonRespuesta.getAsJsonObject());
            pregunta.agregarRespuesta(respuesta);
        }
        return pregunta;
    }
}
