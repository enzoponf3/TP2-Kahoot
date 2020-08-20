package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.eventos.BotonFinalizarTurnoMCHandler;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class VistaPreguntaMCClasica extends Pane {
    Stage stage;
    PreguntaChoiceClasica preguntaMCClasica;
    public VistaPreguntaMCClasica(Stage stage, VistaPartida vistaPartida) {
        this.stage = stage;
        this.setPrefSize(1300,720);
        this.preguntaMCClasica= (PreguntaChoiceClasica) vistaPartida.partida().preguntaActual();

        Stack<Button> botonesDeshabilitados = new Stack();

        RespuestasJugador respuestasJugador= new RespuestasJugador(vistaPartida.partida().jugadorActual());

        Label enunciadoPregunta = new Label(vistaPartida.partida().preguntaActual().devolverEnunciado());

        ArrayList<Button> botonesDisponibles= new ArrayList<>();

        for (Respuesta iteradorRespuesta: preguntaMCClasica.devolverRespuestasPosibles()){
            Button botonNuevo = new Button(iteradorRespuesta.devolverEnunciado());
            botonesDisponibles.add(botonNuevo);
            botonNuevo.setOnAction(actionEvent -> {
                respuestasJugador.agregarRespuesta(iteradorRespuesta);
                botonNuevo.setDisable(true);
                botonesDeshabilitados.push(botonNuevo);
                }
            );
        }

        Button botonFinalizarTurno = new Button("Finalizar turno");
        BotonFinalizarTurnoMCHandler botonFinalizarTurnoMCHandler = new BotonFinalizarTurnoMCHandler(respuestasJugador,vistaPartida);
        botonFinalizarTurno.setOnAction(botonFinalizarTurnoMCHandler);

        Button botonDeshacer = new Button ("Deshacer");
        botonDeshacer.setOnAction(actionEvent -> {
            respuestasJugador.sacarUltimaRespuesta();
            var boton=botonesDeshabilitados.pop();
            boton.setDisable(false);
            }
        );

        Button botonExclusividad = new Button("Exlusividad de puntaje");
        botonExclusividad.setOnAction(actionEvent -> {this.preguntaMCClasica.usarExclusividad(); botonExclusividad.setDisable(true);});

        Label nombreJugador = new Label(vistaPartida.partida().jugadorActual().getNombre()+": "+vistaPartida.partida().jugadorActual().puntos());

        enunciadoPregunta.relocate(600, 100);
        nombreJugador.relocate(650, 600);

        botonDeshacer.setPrefSize(150,50);

        botonExclusividad.setPrefSize(150,100);
        botonExclusividad.relocate(1000,50);

        botonFinalizarTurno.setPrefSize(150,100);
        botonFinalizarTurno.relocate(825,50);

        AtomicInteger posicionX= new AtomicInteger(-225);
        AtomicInteger posicionY=new AtomicInteger(400);
        for (Button botones : botonesDisponibles){
            botones.setPrefSize(200,100);
            botones.relocate(posicionX.addAndGet(250),posicionY.get());
            this.getChildren().add(botones);
        }

        this.getChildren().addAll(enunciadoPregunta,nombreJugador,botonExclusividad,botonFinalizarTurno,botonDeshacer);

    }

}
