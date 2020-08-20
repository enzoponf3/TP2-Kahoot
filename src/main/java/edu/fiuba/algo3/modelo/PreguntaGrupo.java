package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Iterator;

public class PreguntaGrupo implements Pregunta{
    private final ArrayList<Respuesta> respuestasGrupoA;
    private final ArrayList<Respuesta> respuestasGrupoB;
    private final ArrayList<Respuesta> respuestasElegibles;
    private ExclusividadPuntaje exclusividad;
    private final String enunciado;
    private final String enunciadoGrupoA;
    private final String enunciadoGrupoB;

    public PreguntaGrupo(String enunciado_pregunta_grupo, String en_grupo_a, String en_grupo_b){
        this.respuestasGrupoA = new ArrayList<>();
        this.respuestasGrupoB = new ArrayList<>();
        this.respuestasElegibles = new ArrayList<>();
        this.exclusividad= new ExlusividadNula();
        this.enunciado=enunciado_pregunta_grupo;
        this.enunciadoGrupoA=en_grupo_a;
        this.enunciadoGrupoB=en_grupo_b;
    }

    public void agregarRespuestaGrupoA(Respuesta unaRespuesta){
        this.respuestasGrupoA.add(unaRespuesta);
        this.respuestasElegibles.add(unaRespuesta);
    }

    public void agregarRespuestaGrupoB(Respuesta unaRespuesta){
        this.respuestasGrupoB.add(unaRespuesta);
        this.respuestasElegibles.add(unaRespuesta);
    }

    public Respuesta elegirRespuesta(int idx){
        return respuestasElegibles.get(idx);
    }

    @Override
    public ArrayList<Respuesta> devolverRespuestasPosibles() {
        return this.respuestasElegibles;
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        ArrayList<Evaluador> evaluadores = new ArrayList<>();
        Iterator<RespuestasJugador> iterator = respuestasVariosJugadores.iterator();
        while (iterator.hasNext()){
            EvaluadorGrupo evaluador= new EvaluadorGrupo(respuestasGrupoA,respuestasGrupoB,iterator);
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

    public String devolverEnunciadoGrupoA(){
        return this.enunciadoGrupoA;
    }

    public String devolverEnunciadoGrupoB(){
        return this.enunciadoGrupoB;
    }

    public void usarExclusividad() {
        this.exclusividad=this.exclusividad.cambiarExclusividad();
    }

    @Override
    public JsonObject guardar() {
        JsonObject jsonPreguntaGrupo = new JsonObject();
        jsonPreguntaGrupo.addProperty("Tipo", "PreguntaGrupo");
        jsonPreguntaGrupo.addProperty("Pregunta", this.enunciado);
        jsonPreguntaGrupo.addProperty("Enunciado Grupo A", this.enunciadoGrupoA);
        jsonPreguntaGrupo.addProperty("Enunciado Grupo B", this.enunciadoGrupoB);
        JsonArray jsonRespuestasGrupoA = new JsonArray();
        JsonArray jsonRespuestasGrupoB = new JsonArray();

        for(Respuesta r: this.respuestasGrupoA) { jsonRespuestasGrupoA.add(r.guardar()); }
        jsonPreguntaGrupo.add("Respuestas grupo A", jsonRespuestasGrupoA);
        for(Respuesta r: this.respuestasGrupoB) { jsonRespuestasGrupoB.add(r.guardar()); }
        jsonPreguntaGrupo.add("Respuestas grupo A", jsonRespuestasGrupoB);

        return jsonPreguntaGrupo;
    }

    public static PreguntaGrupo recuperar(JsonObject jsonPreguntaGrupo) {
        String enunciado = jsonPreguntaGrupo.get("Pregunta").getAsString();
        String enunciadoGrupoA = jsonPreguntaGrupo.get("Enunciado Grupo A").getAsString();
        String enunciadoGrupoB = jsonPreguntaGrupo.get("Enunciado Grupo B").getAsString();
        PreguntaGrupo pregunta = new PreguntaGrupo(enunciado,enunciadoGrupoA,enunciadoGrupoB);
        JsonArray jsonRespuestasGrupoA = jsonPreguntaGrupo.getAsJsonArray("Respuestas grupo A");
        JsonArray jsonRespuestasGrupoB = jsonPreguntaGrupo.getAsJsonArray("Respuestas grupo B");
        for(JsonElement jsonRespuesta: jsonRespuestasGrupoA) {
            Respuesta respuesta = Respuesta.recuperar(jsonRespuesta.getAsJsonObject());
            pregunta.agregarRespuestaGrupoA(respuesta);
        }
        for(JsonElement jsonRespuesta: jsonRespuestasGrupoB) {
            Respuesta respuesta = Respuesta.recuperar(jsonRespuesta.getAsJsonObject());
            pregunta.agregarRespuestaGrupoB(respuesta);
        }

        return pregunta;
    }

}
