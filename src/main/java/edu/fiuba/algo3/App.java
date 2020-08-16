package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.PreguntaVoFClasica;
import edu.fiuba.algo3.modelo.PreguntasJuego;
import edu.fiuba.algo3.vista.PantallaInicio;
import edu.fiuba.algo3.vista.VistaPartida;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {
    static String FILENAME_RELATIVE_PATH = "preguntasFile.json";

    @Override
    public void start(Stage stage) {

        Partida partida = this.crearPartida();

        VistaPartida vistaPartida = new VistaPartida(stage, partida);
        //Scene escenaPartida = new Scene(vistaPartida);

        var scene=new Scene(new PantallaInicio(stage,vistaPartida));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private Partida crearPartida() {
        PreguntasJuego preguntas = new PreguntasJuego();
        //ArrayList<PreguntaVoFClasica> preguntas= new ArrayList<>();
        preguntas.add(PreguntaVoFClasica.crearPreguntaVerdadera("Pregunta verdadera 2"));
        preguntas.add(PreguntaVoFClasica.crearPreguntaVerdadera("Pregunta verdadera 1"));
       /* try {
            preguntas.guardar(FILENAME_RELATIVE_PATH);
        } catch (IOException ex) {
            System.out.println("Problemas" + ex);
        }
        PreguntasJuego preguntasLeidas = new PreguntasJuego();
        try {
            preguntasLeidas.recuperar(FILENAME_RELATIVE_PATH);
        } catch (IOException ex) {
            System.out.println(ex);
        }*/

        return new Partida(preguntas);
    }

}