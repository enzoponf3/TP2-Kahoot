package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaChoiceGroup {
    private final ArrayList<RespuestaGroup> respuestas;
    private final int cantidadCorrectas;
    private final Casillero casillero1;
    private final Casillero casillero2;

    public PreguntaChoiceGroup(int opcionesCasillero1,int opcionesCasillero2){
        this.cantidadCorrectas= opcionesCasillero1 + opcionesCasillero2;
        this.respuestas = new ArrayList<RespuestaGroup>();
        this.casillero1 = new Casillero();
        this.casillero2 = new Casillero();
        for (int i=0;i < opcionesCasillero1; i++){
            respuestas.add(casillero1.crearRespuesta());
        }
        for (int i=0;i < opcionesCasillero2; i++){
            respuestas.add(casillero2.crearRespuesta());
        }
    }

    public RespuestaGroup elegirRespuesta(int idx){
        return respuestas.get(idx);
    }

    public void introducirRespuestaEnCasillero1(RespuestaGroup respuesta) {
        this.casillero1.introducirRespuesta(respuesta);
    }

    public void introducirRespuestaEnCasillero2(RespuestaGroup respuesta) {
        this.casillero2.introducirRespuesta(respuesta);
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            iterador.evaluarRespuestasCon(new PuntuadorClasico(this.cantidadCorrectas));
        }
    }
}
