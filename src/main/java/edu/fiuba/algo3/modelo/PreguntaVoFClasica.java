package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVoFClasica extends PreguntaVoF {
    ArrayList<Jugador> jugadores;
    ExclusividadPuntaje exclusividad;

    static public PreguntaVoFClasica crearPreguntaVerdadera() {
        PreguntaVoFClasica pregunta = new PreguntaVoFClasica();
        pregunta.setRespuestaVerdadera();
        pregunta.jugadores= new ArrayList<Jugador>();
        pregunta.exclusividad = new SinExlusividad();
        return pregunta;
    }

    static public PreguntaVoFClasica crearPreguntaFalsa() {
        PreguntaVoFClasica pregunta = new PreguntaVoFClasica();
        pregunta.setRespuestaFalsa();
        pregunta.jugadores= new ArrayList<Jugador>();
        pregunta.exclusividad = new SinExlusividad();
        return pregunta;
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        ArrayList<Puntaje> puntajesParciales = new ArrayList<>();
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            PuntuadorComun puntuador= new PuntuadorComun();
            iterador.evaluarRespuestasCon(puntuador);
            this.jugadores.add(iterador.devolverJugador());
            puntajesParciales.add(puntuador.darPuntaje());
        }
        exclusividad.puntuarJugadores(this.jugadores,puntajesParciales);
    }

    public void usarExclusividad() {
        this.exclusividad=this.exclusividad.cambiarExclusividad();
    }
}
