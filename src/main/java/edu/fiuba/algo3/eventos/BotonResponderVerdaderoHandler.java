package edu.fiuba.algo3.eventos;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.PreguntaVoF;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import edu.fiuba.algo3.vista.imagenes.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonResponderVerdaderoHandler implements EventHandler<ActionEvent> {
    VistaPartida vistaPartida;
    RespuestasJugador respuestasJugador;
    public BotonResponderVerdaderoHandler(RespuestasJugador respuestasJugador, VistaPartida vistaPartida) {
        this.respuestasJugador=respuestasJugador;
        this.vistaPartida=vistaPartida;
    }

    @Override
    public void handle(ActionEvent event) {
        respuestasJugador.agregarRespuesta(vistaPartida.partida().preguntaActual().ElegirRespuestaVerdadera());
        this.vistaPartida.update();
    }
}
