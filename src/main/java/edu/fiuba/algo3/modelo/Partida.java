package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;

public class Partida {
    private final LinkedList<Jugador> jugadores;
    private final Stack<PreguntaVoFClasica> preguntas;

    public Partida(PreguntasJuego preguntas) {
        this.jugadores = new LinkedList<Jugador>();
        this.preguntas = preguntas.preguntasToStack();
    }

    public boolean hayPreguntas() { return !this.preguntas.empty(); }

    public void siguientePregunta() {
        if (!this.preguntas.empty()) { this.preguntas.pop(); }
    }

    public PreguntaVoFClasica preguntaActual() {
        return this.preguntas.peek();
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
