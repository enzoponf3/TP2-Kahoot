package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.PreguntaVoF;
import edu.fiuba.algo3.modelo.PreguntaVoFClasica;
import edu.fiuba.algo3.vista.PantallaInicio;
import edu.fiuba.algo3.vista.PantallaPregunta;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Jugador jugador1 = this.crearJugador("Diego");
        PreguntaVoF pregunta1 = this.crearPreguntaVoF("Este es tu enunciado, que cambiaste.");

        PantallaPregunta pantallaPreguntaVoF = new PantallaPregunta(stage, jugador1, pregunta1);
        Scene escenaPreguntaVoF = new Scene(pantallaPreguntaVoF);

        var scene=new Scene(new PantallaInicio(stage,escenaPreguntaVoF));
        stage.setScene(scene);
        stage.show();
    }

    public Jugador crearJugador(String nombre){
        return Jugador.jugadorConNombre(nombre);
    }

    public PreguntaVoFClasica crearPreguntaVoF(String enunciadoPregunta){
        return PreguntaVoFClasica.crearPreguntaVerdadera(enunciadoPregunta);
    }

    public static void main(String[] args) {
        launch();
    }

}