package edu.fiuba.algo3.modelo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonResponderMCHandler implements EventHandler<ActionEvent> {
    Respuesta respuestaBoton;
    RespuestasJugador respuestasJugador;
    public BotonResponderMCHandler(RespuestasJugador respuestasJugador,Respuesta unaRespuesta) {
        this.respuestasJugador=respuestasJugador;
        this.respuestaBoton=unaRespuesta;
    }
    @Override
    public void handle(ActionEvent event) {
        respuestasJugador.agregarRespuesta(this.respuestaBoton);
    }
}
