package edu.fiuba.algo3.modelo.ale;

public class PreguntaVoF {
    private TipoRespuesta respuestaCorrecta;

    public PreguntaVoF(TipoRespuesta respuestaElegida) {
        this.respuestaCorrecta=respuestaElegida;
    }

    public void evaluarRespuesta(TipoRespuesta respuestaJugador){
        respuestaJugador.puntuarRespuestaVerdadera();
        respuestaJugador.puntuarRespuestaFalsa();

    }
}
