package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class PreguntaChoiceParcial extends PreguntaMC{

    public PreguntaChoiceParcial(int numeroDeOpciones,int cantidadCorrectasDeseadas){
        super(numeroDeOpciones,cantidadCorrectasDeseadas);
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
}
