package edu.fiuba.algo3.modelo;

public class PreguntaVoF3 {
    private Respuesta2 respuestaVerdadera;
    private Respuesta2 respuestaFalsa;

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
        this.respuestaVerdadera = Respuesta2.crearRespuestaAcertada();
        this.respuestaFalsa = Respuesta2.crearRespuestaNoAcertada();
    }

    public void setRespuestaFalsa() {
        this.respuestaVerdadera = Respuesta2.crearRespuestaNoAcertada();
        this.respuestaFalsa = Respuesta2.crearRespuestaAcertada();
    }

    public int responderVerdadero() {
        return this.respuestaVerdadera.puntuar();
    }

    public int responderFalso() {
        return this.respuestaFalsa.puntuar();
    }
}
