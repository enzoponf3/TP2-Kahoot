package edu.fiuba.algo3.modelo.NoUse;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.Stack;

public class PreguntaVerdadera {
    private final Stack respuestas;

    public PreguntaVerdadera() {
        this.respuestas = new Stack();
    }

    public void responderVerdadero(Jugador jugador) {
        Respuesta respuesta = new Respuesta(jugador);
        respuesta.establecerComoRespuestaAcertada();
        this.respuestas.push(respuesta);
    }

    public void responderFalso(Jugador jugador) {
        Respuesta respuesta = new Respuesta(jugador);
        this.respuestas.push(respuesta);
    }

    public void puntuar() {
        Respuesta respuesta;
        while(!this.respuestas.empty()) {
            respuesta = (Respuesta) this.respuestas.peek();
            respuesta.sumarPuntos();
            this.respuestas.pop();
        }
    }
}
