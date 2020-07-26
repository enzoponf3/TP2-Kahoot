package edu.fiuba.algo3.modelo;

public class Jugador3 {
    private int puntos;
    public String[] respuestas;

    public Jugador3() {
        this.puntos = 0;
    }

    public void asignarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int darPuntos() {
        return this.puntos;
    }

    public int getPuntos(){
        return this.puntos;
    }

    public String[] getRespuestas(){
        return this.respuestas;
    }

    public void setRespuesta(String[] respuestasJugador){
        this.respuestas = respuestasJugador;
    }
}
