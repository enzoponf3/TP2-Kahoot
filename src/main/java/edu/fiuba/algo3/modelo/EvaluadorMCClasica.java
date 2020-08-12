package edu.fiuba.algo3.modelo;

public class EvaluadorMCClasica implements Evaluador {
    private Puntaje puntajeParcial;
    private Jugador jugador;
    private int cantidadRespuestaAcertadas;
    private final int cantidadRespuestasCorrectas;

    public EvaluadorMCClasica(int cantidadRespuestasCorrectas, Jugador unJugador) {
        this.puntajeParcial = new Puntaje();
        this.jugador=unJugador;
        this.cantidadRespuestaAcertadas = 0;
        this.cantidadRespuestasCorrectas = cantidadRespuestasCorrectas;
    }

    public void acierto() {
        this.cantidadRespuestaAcertadas++;
    }

    public void fallido() { this.puntajeParcial = new PuntajeNulo(); }

    public void sumarPuntosParciales(){
        if( this.cantidadRespuestaAcertadas == this.cantidadRespuestasCorrectas) {
            this.puntajeParcial.sumarPunto();
        }
    }

    @Override
    public Puntaje puntaje() {
        return this.puntajeParcial;
    }

    @Override
    public Jugador jugador() {
        return this.jugador;
    }

}
