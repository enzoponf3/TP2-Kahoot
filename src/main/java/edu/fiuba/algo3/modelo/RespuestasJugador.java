package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class RespuestasJugador {
    private ArrayList<Respuesta> listaRespuestas;
    private ArrayList<Opcion> opcionesElegidas = new ArrayList<>();
    private Jugador jugador;

    public RespuestasJugador(Jugador unJugador) {
        this.jugador = unJugador;
        this.listaRespuestas = new ArrayList<Respuesta>();
    }

    public void puntuarJugador(int puntos) {
        this.jugador.asignarPuntos(puntos);
    }

    public void agregarRespuesta(Respuesta unaRespuesta) {
        this.listaRespuestas.add(unaRespuesta);
    }

    public void agregarOpcionesElegidas(ArrayList<Opcion> opcionesElegidas){
        this.opcionesElegidas.addAll(opcionesElegidas);
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

    //Refactor con PuntuadorParcial

    public void evaluarRespuestasCon(Puntuador puntuador) {
        for(Respuesta r: this.listaRespuestas) { r.evaluarCon(puntuador); }
        puntuador.puntuar(this.jugador);
    }

    public boolean puntuarOrderer(List<Opcion> opcionesOrdenadas) {
        return opcionesOrdenadas.equals(opcionesElegidas);
    }
}
