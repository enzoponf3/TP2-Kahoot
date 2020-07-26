package edu.fiuba.algo3.modelo;

public class Clasica extends MultipleChoice{

    @Override
    public void procesarRespuesta(Jugador3 jugador1, Jugador3 jugador2){
        String[] respuestasJugador1 = jugador1.getRespuestas();
        int largoRespuestas = this.respuestaCorrecta.length;
        int largoJugador1 = jugador1.getRespuestas().length;
        int contadorJugador1 = 0;
        for(int j = 0; j < largoRespuestas; j++){
            for(int i = 0; i < largoJugador1; i++){
                if(respuestaCorrecta[j] == respuestasJugador1[i]){
                    contadorJugador1++;
            }
        }
    }
        String[] respuestasJugador2 = jugador2.getRespuestas();
        int largoJugador2 = jugador2.getRespuestas().length;
        int contadorJugador2 = 0;
        for(int j = 0; j < largoRespuestas; j++){
            for(int i = 0; i < largoJugador2; i++){
                if(respuestaCorrecta[j] == respuestasJugador2[i]){
                    contadorJugador2++;
                }
            }
        }
        if(largoRespuestas == contadorJugador1){
            jugador1.asignarPuntos(1);
        }
        if(largoRespuestas == contadorJugador2) {
            jugador2.asignarPuntos(1);
        }
    }

    public Clasica(String pregunta, String[] listaDeRespuestas){
        this.respuestaCorrecta = listaDeRespuestas;
        this.enunciado = pregunta;
    }

    public Clasica(){
    }

}
