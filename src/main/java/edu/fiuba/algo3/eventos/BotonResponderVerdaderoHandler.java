package edu.fiuba.algo3.eventos;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import edu.fiuba.algo3.vista.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Iterator;

public class BotonResponderVerdaderoHandler implements EventHandler<ActionEvent> {
    VistaPartida vistaPartida;
    RespuestasJugador respuestasJugador;
    public BotonResponderVerdaderoHandler(RespuestasJugador respuestasJugador, VistaPartida vistaPartida) {
        this.respuestasJugador=respuestasJugador;
        this.vistaPartida=vistaPartida;
    }

    @Override
    public void handle(ActionEvent event) {
        Iterator<Respuesta> iterator = vistaPartida.partida().preguntaActual().devolverRespuestasPosibles();
        respuestasJugador.agregarRespuesta(iterator.next());
        this.vistaPartida.agregarRespuestaAJugadorActual(this.respuestasJugador);
        this.vistaPartida.update();
    }
}
