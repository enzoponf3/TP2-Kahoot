package edu.fiuba.algo3.modelo;

public class TurnoSegundoJugador implements Turno{

    @Override
    public Turno cambiarTurno() {
        return (new TurnoPuntuar());
    }

    @Override
    public void jugar(PreguntaVoFClasica pregunta, RespuestasJugador respJugador) {
        respJugador.agregarRespuesta(pregunta.ElegirRespuestaFalsa());

    }

    @Override
    public void jugar2(PreguntaVoFClasica preguntaV, RespuestasJugador respuestasJugador1, RespuestasJugador respuestasJugador2) {

    }
}
