package edu.fiuba.algo3.modelo;

public class PreguntaVoF3 {
    private final Respuesta2 respuestaVerdadera;
    private final Respuesta2 respuestaFalsa;

    public PreguntaVoF3() {
        this.respuestaVerdadera = new Respuesta2();
        this.respuestaFalsa = new Respuesta2();
    }

    static public PreguntaVoF3 crearPreguntaVerdadera() {
        PreguntaVoF3 pregunta = new PreguntaVoF3();
        pregunta.setRespuestaVerdadera();
        return pregunta;
    }

    static public PreguntaVoF3 crearPreguntaFalsa() {
        PreguntaVoF3 pregunta = new PreguntaVoF3();
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

    public void esVerdadero(Jugador3 jugador) {
        jugador.asignarPuntos(this.respuestaVerdadera.puntuar());
    }

    public void esFalso(Jugador3 jugador) {
        jugador.asignarPuntos(this.respuestaFalsa.puntuar());
    }

    public int puntuarRespuesta (Respuesta2 respuestaJugador){

        return respuestaJugador.puntuar();
    }
}
