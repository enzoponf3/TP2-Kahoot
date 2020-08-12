package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaGrupo {
    private final ArrayList<Respuesta> respuestasGrupoA;
    private final ArrayList<Respuesta> respuestasGrupoB;
    private final ArrayList<Respuesta> respuestasElegibles;
    private ExclusividadPuntaje exclusividad;

    public PreguntaGrupo(int cantidadGrupoA, int cantidadGrupoB){
        this.respuestasGrupoA = new ArrayList<Respuesta>();
        this.respuestasGrupoB = new ArrayList<Respuesta>();
        this.respuestasElegibles = new ArrayList<Respuesta>();
        this.exclusividad= new ExlusividadNula();
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
        ArrayList<Evaluador> evaluadores = new ArrayList<>();
        for (RespuestasJugadorAgrupable iterador: respuestasVariosJugadores) {
            EvaluadorGrupo evaluador= new EvaluadorGrupo(respuestasGrupoA,respuestasGrupoB,iterador);
            evaluador.sumarPuntosParciales();
            evaluadores.add(evaluador);
        }
        exclusividad.agregarEvaluador(evaluadores.get(0),evaluadores.get(1));
        exclusividad.puntuarJugadores();
    }

    public void usarExclusividad() {
        this.exclusividad=this.exclusividad.cambiarExclusividad();
    }
}
