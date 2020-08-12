package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.PantallaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class botonComienzoHandler implements EventHandler<ActionEvent> {
    Stage stage;
    Scene proxEscena;
    public botonComienzoHandler(Stage stage, Scene escenaPregunta) {
        this.stage = stage;
        this.proxEscena=escenaPregunta;
    }

    public void handle(ActionEvent event){
        this.stage.setScene(proxEscena);
    }
}
