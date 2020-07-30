package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class EvaluadorParcial implements Evaluador {
    public void evaluar(ArrayList<Respuesta> respuestas, Jugador jugador) {
        int puntos = 0;
        for(Respuesta r: respuestas) {
            if(!r.esAcertado()) {
                jugador.asignarPuntos(0);
                return;
            }
            puntos++;
        }

        jugador.asignarPuntos(puntos);
    }
    //ref
    public int evaluar(ArrayList<Integer> respuestasJugador, ArrayList<Respuesta> respuestas){
        int puntos = 0;
        for(int resp : respuestasJugador){
            if(respuestas.get(resp).puntuar() == 0){
                return 0;
            }
            puntos+=respuestas.get(resp).puntuar();
        }
        return puntos;
    }
}
