package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.PantallaInicio;
import edu.fiuba.algo3.vista.VistaPartida;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    static String FILENAME_RELATIVE_PATH = "preguntasFile.json";

    @Override
    public void start(Stage stage) {

        Partida partida = this.crearPartida();

        VistaPartida vistaPartida = new VistaPartida(stage, partida);

        var scene=new Scene(new PantallaInicio(stage,vistaPartida));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private Partida crearPartida() {
        PreguntasJuego preguntasLeidas = new PreguntasJuego();

        try {
            preguntasLeidas = PreguntasJuego.recuperar(FILENAME_RELATIVE_PATH);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return new Partida(preguntasLeidas);
    }

}