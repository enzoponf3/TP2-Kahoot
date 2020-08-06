package edu.fiuba.algo3.modelo;

public class Casillero {
    private final Identificador identificador;

    public Casillero() {
        this.identificador = new Identificador();
    }

    public RespuestaGroup crearRespuesta() {
        return new RespuestaGroup(this.identificador);
    }

    public void introducirRespuesta(RespuestaGroup respuesta) {
        respuesta.activarIdentificador();
        this.identificador.validarRespuesta(respuesta);
        this.identificador.resetear();
    }
}
