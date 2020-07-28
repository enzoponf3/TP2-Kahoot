package edu.fiuba.algo3.modelo;

public class PreguntaVoF {
    private final Respuesta respuestaVerdadera;
    private final Respuesta respuestaFalsa;

    public PreguntaVoF() {
        this.respuestaVerdadera = new Respuesta();
        this.respuestaFalsa = new Respuesta();
    }

    static public PreguntaVoF crearPreguntaVerdadera() {
        PreguntaVoF pregunta = new PreguntaVoF();
        pregunta.setRespuestaVerdadera();
        return pregunta;
    }

    static public PreguntaVoF crearPreguntaFalsa() {
        PreguntaVoF pregunta = new PreguntaVoF();
        pregunta.setRespuestaFalsa();
        return pregunta;
    }

    public void setRespuestaVerdadera() {
        this.respuestaVerdadera.establecerComoRespuestaAcertada();
    }

    public void setRespuestaFalsa() {
        this.respuestaFalsa.establecerComoRespuestaAcertada();
    }

    public int responderVerdadero() {
        return this.respuestaVerdadera.puntuar();
    }

    public int responderFalso() {
        return this.respuestaFalsa.puntuar();
    }

    public void esVerdadero(Jugador jugador) {
        jugador.asignarPuntos(this.respuestaVerdadera.puntuar());
    }

    public void esFalso(Jugador jugador) {
        jugador.asignarPuntos(this.respuestaFalsa.puntuar());
    }

    public int puntuarRespuesta (Respuesta respuestaJugador){

        return respuestaJugador.puntuar();
    }
}
