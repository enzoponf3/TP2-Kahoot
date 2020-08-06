package edu.fiuba.algo3.modelo;

public class Identificador {
    private ValidezRespuesta validez;

    public Identificador() {
        this.validez = new Incorrecta();
    }

    public void activar() {
        this.validez = new Correcta();
    }

    public void resetear() {
        this.validez = new Incorrecta();
    }

    public void validarRespuesta(RespuestaGroup respuesta) {
        respuesta.validar(this.validez);
    }
}
