package edu.fiuba.algo3.modelo;

public class Jugador {
    public int puntos;
    public boolean respuesta;

    public Jugador (){
        puntos = 0;
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
