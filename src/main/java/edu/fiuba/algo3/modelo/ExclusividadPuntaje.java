package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface ExclusividadPuntaje {
    void puntuarJugadores(ArrayList<Jugador> jugadores, ArrayList<Puntaje> puntajesParciales);

    ExclusividadPuntaje cambiarExclusividad();
}
