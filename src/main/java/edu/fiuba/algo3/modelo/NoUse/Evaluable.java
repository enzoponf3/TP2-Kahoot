package edu.fiuba.algo3.modelo.NoUse;

import edu.fiuba.algo3.modelo.Evaluador;

public interface Evaluable {
    void establecerComoRespuestaAcertada();
    void evaluarCon(Evaluador evaluador);
}
