package edu.fiuba.algo3.modelo;

public class Jugador {
    public int puntos;
    public boolean respuesta;

    public Jugador (boolean respuestaElegida){
        puntos = 0;
        respuesta = respuestaElegida;
    }

    public int puntos(){
        return this.puntos;
    }

    public void sumarPuntos(int p){
        this.puntos= this.puntos + p;
    }

    public void sumarPuntos() {
    }

    public boolean respuesta() {
        return this.respuesta;
    }
}
