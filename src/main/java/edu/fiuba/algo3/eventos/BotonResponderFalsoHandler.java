package edu.fiuba.algo3.eventos;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import edu.fiuba.algo3.vista.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Iterator;

public class BotonResponderFalsoHandler implements EventHandler<ActionEvent> {
    VistaPartida vistaPartida;
    RespuestasJugador respuestasJugador;
    public BotonResponderFalsoHandler(RespuestasJugador respuestasJugador, VistaPartida vistaPartida) {
        this.respuestasJugador=respuestasJugador;
        this.vistaPartida=vistaPartida;
    }

    @Override
    public void handle(ActionEvent event) {
        Iterator<Respuesta> iterator = vistaPartida.partida().preguntaActual().devolverRespuestasPosibles();
        iterator.next();
        respuestasJugador.agregarRespuesta(iterator.next());
        this.vistaPartida.agregarRespuestaAJugadorActual(this.respuestasJugador);
        this.vistaPartida.update();
    }
}
