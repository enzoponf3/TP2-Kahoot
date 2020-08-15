package edu.fiuba.algo3.modelo;

public class TurnoPrimerJugador implements Turno{

    @Override
    public Turno cambiarTurno() {
        return (new TurnoSegundoJugador());
    }

    @Override
    public void jugar(PreguntaVoFClasica pregunta, RespuestasJugador respJugador) {
        respJugador.agregarRespuesta(pregunta.ElegirRespuestaVerdadera());
    }

    @Override
    public void jugar2(PreguntaVoFClasica preguntaV, RespuestasJugador respuestasJugador1, RespuestasJugador respuestasJugador2) {

    }
}