package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class EvaluadorGrupo implements Evaluador {

    private final ArrayList<Respuesta> respuestasGrupoA;
    private final ArrayList<Respuesta> respuestasGrupoB;
    private RespuestasJugadorAgrupable respuestasJugador;
    private Puntaje puntaje;

    public EvaluadorGrupo(ArrayList<Respuesta> respuestasGrupoA, ArrayList<Respuesta> respuestasGrupoB, RespuestasJugadorAgrupable respuestasJugador){
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
    public void sumarPuntosParciales() {
        if (respuestasGrupoA.equals(respuestasJugador.devolverRespuestasGrupoA()) && respuestasGrupoB.equals(respuestasJugador.devolverRespuestasGrupoB())){
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
