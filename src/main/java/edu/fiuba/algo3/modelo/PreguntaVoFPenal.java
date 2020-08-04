package edu.fiuba.algo3.modelo;

public class PreguntaVoFPenal {
    private Respuesta respuestaVerdadera;
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

    public void evaluarRespuesta(RespuestasJugador respuestasDeUnJugador) {
        respuestasDeUnJugador.puntuarRespuestas();
    }

    public Respuesta ElegirRespuestaFalsa() {
        return respuestaFalsa;
    }
    public Respuesta ElegirRespuestaVerdadera() {
        return respuestaVerdadera;
    }

    protected void puntuarRespuestaV(){
        //return this.respuestaVerdadera.puntuar();
    }

    protected void puntuarRespuestaF(){//  return this.respuestaFalsa.puntuar();
    }
}


