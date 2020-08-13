package edu.fiuba.algo3.modelo;

public interface Turno {
    Turno cambiarTurno();
    void jugar(PreguntaVoFClasica pregunta, RespuestasJugador respJugador);

    void jugar2(PreguntaVoFClasica preguntaV, RespuestasJugador respuestasJugador1, RespuestasJugador respuestasJugador2);
}
