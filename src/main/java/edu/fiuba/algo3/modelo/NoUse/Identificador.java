package edu.fiuba.algo3.modelo.NoUse;

public class Identificador {
    private Identificable estado;

    public Identificador() { this.estado = new Desactivado(); }

    public void activar() { this.estado = new Activado(); }

    public void desactivar() { this.estado = new Desactivado(); }

    public void identificarRespuesta(RespuestaGroup respuesta) {
        this.estado.identificar(respuesta); }
}
