package edu.fiuba.algo3.modelo;

public class PuntuadorMcClasico implements Puntuador {
    private ContadorAciertos puntaje;
    private int cantidadRespuestaAcertadas;
    private int cantidadRespuestasCorrectas;

    public PuntuadorMcClasico(int cantidadRespuestasCorrectas) {
        this.puntaje = new AciertoComun();
        this.cantidadRespuestaAcertadas = 0;
        this.cantidadRespuestasCorrectas = cantidadRespuestasCorrectas;
    }

    public void acierto() {
        this.cantidadRespuestaAcertadas++;
    }

    public void fallido() { this.puntaje = new AciertoAnulador(); }

    public void puntuar(Jugador jugador) {
        if( cantidadRespuestaAcertadas == cantidadRespuestasCorrectas) {
            this.puntaje.sumarAcierto();
        }
        this.puntaje.puntuar(jugador);
    }

}
