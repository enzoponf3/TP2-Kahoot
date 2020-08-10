package edu.fiuba.algo3.modelo.NoUse;

import edu.fiuba.algo3.modelo.Correcta;
import edu.fiuba.algo3.modelo.Incorrecta;
import edu.fiuba.algo3.modelo.NoUse.Evaluable;
import edu.fiuba.algo3.modelo.NoUse.Identificador;
import edu.fiuba.algo3.modelo.Puntuador;
import edu.fiuba.algo3.modelo.ValidezRespuesta;

public class RespuestaGroup implements Evaluable {
    private final Identificador identificador;
    private ValidezRespuesta validez;

    public RespuestaGroup(Identificador identificador) {
        this.identificador = identificador;
        this.validez = new Incorrecta();
    }

    public void identificarse() { this.identificador.identificarRespuesta(this); }

    public void evaluarCon(Puntuador puntuador) {
        this.validez.evaluarCon(puntuador);
    }

    public void establecerComoRespuestaAcertada() { this.validez = new Correcta(); }
}
