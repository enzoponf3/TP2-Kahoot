package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class PreguntaVoF2 {
    private boolean tipo;

    static public PreguntaVoF2 crearPreguntaVoFConRespuesta(boolean tipo){
        PreguntaVoF2 pregunta = new PreguntaVoF2();
        pregunta.setTipo(tipo);
        return pregunta;
    }

    public void setTipo(boolean tipo){
        this.tipo=tipo;
    }

    public boolean tipo(){
        return tipo;
    }

    public int asignarPuntos(boolean respuesta) {
        if (respuesta == this.tipo) {
            return 1;
        } else {
            return 0;
        }
    }

    public void revisionRespuestas(ArrayList listaDeRespuesta) {
        Iterator <Jugador> iterator = listaDeRespuesta.iterator();
        while (iterator.hasNext()) {
            Jugador jugadorX;
            jugadorX = iterator.next();
            jugadorX.sumarPuntos(this.asignarPuntos(jugadorX.respuesta()));
        }
    }

    public void revisionRespuestaDeUnJugador(Jugador2 jugador1) {
        jugador1.sumarPuntos(this.asignarPuntos(jugador1.respuesta()));
    }
}
