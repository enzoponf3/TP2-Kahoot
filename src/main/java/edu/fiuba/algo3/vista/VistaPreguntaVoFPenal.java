package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.eventos.BotonResponderVoFHandler;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaPreguntaVoFPenal extends Pane {
    Stage stage;
    PreguntaVoFPenal preguntaVoF;

    public VistaPreguntaVoFPenal(Stage stage, VistaPartida vistaPartida) {
        this.stage = stage;
        this.setPrefSize(1300, 720);
        this.preguntaVoF = (PreguntaVoFPenal) vistaPartida.partida().preguntaActual();


        RespuestasJugador respuestasJugador = new RespuestasJugador(vistaPartida.partida().jugadorActual());
        MultiplicadorDoble mulX2 = new MultiplicadorDoble();
        MultiplicadorTriple mulX3 = new MultiplicadorTriple();

        Label enunciadoPregunta = new Label(vistaPartida.partida().preguntaActual().devolverEnunciado());
        ArrayList<Respuesta> respuestasPregunta = preguntaVoF.devolverRespuestasPosibles();

        Button botonTrue = new Button("V");
        BotonResponderVoFHandler botonVHandler = new BotonResponderVoFHandler(respuestasJugador, respuestasPregunta.get(0), vistaPartida);
        botonTrue.setOnAction(botonVHandler);

        Button botonFalse = new Button("F");
        BotonResponderVoFHandler botonFHandler = new BotonResponderVoFHandler(respuestasJugador, respuestasPregunta.get(1), vistaPartida);
        botonFalse.setOnAction(botonFHandler);

        Button botonMulX2 = new Button("Mutiplicador X2");
        Button botonMulX3 = new Button("Mutiplicador X3");

        botonMulX2.setOnAction(actionEvent -> {
            mulX2.activarMultiplicadorPara(vistaPartida.partida().jugadorActual());
            botonMulX2.setDisable(true);
            botonMulX3.setDisable(true);
        });


        botonMulX3.setOnAction(actionEvent -> {
            mulX3.activarMultiplicadorPara(vistaPartida.partida().jugadorActual());
            botonMulX3.setDisable(true);
            botonMulX2.setDisable(true);
        });

        Label nombreJugador = new Label(vistaPartida.partida().jugadorActual().getNombre() + ": " + vistaPartida.partida().jugadorActual().puntos());


        botonMulX2.setPrefSize(150, 100);
        botonMulX2.relocate(1000, 50);
        botonMulX3.setPrefSize(150, 100);
        botonMulX3.relocate(1000, 175);

        enunciadoPregunta.relocate(600, 100);
        nombreJugador.relocate(650, 600);

        botonFalse.setPrefSize(500, 100);
        botonFalse.relocate(100, 400);
        botonTrue.setPrefSize(500, 100);
        botonTrue.relocate(700, 400);

        this.getChildren().addAll(enunciadoPregunta, botonFalse, botonTrue, nombreJugador, botonMulX2, botonMulX3);

    }
}
