package edu.fiuba.algo3.modelo;

public class PuntuadorParcial implements Puntuador {
    private ContadorAciertos cantidadAciertos;

    public PuntuadorParcial() {
        this.cantidadAciertos = new AciertoComun();
    }

    public void acierto() { this.cantidadAciertos.sumarAcierto(); }

    public void fallido() { this.cantidadAciertos = new AciertoAnulador(); }

    public void puntuar(Jugador jugador) { this.cantidadAciertos.puntuar(jugador); }
}
