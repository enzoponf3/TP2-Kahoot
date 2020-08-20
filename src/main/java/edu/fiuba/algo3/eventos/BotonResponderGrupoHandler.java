package edu.fiuba.algo3.eventos;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import edu.fiuba.algo3.vista.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonResponderGrupoHandler implements EventHandler<ActionEvent> {
    RespuestasJugador respuestasJugadorGrupoA;
    RespuestasJugador respuestasJugadorGrupoB;
    Respuesta respuestaBoton;
    Boolean grupoAElegido;
    public BotonResponderGrupoHandler(RespuestasJugador grupoA, RespuestasJugador grupoB, Respuesta respuesta) {
        this.respuestasJugadorGrupoA=grupoA;
        this.respuestasJugadorGrupoB=grupoB;
        this.respuestaBoton=respuesta;
        this.grupoAElegido=true;

    }
    @Override
    public void handle(ActionEvent event) {
        if(grupoAElegido){
            respuestasJugadorGrupoA.agregarRespuesta(respuestaBoton);
        }
        else {
            respuestasJugadorGrupoB.agregarRespuesta(respuestaBoton);
        }
    }

    public void cambiarGrupos(){

    }
}
