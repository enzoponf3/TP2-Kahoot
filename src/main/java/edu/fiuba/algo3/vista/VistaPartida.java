package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaPartida {

    private final Partida partida;
    private final Stage stage;
    private Jugador primerJugador;
    private Pregunta pregunta;
    private ArrayList<RespuestasJugador> respuestasJugadores;


    public VistaPartida(Stage stage, Partida partida) {
        this.partida = partida;
        this.stage=stage;
        this.pregunta=partida.preguntaActual();
        this.respuestasJugadores = new ArrayList<>();
    }

    public void inicio(String nombre1, String nombre2){
        Jugador jugador1 = Jugador.jugadorConNombre(nombre1);
        Jugador jugador2 = Jugador.jugadorConNombre(nombre2);
        this.partida.agregarJugador(jugador1);
        this.partida.agregarJugador(jugador2);
        this.primerJugador = this.partida.jugadorActual();
        this.stage.setScene(new Scene(new VistaPreguntaVoFClasica(this.stage, this)));
    }

    public void update() {
        this.partida.cambiarJugador();
        if(this.partida.jugadorActual() == this.primerJugador) {
            this.partida.preguntaActual().evaluarRespuestas(this.respuestasJugadores);
            this.respuestasJugadores = new ArrayList<RespuestasJugador>();
            this.partida.siguientePregunta();
            if (!this.partida.hayPreguntas()) {
                this.stage.setScene(new Scene(new PantallaFinal(this.stage, this)));
                return;
            }
        }

        this.stage.setScene(new Scene(new VistaPreguntaVoFClasica(this.stage, this)));
    }

    public void agregarRespuestaAJugadorActual(RespuestasJugador respuestas){
        respuestasJugadores.add(respuestas);
    }

    public Partida partida() {
        return this.partida;
    }
}
