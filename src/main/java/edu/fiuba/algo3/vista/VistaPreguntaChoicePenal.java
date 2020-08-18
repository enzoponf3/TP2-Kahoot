package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.eventos.BotonFinalizarTurnoMCHandler;
import edu.fiuba.algo3.eventos.BotonResponderMCHandler;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaPreguntaChoicePenal extends Pane {
    Stage stage;
    PreguntaChoicePenal preguntaMCPenal;
    public VistaPreguntaChoicePenal(Stage stage, VistaPartida vistaPartida) {
        this.stage = stage;
        this.setPrefSize(1300,720);
        this.preguntaMCPenal= (PreguntaChoicePenal) vistaPartida.partida().preguntaActual();

        RespuestasJugador respuestasJugador= new RespuestasJugador(vistaPartida.partida().jugadorActual());
        MultiplicadorDoble mulX2 = new MultiplicadorDoble();
        MultiplicadorTriple mulX3 = new MultiplicadorTriple();

        Label enunciadoPregunta = new Label(vistaPartida.partida().preguntaActual().devolverEnunciado());

        ArrayList<Button> botonesDisponibles= new ArrayList<>();

        for (Respuesta iteradorRespuesta: preguntaMCPenal.devolverRespuestasPosibles()){
            Button botonNuevo = new Button(iteradorRespuesta.devolverEnunciado());
            botonesDisponibles.add(botonNuevo);
            BotonResponderMCHandler botonMCHandler = new BotonResponderMCHandler(respuestasJugador,iteradorRespuesta);
            botonNuevo.setOnAction(botonMCHandler);
        }

        Button botonFinalizarTurno = new Button("Finalizar turno");
        BotonFinalizarTurnoMCHandler botonFinalizarTurnoMCHandler = new BotonFinalizarTurnoMCHandler(respuestasJugador,vistaPartida);
        botonFinalizarTurno.setOnAction(botonFinalizarTurnoMCHandler);

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

        Label nombreJugador = new Label(vistaPartida.partida().jugadorActual().getNombre()+": "+vistaPartida.partida().jugadorActual().puntos());

        enunciadoPregunta.relocate(600, 100);
        nombreJugador.relocate(650, 600);

        botonMulX2.setPrefSize(150, 100);
        botonMulX2.relocate(200, 100);
        botonMulX3.setPrefSize(150, 100);
        botonMulX3.relocate(150, 200);

        botonFinalizarTurno.setPrefSize(150,100);
        botonFinalizarTurno.relocate(100,600);

        /*botonFalse.setPrefSize(500,100);
        botonFalse.relocate(100,400);
        botonTrue.setPrefSize(500,100);
        botonTrue.relocate(700,400);*/


        for (Button botones : botonesDisponibles){
            this.getChildren().add(botones);
        }
        this.getChildren().addAll(enunciadoPregunta,nombreJugador,botonFinalizarTurno,botonMulX2,botonMulX3);

    }

}