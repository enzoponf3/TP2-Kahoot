package edu.fiuba.algo3.eventos;

import edu.fiuba.algo3.vista.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class botonComienzoHandler implements EventHandler<ActionEvent> {
    Stage stage;
    VistaPartida vistaPartida;
    TextField jugador1;
    TextField jugador2;
    public botonComienzoHandler(Stage stage, VistaPartida vistaPartida, TextField nombre1, TextField nombre2) {
        this.stage = stage;
        this.vistaPartida=vistaPartida;
        this.jugador1 = nombre1;
        this.jugador2 = nombre2;
    }

    public void handle(ActionEvent event){
        if(!jugador2.getText().isBlank() && !jugador1.getText().isBlank()){
            this.vistaPartida.inicio(this.jugador1.getText(), this.jugador2.getText());
        }

    }
}
