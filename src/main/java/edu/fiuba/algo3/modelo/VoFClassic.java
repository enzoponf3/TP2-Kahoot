package edu.fiuba.algo3.modelo;

public class VoFClassic extends VoF {
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
