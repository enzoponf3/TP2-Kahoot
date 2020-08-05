package edu.fiuba.algo3.modelo;

public class PuntuadorMCClasica implements Puntuador {
    private ContadorAciertos cantidadAciertos;
    private int cantidadRespuestaAcertadas;
    private int cantidadRespuestasCorrectas;

    public PuntuadorMCClasica(int cantidadRespuestasCorrectas) {
        this.cantidadAciertos = new AciertoComun();
        this.cantidadRespuestaAcertadas = 0;
        this.cantidadRespuestasCorrectas = cantidadRespuestasCorrectas;
    }

    public void acierto() {
        this.cantidadRespuestaAcertadas++;
    }

    public void fallido() { this.cantidadAciertos = new AciertoAnulador(); }

    public void puntuar(Jugador jugador) {
        if( cantidadRespuestaAcertadas == cantidadRespuestasCorrectas) {
            this.cantidadAciertos.sumarAcierto();
        }
        this.cantidadAciertos.puntuar(jugador);
    }

}
