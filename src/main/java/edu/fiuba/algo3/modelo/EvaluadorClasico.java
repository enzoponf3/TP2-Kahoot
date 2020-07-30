package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class EvaluadorClasico implements Evaluador {
    public void evaluar(ArrayList<Respuesta> respuestas, Jugador jugador) {

    }
    //ref
    public int evaluar(ArrayList<Integer> respuestasJugador, ArrayList<Respuesta> respuestas){
        for(int resp : respuestasJugador){
            if(respuestas.get(resp).puntuar() == 0){
                return 0;
            }
        }
        return 1;
    }
}
