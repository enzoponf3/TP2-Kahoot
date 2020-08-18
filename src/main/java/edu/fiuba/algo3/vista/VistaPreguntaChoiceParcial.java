package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.eventos.BotonFinalizarTurnoMCHandler;
import edu.fiuba.algo3.eventos.BotonResponderMCHandler;
import edu.fiuba.algo3.modelo.PreguntaChoiceClasica;
import edu.fiuba.algo3.modelo.PreguntaChoiceParcial;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaPreguntaChoiceParcial extends Pane {
    Stage stage;
    PreguntaChoiceParcial preguntaMCParcial;
    public VistaPreguntaChoiceParcial(Stage stage, VistaPartida vistaPartida) {
        this.stage = stage;
        this.setPrefSize(1300,720);
        this.preguntaMCParcial= (PreguntaChoiceParcial) vistaPartida.partida().preguntaActual();

        RespuestasJugador respuestasJugador= new RespuestasJugador(vistaPartida.partida().jugadorActual());

        Label enunciadoPregunta = new Label(vistaPartida.partida().preguntaActual().devolverEnunciado());

        ArrayList<Button> botonesDisponibles= new ArrayList<>();

        for (Respuesta iteradorRespuesta: preguntaMCParcial.devolverRespuestasPosibles()){
            Button botonNuevo = new Button(iteradorRespuesta.devolverEnunciado());
            botonesDisponibles.add(botonNuevo);
            BotonResponderMCHandler botonMCHandler = new BotonResponderMCHandler(respuestasJugador,iteradorRespuesta);
            botonNuevo.setOnAction(botonMCHandler);
        }

        Button botonFinalizarTurno = new Button("Finalizar turno");
        BotonFinalizarTurnoMCHandler botonFinalizarTurnoMCHandler = new BotonFinalizarTurnoMCHandler(respuestasJugador,vistaPartida);
        botonFinalizarTurno.setOnAction(botonFinalizarTurnoMCHandler);

        Button botonExclusividad = new Button("Exlusividad de puntaje");
        botonExclusividad.setOnAction(actionEvent -> {this.preguntaMCParcial.usarExclusividad(); botonExclusividad.setDisable(true);});

        Label nombreJugador = new Label(vistaPartida.partida().jugadorActual().getNombre()+": "+vistaPartida.partida().jugadorActual().puntos());

        enunciadoPregunta.relocate(600, 100);
        nombreJugador.relocate(650, 600);
        botonExclusividad.setPrefSize(150,100);
        botonExclusividad.relocate(200,100);

        botonFinalizarTurno.setPrefSize(150,100);
        botonFinalizarTurno.relocate(100,600);

        /*botonFalse.setPrefSize(500,100);
        botonFalse.relocate(100,400);
        botonTrue.setPrefSize(500,100);
        botonTrue.relocate(700,400);*/


        for (Button botones : botonesDisponibles){
            this.getChildren().add(botones);
        }
        this.getChildren().addAll(enunciadoPregunta,nombreJugador,botonExclusividad,botonFinalizarTurno);

    }

}
