package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

import java.util.ArrayList;

public class PreguntaVoFClasica extends PreguntaVoF {
    private ExclusividadPuntaje exclusividad;

    static public PreguntaVoFClasica crearPreguntaVerdadera(String nombre) {
        PreguntaVoFClasica pregunta = new PreguntaVoFClasica();
        pregunta.enunciadoPregunta= nombre;
        pregunta.setRespuestaVerdadera();
        pregunta.exclusividad = new ExlusividadNula();
        return pregunta;
    }

    static public PreguntaVoFClasica crearPreguntaFalsa(String nombre) {
        PreguntaVoFClasica pregunta = new PreguntaVoFClasica();
        pregunta.enunciadoPregunta= nombre;
        pregunta.setRespuestaFalsa();
        pregunta.exclusividad = new ExlusividadNula();
        return pregunta;
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        ArrayList<Evaluador> evaluadores = new ArrayList<>();
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            EvaluadorComun evaluador= new EvaluadorComun(iterador.devolverJugador());
            iterador.evaluarRespuestasCon(evaluador);
            evaluadores.add(evaluador);
        }
        exclusividad.agregarEvaluador(evaluadores.get(0),evaluadores.get(1));
        exclusividad.puntuarJugadores();
    }

    public void usarExclusividad() {
        this.exclusividad=this.exclusividad.cambiarExclusividad();
    }

    public JsonObject guardar() {
        JsonObject jsonPregunta = new JsonObject();
        jsonPregunta.addProperty("enunciado", this.enunciadoPregunta);
        return jsonPregunta;
    }

}
