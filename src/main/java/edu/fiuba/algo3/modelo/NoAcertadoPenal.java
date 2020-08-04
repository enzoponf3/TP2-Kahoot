package edu.fiuba.algo3.modelo;

public class NoAcertadoPenal implements Validez {
    public void puntuar(Puntaje puntajeJugador){
        puntajeJugador.restarPunto();
    }
}

