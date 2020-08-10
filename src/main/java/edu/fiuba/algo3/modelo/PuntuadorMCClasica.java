package edu.fiuba.algo3.modelo;

public class PuntuadorMCClasica implements Puntuador {
    private Puntaje puntaje;
    private int cantidadRespuestaAcertadas;
    private final int cantidadRespuestasCorrectas;

    public PuntuadorMCClasica(int cantidadRespuestasCorrectas) {
        this.puntaje = new Puntaje();
        this.cantidadRespuestaAcertadas = 0;
        this.cantidadRespuestasCorrectas = cantidadRespuestasCorrectas;
    }

    public void acierto() {
        this.cantidadRespuestaAcertadas++;
    }

    public void fallido() { this.puntaje = new PuntajeNulo(); }

    public void puntuar(Jugador jugador) {
        if( cantidadRespuestaAcertadas == cantidadRespuestasCorrectas) {
            puntaje.sumarPunto();
        }
        jugador.puntuar(this.puntaje);
    }

}
