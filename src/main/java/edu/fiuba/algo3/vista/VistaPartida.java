package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaPartida {

    private final Partida partida;
    private final Stage stage;
    private Jugador primerJugador;
    private ArrayList<RespuestasJugador> respuestasJugadores;


    public VistaPartida(Stage stage, Partida partida) {
        this.partida = partida;
        this.stage=stage;
        this.respuestasJugadores = new ArrayList<>();
    }

    public void inicio(String nombre1, String nombre2){
        Jugador jugador1 = new Jugador(nombre1);
        Jugador jugador2 = new Jugador(nombre2);
        this.partida.agregarJugador(jugador1);
        this.partida.agregarJugador(jugador2);
        this.primerJugador = this.partida.jugadorActual();
        this.stage.setScene(new Scene(vistaPreguntaActual(this.partida.preguntaActual())));
    }

    public void update() {
        this.partida.cambiarJugador();
        if(this.partida.jugadorActual() == this.primerJugador) {
            this.partida.preguntaActual().evaluarRespuestas(this.respuestasJugadores);
            this.respuestasJugadores = new ArrayList<>();
            this.partida.siguientePregunta();
            if (!this.partida.hayPreguntas()) {
                this.stage.setScene(new Scene(new PantallaFinal(this.stage, this)));
                return;
            }
        }

        this.stage.setScene(new Scene(vistaPreguntaActual(this.partida.preguntaActual())));
    }

    public void agregarRespuestaAJugadorActual(RespuestasJugador respuestas){
        respuestasJugadores.add(respuestas);
    }

    private Pane vistaPreguntaActual(Pregunta pregunta) {
        if(pregunta.getClass() == PreguntaChoiceParcial.class) { return new VistaPreguntaChoiceParcial(this.stage, this); }
        else if(pregunta.getClass() == PreguntaVoFClasica.class) { return new VistaPreguntaVoFClasica(this.stage, this); }
        else if(pregunta.getClass() == PreguntaChoiceClasica.class) { return new VistaPreguntaMCClasica(this.stage, this); }
        else if(pregunta.getClass() == PreguntaChoicePenal.class) { return new VistaPreguntaChoicePenal(this.stage, this); }
        else if(pregunta.getClass() == PreguntaVoFPenal.class) { return new VistaPreguntaVoFPenal(this.stage, this); }
        else if(pregunta.getClass() == PreguntaGrupo.class) { return new VistaPreguntaGrupo(this.stage, this); }
        return new VistaPreguntaOrdenada(this.stage, this);
    }

    public Partida partida() {
        return this.partida;
    }
}
