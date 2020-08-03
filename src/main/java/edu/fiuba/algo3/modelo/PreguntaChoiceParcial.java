package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaChoiceParcial {

    public void evaluarRespuestas(ArrayList<RespuestasJugador> listaRespuestasJugadores) {
        for (RespuestasJugador iterador: listaRespuestasJugadores) {
            iterador.evaluarRespuestasCon(new PuntuadorParcial());
        }
    }
}
