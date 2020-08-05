package edu.fiuba.algo3.modelo;

public class PuntuadorVoFPenal implements Puntuador {
    private ContadorAciertos cantidadAciertos;

    public PuntuadorVoFPenal() {
        this.cantidadAciertos = new AciertoComun();
    }

    public void acierto() { this.cantidadAciertos.sumarAcierto(); }

    public void fallido() {this.cantidadAciertos.restarAcierto();}

    public void puntuar(Jugador jugador) { this.cantidadAciertos.puntuar(jugador); }
}
