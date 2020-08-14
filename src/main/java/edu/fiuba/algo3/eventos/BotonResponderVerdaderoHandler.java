package edu.fiuba.algo3.eventos;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.PreguntaVoF;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonResponderVerdaderoHandler implements EventHandler<ActionEvent> {
    Partida partida;
    RespuestasJugador respuestasJugador;
    public BotonResponderVerdaderoHandler(RespuestasJugador respuestasJugador, Partida unaPartida) {
        this.respuestasJugador=respuestasJugador;
        this.partida=unaPartida;
    }

    @Override
    public void handle(ActionEvent event) {
        respuestasJugador.agregarRespuesta(partida.preguntaActual().ElegirRespuestaVerdadera());
        partida.
    }
}
