package edu.fiuba.algo3.eventos;

import edu.fiuba.algo3.vista.PantallaPregunta;
import edu.fiuba.algo3.vista.imagenes.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class botonComienzoHandler implements EventHandler<ActionEvent> {
    Stage stage;
    VistaPartida vistaPartida;
    public botonComienzoHandler(Stage stage, VistaPartida vistaPartida) {
        this.stage = stage;
        this.vistaPartida=vistaPartida;
    }

    public void handle(ActionEvent event){
        this.vistaPartida.update();
    }
}
