package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.botonComienzoHandler;
import edu.fiuba.algo3.eventos.BotonResponderFalsoHandler;
import edu.fiuba.algo3.eventos.BotonResponderVerdaderoHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.PreguntaVoF;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PantallaPregunta extends Pane {
    Stage stage;
    public PantallaPregunta(Stage stage, Jugador jugador, PreguntaVoF unaPregunta){
        this.stage = stage;
        this.setPrefSize(1300,720);
        ArrayList<RespuestasJugador> respuestasJugadores = new ArrayList<>();
        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador);

        Label nombre1 = new Label(unaPregunta.getEnunciado());

        Button botonTrue = new Button("V");
        Button botonFalse = new Button("F");
        Button botonAgregarRespuestas = new Button("AgregarResps");
        Button botonPuntuar = new Button("Puntuar");

        BotonResponderVerdaderoHandler botonResponderVerdaderoHandler = new BotonResponderVerdaderoHandler(respuestasJugador1,unaPregunta);
        botonTrue.setOnAction(botonResponderVerdaderoHandler);

        BotonResponderFalsoHandler botonResponderFalsoHandler = new BotonResponderFalsoHandler(respuestasJugador1,unaPregunta);
        botonTrue.setOnAction(botonResponderVerdaderoHandler);


        nombre1.relocate(600, 100);
        botonFalse.setPrefSize(500,100);
        botonFalse.relocate(100,400);
        botonTrue.setPrefSize(500,100);
        botonTrue.relocate(700,400);

        this.getChildren().addAll(nombre1,botonFalse,botonTrue);

    }


}
