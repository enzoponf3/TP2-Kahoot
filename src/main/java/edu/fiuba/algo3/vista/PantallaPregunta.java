package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.botonComienzoHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PantallaPregunta extends Pane {
    Stage stage;
    public PantallaPregunta(Stage stage){
        this.stage = stage;
        this.setPrefSize(1300,720);

        Label nombre1 = new Label("¿La tierra es plana?");

        Button btnTrue = new Button("Sí! ");
        Button btnFalse = new Button("No!");


        nombre1.relocate(600, 100);
        btnFalse.setPrefSize(500,100);
        btnFalse.relocate(100,400);
        btnTrue.setPrefSize(500,100);
        btnTrue.relocate(700,400);

        this.getChildren().addAll(nombre1,btnFalse,btnTrue);

    }


}
