package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestasJugador;

import java.util.ArrayList;

public class PreguntaChoiceClasica {
    private ArrayList<Respuesta> respuestaPosibles;
    private int cantidadCorrectas;
    private int cantidadOpciones;

    public PreguntaChoiceClasica(int numeroDeOpciones,int cantidadCorrectasDeseadas){
        this.cantidadCorrectas= cantidadCorrectasDeseadas;
        this.cantidadOpciones = numeroDeOpciones;
        this.respuestaPosibles = new ArrayList<Respuesta>();
        for (int i=0;i < this.cantidadOpciones; i++){
            respuestaPosibles.add(new Respuesta());
        }
    }

    public void evaluarRespuesta(ArrayList<RespuestasJugador> RespuestasDeVariosJugadores) {
        for (RespuestasJugador respuestasDeUnJugador: RespuestasDeVariosJugadores) {
            respuestasDeUnJugador.puntuarRespuestas();
            if(respuestasDeUnJugador.devolverJugador().devolverPuntaje().devolverPuntosParciales() == this.cantidadCorrectas){
                respuestasDeUnJugador.devolverJugador().devolverPuntaje().sumarPunto();
            }
            respuestasDeUnJugador.devolverJugador().devolverPuntaje().resetearPuntosParciales();
        }
    }

    protected int cantidadRespuestasCorrectas() {
        return this.cantidadCorrectas;
    }

    public void agregarRespuestasCorrectas() {
        int i=0;
        for (Respuesta r : this.respuestaPosibles) {
            if (i < this.cantidadCorrectas) {
                r.establecerComoRespuestaAcertadaParcial();
                i++;
            }
        }
    }

    public Respuesta elegirRespuesta(int idx){
        return respuestaPosibles.get(idx);
    }
}
