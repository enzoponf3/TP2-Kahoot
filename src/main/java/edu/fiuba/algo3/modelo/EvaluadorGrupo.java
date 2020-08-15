package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class EvaluadorGrupo implements Evaluador {

    private ArrayList<Respuesta> respuestasGrupoA;
    private ArrayList<Respuesta> respuestasGrupoB;
    private Iterator<RespuestasJugador> iteradorRespuestasJugador;
    private Puntaje puntaje;
    private Jugador jugador;

    public EvaluadorGrupo(ArrayList<Respuesta> respuestasGrupoA, ArrayList<Respuesta> respuestasGrupoB, Iterator<RespuestasJugador> iterador){
        puntaje = new Puntaje();
        this.respuestasGrupoA = respuestasGrupoA;
        this.respuestasGrupoB=respuestasGrupoB;
        this.iteradorRespuestasJugador = iterador;
    }

    @Override
    public void acierto() {
    }

    @Override
    public void fallido() {
    }

    @Override
    public void sumarPuntosParciales() {
        RespuestasJugador respJugador=this.iteradorRespuestasJugador.next();
        this.jugador=respJugador.devolverJugador();
        if (respuestasGrupoA.equals(respJugador.devolverRespuestas())){
            if (respuestasGrupoB.equals(iteradorRespuestasJugador.next().devolverRespuestas())){
                this.puntaje.sumarPunto();
            }
        }
    }

    @Override
    public Puntaje puntaje() {
        return this.puntaje;
    }

    @Override
    public Jugador jugador() {
        return this.jugador;
    }
}
