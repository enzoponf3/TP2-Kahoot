package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

import java.util.ArrayList;

public class PreguntaOrdenada implements Pregunta{
    private final ArrayList<Respuesta> opcionesOrdenadas;
    private ExclusividadPuntaje exclusividad;
    private String enunciado;

    public PreguntaOrdenada(int cantidadOpciones, String enunciado){
        this.opcionesOrdenadas = new ArrayList<>();
        this.enunciado=enunciado;
        this.exclusividad = new ExlusividadNula();
        for (int i = 0; i < cantidadOpciones; i++){
            opcionesOrdenadas.add(new Respuesta("Algo"));
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

    @Override
    public JsonObject guardar() {
        return null;
    }

    @Override
    public String devolverEnunciado() {
        return enunciado;
    }

    public Respuesta elegirRespuesta(int idx){
        return opcionesOrdenadas.get(idx);
    }

    @Override
    public ArrayList<Respuesta> devolverRespuestasPosibles() {
        return this.opcionesOrdenadas;
    }

    public void usarExclusividad() {
        this.exclusividad=this.exclusividad.cambiarExclusividad();
    }
}
