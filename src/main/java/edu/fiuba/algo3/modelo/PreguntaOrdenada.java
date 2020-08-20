package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collections;

public class PreguntaOrdenada implements Pregunta{
    private final ArrayList<Respuesta> opcionesOrdenadas;
    private ExclusividadPuntaje exclusividad;
    private final String enunciado;

    public PreguntaOrdenada(String enunciado){
        this.opcionesOrdenadas = new ArrayList<>();
        this.enunciado = enunciado;
        this.exclusividad = new ExlusividadNula();
    }

    public void agregarRespuesta(Respuesta respuesta) { opcionesOrdenadas.add(respuesta); }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        ArrayList<Evaluador> evaluadores = new ArrayList<>();
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            EvaluadorOrdenada evaluador= new EvaluadorOrdenada(this.opcionesOrdenadas,iterador);
            evaluador.sumarPuntosParciales();
            evaluadores.add(evaluador);
        }
        exclusividad.agregarEvaluador(evaluadores.get(0),evaluadores.get(1));
        exclusividad.puntuarJugadores();
    }

    @Override
    public String devolverEnunciado() {
        return this.enunciado;
    }

    @Override
    public ArrayList<Respuesta> devolverRespuestasPosibles() {
        ArrayList<Respuesta> respuestasADevolver = new ArrayList<>(this.opcionesOrdenadas);
        Collections.shuffle(respuestasADevolver);
        return respuestasADevolver;
    }

    public void usarExclusividad() {
        this.exclusividad = this.exclusividad.cambiarExclusividad();
    }

    @Override
    public JsonObject guardar() {
        JsonObject jsonPreguntaOrdenada = new JsonObject();
        jsonPreguntaOrdenada.addProperty("Tipo", "PreguntaOrdenada");
        jsonPreguntaOrdenada.addProperty("Pregunta", this.enunciado);
        JsonArray jsonRespuestas = new JsonArray();
        for(Respuesta r: this.opcionesOrdenadas) { jsonRespuestas.add(r.guardar()); }
        jsonPreguntaOrdenada.add("Respuestas Ordenadas", jsonRespuestas);
        return jsonPreguntaOrdenada;
    }

    public static PreguntaOrdenada recuperar(JsonObject jsonPreguntaOrdenada) {
        String enunciado = jsonPreguntaOrdenada.get("Pregunta").getAsString();
        PreguntaOrdenada pregunta = new PreguntaOrdenada(enunciado);
        JsonArray jsonRespuestas = jsonPreguntaOrdenada.getAsJsonArray("Respuestas Ordenadas");
        for(JsonElement jsonRespuesta: jsonRespuestas) {
            Respuesta respuesta = Respuesta.recuperar(jsonRespuesta.getAsJsonObject());
            pregunta.agregarRespuesta(respuesta);
        }
        return pregunta;
    }
}
