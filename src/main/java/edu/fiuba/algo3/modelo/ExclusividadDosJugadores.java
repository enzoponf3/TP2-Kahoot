package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ExclusividadDosJugadores implements ExclusividadPuntaje {
    public void puntuarJugadores(ArrayList<Jugador> jugadores, ArrayList<Puntaje> puntajesParciales) {
        if (puntajesParciales.get(0).esMenor(puntajesParciales.get(1))){
            puntajesParciales.get(1).duplicar();
            puntajesParciales.get(1).duplicar();
            jugadores.get(1).puntuar(puntajesParciales.get(1));
        }
        else if (puntajesParciales.get(1).esMenor(puntajesParciales.get(0))) {
            puntajesParciales.get(0).duplicar();
            puntajesParciales.get(0).duplicar();
            jugadores.get(0).puntuar(puntajesParciales.get(0));
        }
    }
    public ExclusividadPuntaje cambiarExclusividad(){
            return (new SinExlusividad());
    }

}
