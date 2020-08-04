package edu.fiuba.algo3.modelo;

public class Puntaje {
    private int puntos;
    private int puntosParciales;

    public Puntaje(){ this.puntos=0; this.puntosParciales=0; }

    public void sumarPunto(){
        this.puntos++;
    }

    public void restarPunto(){
        this.puntos--;
    }

    public void resetearPuntos(){
        this.puntos=0;
    }

    public void sumarPuntoParcial() {
        this.puntosParciales++;
    }

    public void restarPuntoParcial() {
        this.puntosParciales--;
    }

    public void resetearPuntosParciales(){
        this.puntosParciales=0;
    }

    public int devolverPuntosParciales() {
        return puntosParciales;
    }

    public int devolverPuntos() {
        return puntos;
    }
}
