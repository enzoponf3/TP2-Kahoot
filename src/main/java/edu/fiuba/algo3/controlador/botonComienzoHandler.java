package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.PantallaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class botonComienzoHandler implements EventHandler<ActionEvent> {
    Stage stage;
    public botonComienzoHandler(Stage stage) {
        this.stage = stage;
    }

    public void handle(ActionEvent event){
        Scene scene = new Scene(new PantallaPregunta(this.stage));
        this.stage.setScene(scene);
    }
}
