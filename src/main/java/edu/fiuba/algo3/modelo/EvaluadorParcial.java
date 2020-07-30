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
}
