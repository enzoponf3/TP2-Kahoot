package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ale.PreguntaVoF;

public class PreguntaExclusiva implements IPregunta {


    @Override
    public PreguntaVoF VoF(boolean bool){
        return new VoFClassic(bool);
    }
}
