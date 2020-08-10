package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PuntuadorGrupo implements Puntuador {

    private final ArrayList<Respuesta> respuestasGrupoA;
    private final ArrayList<Respuesta> respuestasGrupoB;
    private RespuestasJugadorAgrupable respuestasJugador;
    private Puntaje puntaje ;

    public PuntuadorGrupo(ArrayList<Respuesta> respuestasGrupoA,ArrayList<Respuesta> respuestasGrupoB, RespuestasJugadorAgrupable respuestasJugador){
        puntaje = new Puntaje();
        this.respuestasGrupoA = respuestasGrupoA;
        this.respuestasGrupoB = respuestasGrupoB;
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
        if (respuestasGrupoA.equals(respuestasJugador.devolverRespuestasGrupoA()) && respuestasGrupoB.equals(respuestasJugador.devolverRespuestasGrupoB())){
            puntaje.sumarPunto();
        }
        jugador.puntuar(puntaje);
    }
}
