package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ale.PreguntaVoF;

public class VoFClassic extends PreguntaVoF {
    public VoFClassic(boolean bool) {
        super(bool);
    }

    public VoFClassic(boolean bool, int puntuacion) {
        super(bool, puntuacion);
    }
    public int puntuar(){
        return this.puntaje;
    }

}
