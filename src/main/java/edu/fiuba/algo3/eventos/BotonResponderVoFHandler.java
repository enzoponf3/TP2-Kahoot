package edu.fiuba.algo3.eventos;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import edu.fiuba.algo3.vista.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonResponderVoFHandler implements EventHandler<ActionEvent> {
    Respuesta respuestaBoton;
    RespuestasJugador respuestasJugador;
    VistaPartida vistaPartida;
    public BotonResponderVoFHandler(RespuestasJugador respuestasJugador, Respuesta unaRespuesta, VistaPartida vistaPartida) {
        this.respuestasJugador=respuestasJugador;
        this.respuestaBoton=unaRespuesta;
        this.vistaPartida=vistaPartida;
    }
    @Override
    public void handle(ActionEvent event) {
        respuestasJugador.agregarRespuesta(this.respuestaBoton);
        this.vistaPartida.agregarRespuestaAJugadorActual(this.respuestasJugador);
        this.vistaPartida.update();
    }
}
