package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class PreguntaOrdererChoice {
    private List<Opcion> opcionesOrdenadas;

    public PreguntaOrdererChoice(List<Opcion> opcionesOrdenadas){
        this.opcionesOrdenadas = opcionesOrdenadas;
    }

    public void evaluarRespuestas(RespuestasJugador respuestas){
        if(respuestas.puntuarOrderer(opcionesOrdenadas)){
            respuestas.puntuarJugador(1);
        }

    }
}
