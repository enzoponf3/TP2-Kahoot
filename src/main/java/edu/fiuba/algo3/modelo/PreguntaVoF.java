package edu.fiuba.algo3.modelo;

public class PreguntaVoF {
    private Respuesta respuestaVerdadera;
    private Respuesta respuestaFalsa;

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


    public void evaluarRespuesta(ListaRespuesta listaRespuestasJugador1) {
        listaRespuestasJugador1.puntuarJugador(listaRespuestasJugador1.puntuarRespuestas());
    }

    public Respuesta ElegirRespuestaFalsa() {
        return respuestaFalsa;
    }
    public Respuesta ElegirRespuestaVerdadera() {
        return respuestaVerdadera;
    }

    protected int puntuarRespuestaV(){
        return this.respuestaVerdadera.puntuar();
    }

    protected int puntuarRespuestaF(){
        return this.respuestaFalsa.puntuar();
    }
}
