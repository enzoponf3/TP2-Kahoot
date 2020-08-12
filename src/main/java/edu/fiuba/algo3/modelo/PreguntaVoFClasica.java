package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVoFClasica extends PreguntaVoF {
    ExclusividadPuntaje exclusividad;

    static public PreguntaVoFClasica crearPreguntaVerdadera() {
        PreguntaVoFClasica pregunta = new PreguntaVoFClasica();
        pregunta.setRespuestaVerdadera();
        pregunta.exclusividad = new ExlusividadNula();
        return pregunta;
    }

    static public PreguntaVoFClasica crearPreguntaFalsa() {
        PreguntaVoFClasica pregunta = new PreguntaVoFClasica();
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
}
