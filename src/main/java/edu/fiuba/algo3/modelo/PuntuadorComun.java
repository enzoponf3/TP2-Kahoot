package edu.fiuba.algo3.modelo;

public class PuntuadorComun implements Puntuador {
    private ContadorAciertos cantidadAciertos;

    public PuntuadorComun() {
        this.cantidadAciertos = new AciertoComun();
    }

    public void acierto() { this.cantidadAciertos.sumarAcierto(); }

    public void fallido() {}

    public void puntuar(Jugador jugador) { this.cantidadAciertos.puntuar(jugador); }
}
