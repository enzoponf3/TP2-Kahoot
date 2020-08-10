package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaChoiceParcial extends PreguntaMC{

    public PreguntaChoiceParcial(int numeroDeOpciones,int cantidadCorrectasDeseadas){
        super(numeroDeOpciones,cantidadCorrectasDeseadas);
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            iterador.evaluarRespuestasCon(new PuntuadorParcial());
        }
    }
}
