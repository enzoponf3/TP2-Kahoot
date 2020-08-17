package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

import java.util.ArrayList;

public class PreguntaVoFPenal extends PreguntaVoF{

    static public PreguntaVoFPenal crearPreguntaVerdadera(String nombre) {
        PreguntaVoFPenal pregunta = new PreguntaVoFPenal();
        pregunta.enunciadoPregunta = nombre;
        pregunta.setRespuestaVerdadera();
        return pregunta;
    }

    static public PreguntaVoFPenal crearPreguntaFalsa(String nombre) {
        PreguntaVoFPenal pregunta = new PreguntaVoFPenal();
        pregunta.enunciadoPregunta = nombre;
        pregunta.setRespuestaFalsa();
        return pregunta;
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            EvaluadorPenal evaluador = new EvaluadorPenal();
            iterador.evaluarRespuestasCon(evaluador);
            this.asignarPuntosDeEvaluadorA(evaluador,iterador.devolverJugador());
        }
    }

    @Override
    public JsonObject guardar() {
        return null;
    }

    private void asignarPuntosDeEvaluadorA(EvaluadorPenal evaluador, Jugador unJugador) {
        unJugador.puntuar(evaluador.puntaje());
    }
}


