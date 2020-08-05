package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaChoicePenal {
    private ArrayList<Respuesta> respuestaPosibles;
    private int cantidadCorrectas;
    private int cantidadOpciones;

    public PreguntaChoicePenal(int numeroDeOpciones,int cantidadCorrectasDeseadas){
        this.cantidadCorrectas= cantidadCorrectasDeseadas;
        this.cantidadOpciones = numeroDeOpciones;
        this.respuestaPosibles = new ArrayList<Respuesta>();
        for (int i=0;i < this.cantidadOpciones; i++){
            respuestaPosibles.add(new Respuesta());
        }
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            iterador.evaluarRespuestasCon(new PuntuadorPenal());
        }
    }

    protected int cantidadRespuestasCorrectas() {
        return this.cantidadCorrectas;
    }

    public void agregarRespuestasCorrectas() {
        int i=0;
        for (Respuesta r : this.respuestaPosibles) {
            if (i < this.cantidadCorrectas) {
                r.establecerComoRespuestaAcertada();
                i++;
            }
            else {
              r.establecerComoRespuestaNoAcertadaPenal();
            }
        }
    }

    public Respuesta elegirRespuesta(int idx){
        return respuestaPosibles.get(idx);
    }
}
