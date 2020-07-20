package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VoF {
    private boolean verdad;
    protected int puntaje = 1;
    public VoF(boolean bool) {
        verdad = bool;
    }
    public VoF(boolean bool, int puntuacion){verdad = bool; puntaje = puntuacion;}

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
