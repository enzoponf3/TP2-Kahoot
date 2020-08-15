package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

import java.util.ArrayList;

public class PreguntaChoicePenal extends PreguntaMC{

    public PreguntaChoicePenal(int numeroDeOpciones,int cantidadCorrectasDeseadas){
        super(numeroDeOpciones,cantidadCorrectasDeseadas);
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
