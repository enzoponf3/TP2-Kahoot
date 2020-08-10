package edu.fiuba.algo3.modelo.NoUse;

import edu.fiuba.algo3.modelo.Puntuador;

public interface Evaluable {
    void establecerComoRespuestaAcertada();
    void evaluarCon(Puntuador puntuador);
}
