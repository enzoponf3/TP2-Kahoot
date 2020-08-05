package edu.fiuba.algo3.modelo;

public class PuntuadorClasico implements Puntuador {
    private Puntaje puntaje;
    private int cantidadRespuestaAcertadas;
    private int cantidadRespuestasCorrectas;

    public PuntuadorClasico(int cantidadRespuestasCorrectas) {
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

        }
    }

}
