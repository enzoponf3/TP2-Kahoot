package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class EvaluadorOrdenada implements Evaluador {
    private RespuestasJugador respuestasJugador;
    private ArrayList<Respuesta> opcionesOrdenadas;
    private Puntaje puntaje ;

    public EvaluadorOrdenada(ArrayList<Respuesta> opcionesOrdenadas, RespuestasJugador respuestasJugador){
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
    public void sumarPuntosParciales() {
        if(opcionesOrdenadas.equals(respuestasJugador.devolverRespuestas())){
            puntaje.sumarPunto();
        }
    }

    @Override
    public Puntaje puntaje() {
        return this.puntaje;
    }

    @Override
    public Jugador jugador() {
        return this.respuestasJugador.devolverJugador();
    }
}
