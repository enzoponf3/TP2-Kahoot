package edu.fiuba.algo3.modelo.NoUse;

import edu.fiuba.algo3.modelo.Acertado;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.NoAcertado;
import edu.fiuba.algo3.modelo.Validez;

public class Respuesta {
    private final Jugador jugador;
    private Validez validez;

    public Respuesta(Jugador jugador) {
        this.jugador = jugador;
        this.validez = new NoAcertado();
    }

    public void establecerComoRespuestaAcertada() {
        this.validez = new Acertado();
    }

    public void sumarPuntos() { this.jugador.asignarPuntos(validez.puntuar()); }
}
