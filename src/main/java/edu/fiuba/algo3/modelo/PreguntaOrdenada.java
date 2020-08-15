package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class PreguntaOrdenada implements Pregunta{
    private ArrayList<Respuesta> opcionesOrdenadas;
    private int cantidadOpciones;
    private ExclusividadPuntaje exclusividad;

    public PreguntaOrdenada(int cantidadOpciones){
        this.cantidadOpciones = cantidadOpciones;
        this.opcionesOrdenadas = new ArrayList<>();
        this.exclusividad = new ExlusividadNula();
        for (int i=0;i < this.cantidadOpciones; i++){
            opcionesOrdenadas.add(new Respuesta());
        }
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        ArrayList<Evaluador> evaluadores = new ArrayList<>();
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            EvaluadorOrdenada evaluador= new EvaluadorOrdenada(opcionesOrdenadas,iterador);
            evaluador.sumarPuntosParciales();
            evaluadores.add(evaluador);
        }
        exclusividad.agregarEvaluador(evaluadores.get(0),evaluadores.get(1));
        exclusividad.puntuarJugadores();
    }

    public Respuesta elegirRespuesta(int idx){
        return opcionesOrdenadas.get(idx);
    }

    public Iterator<Respuesta> posiblesRespuestas(){
        return opcionesOrdenadas.iterator();
    }

    public void usarExclusividad() {
        this.exclusividad=this.exclusividad.cambiarExclusividad();
    }
}
