package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class RespuestasJugadorAgrupable {
    private ArrayList<Respuesta> respuestasGrupoA;
    private ArrayList<Respuesta> respuestasGrupoB;
    private Jugador jugador;

    public RespuestasJugadorAgrupable(Jugador unJugador) {
        this.jugador = unJugador;
        this.respuestasGrupoA = new ArrayList<Respuesta>();
        this.respuestasGrupoB = new ArrayList<Respuesta>();
    }

    public void evaluarRespuestasCon(Puntuador puntuador) {
        puntuador.puntuar(this.jugador);
    }

    public ArrayList<Respuesta> devolverRespuestasGrupoA() {
        return this.respuestasGrupoA;
    }
    public ArrayList<Respuesta> devolverRespuestasGrupoB() {
        return this.respuestasGrupoB;
    }

    public void agregarRespuestaAContenedorA(Respuesta unaRespuesta) {
        respuestasGrupoA.add(unaRespuesta);
    }

    public void agregarRespuestaAContenedorB(Respuesta unaRespuesta) {
        respuestasGrupoB.add(unaRespuesta);
    }
}
