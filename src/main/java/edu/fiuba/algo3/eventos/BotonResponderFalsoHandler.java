package edu.fiuba.algo3.eventos;

import edu.fiuba.algo3.modelo.PreguntaVoF;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import edu.fiuba.algo3.vista.imagenes.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonResponderFalsoHandler implements EventHandler<ActionEvent> {
    VistaPartida vistaPartida;
    RespuestasJugador respuestasJugador;
    public BotonResponderFalsoHandler(RespuestasJugador respuestasJugador, VistaPartida vistaPartida) {
        this.respuestasJugador=respuestasJugador;
        this.vistaPartida=vistaPartida;
    }

    @Override
    public void handle(ActionEvent event) {
        respuestasJugador.agregarRespuesta(vistaPartida.partida().preguntaActual().ElegirRespuestaFalsa());
        this.vistaPartida.update();
    }
}
