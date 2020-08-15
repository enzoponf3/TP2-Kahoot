package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class PreguntaGrupo implements Pregunta{
    private final ArrayList<Respuesta> respuestasGrupoA;
    private final ArrayList<Respuesta> respuestasGrupoB;
    private final ArrayList<Respuesta> respuestasElegibles;
    private ExclusividadPuntaje exclusividad;

    public PreguntaGrupo(int cantidadGrupoA, int cantidadGrupoB){
        this.respuestasGrupoA = new ArrayList<Respuesta>();
        this.respuestasGrupoB = new ArrayList<Respuesta>();
        this.respuestasElegibles = new ArrayList<Respuesta>();
        this.exclusividad= new ExlusividadNula();
        for (int i=0;i < cantidadGrupoA+cantidadGrupoB; i++){
            if (i < cantidadGrupoA){
                respuestasGrupoA.add(new Respuesta());
            }
            else {
                respuestasGrupoB.add(new Respuesta());
            }
        }
        respuestasElegibles.addAll(respuestasGrupoA);
        respuestasElegibles.addAll(respuestasGrupoB);
    }

    public Respuesta elegirRespuesta(int idx){
        return respuestasElegibles.get(idx);
    }

    @Override
    public Iterator<Respuesta> devolverRespuestasPosibles() {
        return this.respuestasElegibles.iterator();
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        ArrayList<Evaluador> evaluadores = new ArrayList<>();
        Iterator<RespuestasJugador> iterator = respuestasVariosJugadores.iterator();
        while (iterator.hasNext()){
            EvaluadorGrupo evaluador= new EvaluadorGrupo(respuestasGrupoA,respuestasGrupoB,iterator);
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
