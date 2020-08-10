package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVoFClasica extends PreguntaVoF {

    static public PreguntaVoFClasica crearPreguntaVerdadera() {
        PreguntaVoFClasica pregunta = new PreguntaVoFClasica();
        pregunta.setRespuestaVerdadera();
        return pregunta;
    }

    static public PreguntaVoFClasica crearPreguntaFalsa() {
        PreguntaVoFClasica pregunta = new PreguntaVoFClasica();
        pregunta.setRespuestaFalsa();
        return pregunta;
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            iterador.evaluarRespuestasCon(new PuntuadorComun());
        }
    }


}
