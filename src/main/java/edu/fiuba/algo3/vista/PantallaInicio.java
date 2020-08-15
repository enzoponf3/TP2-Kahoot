package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.eventos.botonComienzoHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PantallaInicio extends Pane {
    Stage stage;

    public PantallaInicio(Stage stage, VistaPartida vistaPartida){
        this.stage = stage;
        this.setPrefSize(1300,720);

        Label nombre1 = new Label("JUGADOR 1");
        TextField text1 = new TextField();
        text1.setPromptText("Nombre jugador 1");
        text1.setPrefSize(200,40);
        Label nombre2 = new Label("JUGADOR 2");
        TextField text2 = new TextField();
        text2.setPromptText("Nombre jugador 2");
        text2.setPrefSize(200,40);

        Button btnInicio = new Button("Comenzar");
        btnInicio.setOnAction(new botonComienzoHandler(stage,vistaPartida,text1, text2));
        
        nombre1.relocate(250, 350);
        text1.relocate(250,370);
        nombre2.relocate(875, 350);
        text2.relocate(875,370);
        btnInicio.relocate(600,400);

        this.getChildren().addAll(nombre1,text1,nombre2,text2,btnInicio);

    }


}
