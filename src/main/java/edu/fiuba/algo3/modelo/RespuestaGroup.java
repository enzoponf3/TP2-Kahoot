package edu.fiuba.algo3.modelo;

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
