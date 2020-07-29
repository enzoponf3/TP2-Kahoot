package edu.fiuba.algo3.modelo;

public class PreguntaVoFPenal {
    private  Respuesta respuestaVerdadera;
    private  Respuesta respuestaFalsa;

    public PreguntaVoFPenal(){
        this.respuestaVerdadera = new Respuesta();
        this.respuestaFalsa = new Respuesta();
        this.respuestaVerdadera.establecerComoRespuestalNoAcertadaPenal();
        this.respuestaFalsa.establecerComoRespuestalNoAcertadaPenal();
    }

    static public PreguntaVoFPenal crearPreguntaVerdadera() {
        PreguntaVoFPenal pregunta = new PreguntaVoFPenal();
        pregunta.setRespuestaVerdadera();
        return pregunta;
    }

    static public PreguntaVoFPenal crearPreguntaFalsa() {
        PreguntaVoFPenal pregunta = new PreguntaVoFPenal();
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


