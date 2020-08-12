package edu.fiuba.algo3.modelo;

public interface ExclusividadPuntaje {

    void puntuarJugadores();

    ExclusividadPuntaje cambiarExclusividad();

    void agregarEvaluador(Evaluador unEvaluador, Evaluador otroEvaluador);
}
