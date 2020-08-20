package edu.fiuba.algo3.eventos;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonResponderMCHandler implements EventHandler<ActionEvent> {
    Respuesta respuestaBoton;
    RespuestasJugador respuestasJugador;
    Button miBoton;
    public BotonResponderMCHandler(RespuestasJugador respuestasJugador, Respuesta unaRespuesta, Button unBoton) {
        this.respuestasJugador=respuestasJugador;
        this.respuestaBoton=unaRespuesta;
        this.miBoton=unBoton;
    }
    @Override
    public void handle(ActionEvent event) {
        this.respuestasJugador.agregarRespuesta(this.respuestaBoton);
        this.miBoton.setDisable(true);
    }

    public void modificarGrupo(RespuestasJugador respuestasDeUnGrupo) {
        this.respuestasJugador=respuestasDeUnGrupo;
    }
}
