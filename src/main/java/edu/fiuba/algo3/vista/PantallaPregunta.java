package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.eventos.BotonResponderFalsoHandler;
import edu.fiuba.algo3.eventos.BotonResponderVerdaderoHandler;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import edu.fiuba.algo3.vista.imagenes.VistaPartida;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PantallaPregunta extends Pane {
    Stage stage;
    public PantallaPregunta(Stage stage, VistaPartida vistaPartida){
        this.stage = stage;
        this.setPrefSize(1300,720);

        ArrayList<RespuestasJugador> respuestasJugadores = new ArrayList<>();
        RespuestasJugador respuestasJugador= new RespuestasJugador(vistaPartida.partida().jugadorActual());

        Label nombre1 = new Label(vistaPartida.partida().preguntaActual().getEnunciado());

        Button botonTrue = new Button("V");
        Button botonFalse = new Button("F");

        BotonResponderVerdaderoHandler botonResponderVerdaderoHandler = new BotonResponderVerdaderoHandler(respuestasJugador,vistaPartida);
        botonTrue.setOnAction(botonResponderVerdaderoHandler);

        BotonResponderFalsoHandler botonResponderFalsoHandler = new BotonResponderFalsoHandler(respuestasJugador,vistaPartida);
        botonFalse.setOnAction(botonResponderFalsoHandler);

        Label nombreJugador = new Label(vistaPartida.partida().jugadorActual().getNombre()+": "+vistaPartida.partida().jugadorActual().puntos());


        nombre1.relocate(600, 100);
        botonFalse.setPrefSize(500,100);
        botonFalse.relocate(100,400);
        botonTrue.setPrefSize(500,100);
        botonTrue.relocate(700,400);
        nombreJugador.relocate(650, 600);

        this.getChildren().addAll(nombre1,botonFalse,botonTrue,nombreJugador);

    }


}
