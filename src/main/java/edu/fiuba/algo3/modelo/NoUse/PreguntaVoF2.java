package edu.fiuba.algo3.modelo.NoUse;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta;

public class PreguntaVoF2 {
    private final Respuesta respuestaVerdadera;
    private final Respuesta respuestaFalsa;

    public PreguntaVoF2() {
        this.respuestaVerdadera = new Respuesta();
        this.respuestaFalsa = new Respuesta();
    }

    static public PreguntaVoF2 crearPreguntaVerdadera() {
        PreguntaVoF2 pregunta = new PreguntaVoF2();
        pregunta.setRespuestaVerdadera();
        return pregunta;
    }

    static public PreguntaVoF2 crearPreguntaFalsa() {
        PreguntaVoF2 pregunta = new PreguntaVoF2();
        pregunta.setRespuestaFalsa();
        return pregunta;
    }

    public void setRespuestaVerdadera() {
        this.respuestaVerdadera.establecerComoRespuestaAcertada();
    }

    public void setRespuestaFalsa() {
        this.respuestaFalsa.establecerComoRespuestaAcertada();
    }

    public void esVerdadero(Jugador jugador) {
        jugador.asignarPuntos(this.respuestaVerdadera.puntuar());
    }

    public void esFalso(Jugador jugador) {
        jugador.asignarPuntos(this.respuestaFalsa.puntuar());
    }
}
