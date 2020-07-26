package edu.fiuba.algo3.modelo;

public class Respuesta {
    private final Jugador3 jugador;
    private Validez validez;

    public Respuesta(Jugador3 jugador) {
        this.jugador = jugador;
        this.validez = new NoAcertado();
    }

    public void establecerComoRespuestaAcertada() {
        this.validez = new Acertado();
    }

    public void sumarPuntos() { this.jugador.asignarPuntos(validez.puntuar()); }
}
