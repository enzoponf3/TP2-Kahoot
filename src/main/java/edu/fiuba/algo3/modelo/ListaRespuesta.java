package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ListaRespuesta {
    private ArrayList<Respuesta> listaRespuestas;
    private Jugador jugador;
    private ArrayList<Integer> respuestas;

    public ListaRespuesta(Jugador unJugador) {
        this.jugador = unJugador;
        this.listaRespuestas = new ArrayList<Respuesta>();
        respuestas = new ArrayList<>();
    }

    public void puntuarJugador(int puntos) {
        this.jugador.asignarPuntos(puntos);
    }

    public void agregarRespuesta(Respuesta unaRespuesta) {
        this.listaRespuestas.add(unaRespuesta);
    }

    public int puntuarRespuestas() {
        int puntos = 0;
        for (Respuesta r : this.listaRespuestas) {
            if (r.puntuar() == 0) {
                return 0;
            } else {
                puntos += r.puntuar();
            }
        }
        return puntos;
    }

    //Refactor con evaluador

    public void puntuarJugadorCon(Evaluador evaluador) { evaluador.evaluar(this.listaRespuestas, this.jugador); }

    //Refactor

    public void agregarRespuesta(int i){
        respuestas.add(i);
    }

    public void puntuarJugador(Evaluador evaluador, int cantidadCorrectas, ArrayList<Respuesta> listaRespuestas) {
        if(cantidadCorrectas != respuestas.size()) return ;
        jugador.asignarPuntos(evaluador.evaluar(this.respuestas,listaRespuestas));
    }
}
