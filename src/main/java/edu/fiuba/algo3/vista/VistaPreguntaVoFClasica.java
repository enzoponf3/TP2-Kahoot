package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.eventos.BotonResponderVoFHandler;
import edu.fiuba.algo3.modelo.PreguntaVoFClasica;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaPreguntaVoFClasica extends Pane {
    Stage stage;
    PreguntaVoFClasica preguntaVoF;

    public VistaPreguntaVoFClasica(Stage stage, VistaPartida vistaPartida){
        this.stage = stage;
        this.setPrefSize(1300,720);
        this.preguntaVoF= (PreguntaVoFClasica) vistaPartida.partida().preguntaActual();

        RespuestasJugador respuestasJugador= new RespuestasJugador(vistaPartida.partida().jugadorActual());

        Label enunciadoPregunta = new Label(vistaPartida.partida().preguntaActual().devolverEnunciado());
        ArrayList<Respuesta> respuestasPregunta=preguntaVoF.devolverRespuestasPosibles();

        Button botonTrue = new Button("V");
        BotonResponderVoFHandler botonVHandler = new BotonResponderVoFHandler(respuestasJugador,respuestasPregunta.get(0),vistaPartida);
        botonTrue.setOnAction(botonVHandler);

        Button botonFalse = new Button("F");
        BotonResponderVoFHandler botonFHandler = new BotonResponderVoFHandler(respuestasJugador,respuestasPregunta.get(1),vistaPartida);
        botonFalse.setOnAction(botonFHandler);

        Button botonExclusividad = new Button("Exlusividad de puntaje");
        botonExclusividad.setOnAction(actionEvent -> {this.preguntaVoF.usarExclusividad(); botonExclusividad.setDisable(true);});

        Label nombreJugador = new Label(vistaPartida.partida().jugadorActual().getNombre()+": "+vistaPartida.partida().jugadorActual().puntos());


        botonExclusividad.setPrefSize(150,100);
        botonExclusividad.relocate(200,100);
        enunciadoPregunta.relocate(600, 100);
        botonFalse.setPrefSize(500,100);
        botonFalse.relocate(100,400);
        botonTrue.setPrefSize(500,100);
        botonTrue.relocate(700,400);
        nombreJugador.relocate(650, 600);

        this.getChildren().addAll(enunciadoPregunta,botonFalse,botonTrue,nombreJugador,botonExclusividad);

    }


}
