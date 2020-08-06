package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.PantallaInicio;
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
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 1300, 720);
        var scene2=new Scene(new PantallaInicio(stage));
        //scene2.getStylesheets().add(
          //      getClass().getResource("styles.css").toString());
        //scene2.getStylesheets().add("styles.css");
        stage.setScene(scene2);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}