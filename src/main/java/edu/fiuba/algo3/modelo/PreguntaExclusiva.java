package edu.fiuba.algo3.modelo;

public class PreguntaExclusiva implements IPregunta {


    @Override
    public PreguntaVoF VoF(boolean bool){
        return new VoFClassic(bool);
    }
}
