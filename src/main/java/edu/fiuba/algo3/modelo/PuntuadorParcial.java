package edu.fiuba.algo3.modelo;

public class PuntuadorParcial implements Puntuador {
    private ContadorAciertos puntaje;

    public PuntuadorParcial() {
        this.puntaje = new AciertoComun();
    }

    public void acierto() { this.puntaje.sumarAcierto(); }

    public void fallido() { this.puntaje = new AciertoAnulador(); }

    public void falla(){
        this.puntaje.sumarAcierto();
    }

    public void puntuar(Jugador jugador) { this.puntaje.puntuar(jugador); }
}
