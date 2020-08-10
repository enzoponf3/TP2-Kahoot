package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class PreguntaMC {
    protected ArrayList<Respuesta> respuestaPosibles;
    protected int cantidadCorrectas;
    protected int cantidadOpciones;

    public PreguntaMC(int numeroDeOpciones,int cantidadCorrectasDeseadas){
        this.cantidadCorrectas= cantidadCorrectasDeseadas;
        this.cantidadOpciones = numeroDeOpciones;
        this.respuestaPosibles = new ArrayList<Respuesta>();
        for (int i=0;i < this.cantidadOpciones; i++){
            respuestaPosibles.add(new Respuesta());
        }
    }

    public abstract void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores);

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
        }
    }

    public Respuesta elegirRespuesta(int idx){
        return respuestaPosibles.get(idx);
    }
}
