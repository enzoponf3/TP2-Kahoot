package edu.fiuba.algo3.modelo;

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

    @Override
    public JsonObject guardar() {
        return null;
    }

}
