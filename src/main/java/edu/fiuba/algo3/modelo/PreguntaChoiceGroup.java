package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaChoiceGroup {
    private final ArrayList<Respuesta> respuestasGrupoA;
    private final ArrayList<Respuesta> respuestasGrupoB;
    private final ArrayList<Respuesta> respuestasElegibles;

    public PreguntaChoiceGroup(int cantidadGrupoA,int cantidadGrupoB){
        this.respuestasGrupoA = new ArrayList<Respuesta>();
        this.respuestasGrupoB = new ArrayList<Respuesta>();
        this.respuestasElegibles = new ArrayList<Respuesta>();
        for (int i=0;i < cantidadGrupoA; i++){
            respuestasGrupoA.add(new Respuesta());
        }
        for (int i=0;i < cantidadGrupoB; i++){
            respuestasGrupoB.add(new Respuesta());
        }
        respuestasElegibles.addAll(respuestasGrupoA);
        respuestasElegibles.addAll(respuestasGrupoB);
    }

    public Respuesta elegirRespuesta(int idx){
        return respuestasElegibles.get(idx);
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugadorAgrupable> respuestasVariosJugadores) {
        for (RespuestasJugadorAgrupable iterador: respuestasVariosJugadores) {
            iterador.evaluarRespuestasCon(new PuntuadorGrupo(respuestasGrupoA,respuestasGrupoB,iterador));
        }
    }
}
