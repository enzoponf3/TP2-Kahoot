package edu.fiuba.algo3.modelo;

public class AciertoComun implements ContadorAciertos {
    private int puntos;

    public AciertoComun() {
        this.puntos = 0;
    }

    public void sumarAcierto() {
        this.puntos += 1;
    }



    public void restarAcierto() {
        this.puntos -= 1;

    }
    public void puntuar(Jugador jugador) {
        jugador.asignarPuntos(this.puntos);
    }
}
