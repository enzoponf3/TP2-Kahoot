package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class SinExlusividad implements ExclusividadPuntaje {
    @Override
    public void puntuarJugadores(ArrayList<Jugador> jugadores, ArrayList<Puntaje> puntajesParciales) {
        jugadores.get(0).puntuar(puntajesParciales.get(0));
        jugadores.get(1).puntuar(puntajesParciales.get(1));
    }

    public ExclusividadPuntaje cambiarExclusividad(){
        return (new ExclusividadUnJugador());
    }

}
