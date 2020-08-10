package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PuntuadorOrdenada implements Puntuador {
    private RespuestasJugador respuestasJugador;
    private ArrayList<Respuesta> opcionesOrdenadas;
    private Puntaje puntaje ;

    public PuntuadorOrdenada(ArrayList<Respuesta> opcionesOrdenadas, RespuestasJugador respuestasJugador){
        puntaje = new Puntaje();
        this.opcionesOrdenadas = opcionesOrdenadas;
        this.respuestasJugador = respuestasJugador;
    }

    @Override
    public void acierto() {

    }

    @Override
    public void fallido() {

    }

    @Override
    public void puntuar(Jugador jugador) {
        if(opcionesOrdenadas.equals(respuestasJugador.devolverRespuestas())){
            puntaje.sumarPunto();
        }
        jugador.puntuar(puntaje);
    }
}
