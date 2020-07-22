package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVoF {
    private boolean verdad;
    protected int puntaje = 1;
    public PreguntaVoF(boolean bool) {
        verdad = bool;
    }
    public PreguntaVoF(boolean bool, int puntuacion){verdad = bool; puntaje = puntuacion;}

    public boolean verdad() {
        return this.verdad;
    }

    public int puntuar(boolean respuestaJugador) {
        return respuestaJugador==verdad? puntaje : (puntaje*(-1));
    }

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas) {
        for (Respuesta resp:respuestas
             )
            if (verdad == resp.valor()) {
                resp.sumarPuntos(this.puntaje);
            }
    }
}
