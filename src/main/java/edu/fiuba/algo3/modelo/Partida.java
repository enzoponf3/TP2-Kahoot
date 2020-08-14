package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;

public class Partida {
    private final LinkedList<Jugador> jugadores;
    private final Stack<PreguntaVoFClasica> preguntas;

    public Partida(ArrayList<PreguntaVoFClasica> preguntas) {
        this.jugadores = new LinkedList<Jugador>();
        this.preguntas = new Stack<PreguntaVoFClasica>();
        for (PreguntaVoFClasica p: preguntas) {
            this.preguntas.push(p);
        }
    }

    public boolean siguientePregunta() {
        if (this.preguntas.empty()) { return false; }
        this.preguntas.pop();
        return true;
    }

    public PreguntaVoFClasica preguntaActual() {
        return (PreguntaVoFClasica) this.preguntas.peek();
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.offer(jugador);
    }

    public Jugador jugadorActual() {
        return this.jugadores.peekFirst();
    }

    public void cambiarJugador(){
        Jugador jugadorActual = this.jugadores.poll();
        this.jugadores.offer(jugadorActual);
    }
}
