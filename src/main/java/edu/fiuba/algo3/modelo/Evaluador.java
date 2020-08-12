package edu.fiuba.algo3.modelo;

public interface Evaluador {
    void acierto();
    void fallido();
    void sumarPuntosParciales();
    Puntaje puntaje();
    Jugador jugador();
}
