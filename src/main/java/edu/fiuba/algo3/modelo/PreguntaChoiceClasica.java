package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

import java.util.ArrayList;

public class PreguntaChoiceClasica extends PreguntaMC{

    public PreguntaChoiceClasica(int numeroDeOpciones,int cantidadCorrectasDeseadas){
        super(numeroDeOpciones,cantidadCorrectasDeseadas);
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

    @Override
    public JsonObject guardar() {
        return null;
    }

    public ArrayList<Respuesta> devolverRespuestasPosibles2() {
        return this.respuestaPosibles;
    }
}
