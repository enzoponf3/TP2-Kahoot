package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class PreguntaChoicePenal extends PreguntaMC{

    public PreguntaChoicePenal(String enunciado){
        super(enunciado);
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            EvaluadorPenal evaluador = new EvaluadorPenal();
            iterador.evaluarRespuestasCon(evaluador);
            this.asignarPuntosDeEvaluadorA(evaluador,iterador.devolverJugador());
        }
    }

    private void asignarPuntosDeEvaluadorA(EvaluadorPenal evaluador, Jugador unJugador) {
        unJugador.puntuar(evaluador.puntaje());
    }

    public JsonObject guardar() {
        JsonObject jsonPreguntaChoicePenal = new JsonObject();
        JsonArray jsonArrayRespuesta = new JsonArray();
        for(Respuesta r: this.respuestasPosibles) { jsonArrayRespuesta.add(r.guardar()); }
        jsonPreguntaChoicePenal.addProperty("Tipo", "PreguntaChoicePenal");
        jsonPreguntaChoicePenal.addProperty("Pregunta", this.devolverEnunciado());
        jsonPreguntaChoicePenal.add("Respuestas", jsonArrayRespuesta);
        return jsonPreguntaChoicePenal;
    }

    public static PreguntaChoicePenal recuperar(JsonObject jsonPreguntaChoisePenal) {
        String enunciado = jsonPreguntaChoisePenal.get("Pregunta").getAsString();
        JsonArray jsonRespuestas = jsonPreguntaChoisePenal.getAsJsonArray("Respuestas");
        PreguntaChoicePenal pregunta = new PreguntaChoicePenal(enunciado);
        for(JsonElement jsonRespuesta: jsonRespuestas) {
            Respuesta respuesta = Respuesta.recuperar(jsonRespuesta.getAsJsonObject());
            pregunta.agregarRespuesta(respuesta);
        }
        return pregunta;
    }
}
