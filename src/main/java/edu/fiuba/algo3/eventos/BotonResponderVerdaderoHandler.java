package edu.fiuba.algo3.eventos;

import edu.fiuba.algo3.modelo.PreguntaVoF;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonResponderVerdaderoHandler implements EventHandler<ActionEvent> {
    PreguntaVoF pregunta;
    RespuestasJugador respuestasJugador;
    public BotonResponderVerdaderoHandler(RespuestasJugador respuestasJugador1, PreguntaVoF unaPregunta) {
        this.respuestasJugador=respuestasJugador1;
        this.pregunta=unaPregunta;
    }

    @Override
    public void handle(ActionEvent event) {
        respuestasJugador.agregarRespuesta(pregunta.ElegirRespuestaVerdadera());
    }
}
