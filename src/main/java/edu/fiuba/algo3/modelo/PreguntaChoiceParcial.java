package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class PreguntaChoiceParcial extends PreguntaMC{

    public PreguntaChoiceParcial(String enunciado){
        super(enunciado);
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        ArrayList<Evaluador> evaluadores = new ArrayList<>();
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            EvaluadorMCParcial evaluador= new EvaluadorMCParcial(iterador.devolverJugador());
            iterador.evaluarRespuestasCon(evaluador);
            evaluadores.add(evaluador);
        }
        exclusividad.agregarEvaluador(evaluadores.get(0),evaluadores.get(1));
        exclusividad.puntuarJugadores();
    }

    public JsonObject guardar() {
        JsonObject jsonPreguntaChoiceParcial = new JsonObject();
        jsonPreguntaChoiceParcial.addProperty("Tipo", "PreguntaChoiceParcial");
        jsonPreguntaChoiceParcial.addProperty("Pregunta", this.devolverEnunciado());
        JsonArray jsonRespuestas = new JsonArray();
        for(Respuesta r: this.respuestasPosibles) { jsonRespuestas.add(r.guardar()); }
        jsonPreguntaChoiceParcial.add("Respuestas", jsonRespuestas);
        return jsonPreguntaChoiceParcial;
    }

    public static PreguntaChoiceParcial recuperar(JsonObject jsonPreguntaChoiceParcial) {
        String enunciado = jsonPreguntaChoiceParcial.get("Pregunta").getAsString();
        PreguntaChoiceParcial pregunta = new PreguntaChoiceParcial(enunciado);
        JsonArray jsonRespuestas = jsonPreguntaChoiceParcial.getAsJsonArray("Respuestas");
        for(JsonElement jsonRespuesta: jsonRespuestas) {
            Respuesta respuesta = Respuesta.recuperar(jsonRespuesta.getAsJsonObject());
            pregunta.agregarRespuesta(respuesta);
        }
        return pregunta;
    }
}
