package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class TurnoPuntuar implements Turno {

    @Override
    public Turno cambiarTurno() {
        return (new TurnoPrimerJugador());
    }

    @Override
    public void jugar(PreguntaVoFClasica pregunta, RespuestasJugador respJugador) {
    }

    @Override
    public void jugar2(PreguntaVoFClasica preguntaV, RespuestasJugador respuestasJugador1, RespuestasJugador respuestasJugador2) {
        ArrayList<RespuestasJugador> respuestasJugadores= new <RespuestasJugador>ArrayList();

        respuestasJugadores.add( respuestasJugador1);
        respuestasJugadores.add( respuestasJugador2);
        preguntaV.evaluarRespuestas(respuestasJugadores);
    }
}
