package edu.fiuba.algo3.eventos;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import edu.fiuba.algo3.vista.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonFinalizarTurnoMCHandler implements EventHandler<ActionEvent> {
    VistaPartida vistaPartida;
    RespuestasJugador respuestasJugador;
    public BotonFinalizarTurnoMCHandler(RespuestasJugador respuestasJugador, VistaPartida vistaPartida) {
        this.respuestasJugador=respuestasJugador;
        this.vistaPartida=vistaPartida;
    }
    @Override
    public void handle(ActionEvent event) {
        this.vistaPartida.agregarRespuestaAJugadorActual(this.respuestasJugador);
        this.vistaPartida.update();
    }
}

