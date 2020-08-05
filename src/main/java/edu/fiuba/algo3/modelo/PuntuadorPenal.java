package edu.fiuba.algo3.modelo;

public class PuntuadorPenal implements Puntuador {
    private ContadorAciertos cantidadAciertos;

    public PuntuadorPenal() {
        this.cantidadAciertos = new AciertoComun();
    }

    public void acierto() {
        this.cantidadAciertos.sumarAcierto();
    }

    public void fallido() {
        this.cantidadAciertos.restarAcierto();
    }

    public void puntuar(Jugador jugador) {
        this.cantidadAciertos.puntuar(jugador);
    }
}
