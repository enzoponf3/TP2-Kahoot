package edu.fiuba.algo3.modelo;

public class RespuestaGroup implements Evaluable {
    private final Identificador identificador;
    private ValidezRespuesta validez;

    public RespuestaGroup(Identificador identificador) {
        this.identificador = identificador;
        this.validez = new Incorrecta();
    }

    public void activarIdentificador() {
        this.identificador.activar();
    }

    public void validar(ValidezRespuesta validez) {
        this.validez = validez;
    }

    public void evaluarCon(Puntuador puntuador) {
        this.validez.evaluarCon(puntuador);
    }
}
