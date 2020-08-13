package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;

public class Partida {
    private final LinkedList<Jugador> jugadores;
    private final Stack<PreguntaMC> preguntas;

    public Partida(ArrayList<PreguntaMC> preguntas) {
        this.jugadores = new LinkedList<Jugador>();
        this.preguntas = new Stack<PreguntaMC>();
        for (PreguntaMC p: preguntas) {
            this.preguntas.push(p);
        }
    }

    public boolean siguientePregunta() {
        if (this.preguntas.empty()) { return false; }
        this.preguntas.pop();
        return true;
    }

    public PreguntaMC preguntaActual() {
        return (PreguntaMC) this.preguntas.peek();
    }

    public ArrayList<Respuesta> respuestasActuales() { return this.preguntas.peek().obtenerRespuestas(); }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.offer(jugador);
    }

    public Jugador jugadorActual() {
        Jugador jugadorActual = this.jugadores.poll();
        this.jugadores.offer(jugadorActual);
        return jugadorActual;
    }
}
