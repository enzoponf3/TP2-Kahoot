package edu.fiuba.algo3.vista.imagenes;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.PreguntaVoFClasica;
import edu.fiuba.algo3.vista.PantallaPregunta;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VistaPartida {

    private final Partida partida;
    private final Stage stage;
    private final Jugador primerJugador;
    private PreguntaVoFClasica pregunta;


    public VistaPartida(Stage stage, Partida partida) {
        this.partida = partida;
        this.stage=stage;
        this.pregunta=partida.preguntaActual();
        this.primerJugador =partida.jugadorActual();
        this.stage.setScene(new Scene(new PantallaPregunta(this.stage, this)));
    }

    public void update() {
        this.partida.cambiarJugador();
        if (this.primerJugador == this.partida.jugadorActual() && this.partida.siguientePregunta()){
            this.pregunta=this.partida.preguntaActual();
            this.stage.setScene(new Scene(new PantallaPregunta(this.stage,this)));
        }
        else {
            this.stage.setScene(new Scene(new PantallaPregunta(this.stage, this)));
        }
    }

    public Partida partida() {
        return this.partida;
    }
}
