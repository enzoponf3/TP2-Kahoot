package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PreguntaVoF {
    private boolean tipo;

    static public PreguntaVoF crearPreguntaVoFConRespuesta(boolean tipo){
        PreguntaVoF pregunta = new PreguntaVoF();
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

    public void revisionRespuestaDeUnJugador(Jugador jugador1) {
        jugador1.sumarPuntos(this.asignarPuntos(jugador1.respuesta()));
    }
}
