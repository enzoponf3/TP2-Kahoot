package edu.fiuba.algo3.modelo;

public class PuntuadorPenal implements Puntuador {
    private ContadorAciertos puntaje;

    public PuntuadorPenal() {
        this.puntaje = new AciertoComun();
    }

    public void acierto() {
        this.puntaje.sumarAcierto();
    }

    public void fallido() {
        this.puntaje.restarAcierto();// = new AciertoNegativo();
    }

    public void falla(){
        this.puntaje.sumarAcierto();
    }

    public void puntuar(Jugador jugador) {
        this.puntaje.puntuar(jugador);
    }
}
