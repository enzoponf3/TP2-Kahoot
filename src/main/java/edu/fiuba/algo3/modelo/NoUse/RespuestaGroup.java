package edu.fiuba.algo3.modelo.NoUse;

import edu.fiuba.algo3.modelo.Correcta;
import edu.fiuba.algo3.modelo.Incorrecta;
import edu.fiuba.algo3.modelo.Evaluador;
import edu.fiuba.algo3.modelo.ValidezRespuesta;

public class RespuestaGroup implements Evaluable {
    private final Identificador identificador;
    private ValidezRespuesta validez;

    public RespuestaGroup(Identificador identificador) {
        this.identificador = identificador;
        this.validez = new Incorrecta();
    }

    public void identificarse() { this.identificador.identificarRespuesta(this); }

    public void evaluarCon(Evaluador evaluador) {
        this.validez.evaluarCon(evaluador);
    }

    public void establecerComoRespuestaAcertada() { this.validez = new Correcta(); }
}
