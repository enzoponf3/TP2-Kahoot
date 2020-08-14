package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.PreguntaVoF;
import edu.fiuba.algo3.modelo.PreguntaVoFClasica;
import edu.fiuba.algo3.vista.PantallaInicio;
import edu.fiuba.algo3.vista.PantallaPregunta;
import edu.fiuba.algo3.vista.imagenes.VistaPartida;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Partida partida = this.crearPartida();

        VistaPartida vistaPartida = new VistaPartida(stage, partida);
        //Scene escenaPartida = new Scene(vistaPartida);

        var scene=new Scene(new PantallaInicio(stage,vistaPartida));
        stage.setScene(scene);
        stage.show();
    }

    public Jugador crearJugador(String nombre){
        return Jugador.jugadorConNombre(nombre);
    }

    public static void main(String[] args) {
        launch();
    }

    private Partida crearPartida() {
        ArrayList<PreguntaVoFClasica> preguntas= new ArrayList<>();
        preguntas.add(PreguntaVoFClasica.crearPreguntaVerdadera("Pregunta verdadera 1"));
        preguntas.add(PreguntaVoFClasica.crearPreguntaVerdadera("Pregunta verdadera 2"));
        Jugador jugador1 = this.crearJugador("Diego");
        Jugador jugador2 = this.crearJugador("Pepe");
        Partida laPartida = new Partida(preguntas);
        laPartida.agregarJugador(jugador1);
        laPartida.agregarJugador(jugador2);
        return laPartida;
    }

}