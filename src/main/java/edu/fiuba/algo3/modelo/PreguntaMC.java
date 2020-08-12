package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class PreguntaMC {
    protected ArrayList<Respuesta> respuestaPosibles;
    protected int cantidadCorrectas;
    protected int cantidadOpciones;
    ExclusividadPuntaje exclusividad;

    public PreguntaMC(int numeroDeOpciones,int cantidadCorrectasDeseadas){
        this.cantidadCorrectas= cantidadCorrectasDeseadas;
        this.cantidadOpciones = numeroDeOpciones;
        this.respuestaPosibles = new ArrayList<Respuesta>();
        this.exclusividad = new ExlusividadNula();
        this.agregarRespuestasCorrectas();
    }

    public abstract void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores);

    protected int cantidadRespuestasCorrectas() {
        return this.cantidadCorrectas;
    }

    public void agregarRespuestasCorrectas() {
        for (int i=0;i < this.cantidadOpciones; i++){
            respuestaPosibles.add(new Respuesta());
            if (i < cantidadCorrectas){
                respuestaPosibles.get(i).establecerComoRespuestaAcertada();
            }
        }
    }

    public Respuesta elegirRespuesta(int idx){
        return respuestaPosibles.get(idx);
    }

    public void usarExclusividad() {
        this.exclusividad=this.exclusividad.cambiarExclusividad();
    }
}
