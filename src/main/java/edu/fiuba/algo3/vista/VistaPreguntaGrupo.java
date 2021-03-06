package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.eventos.BotonResponderGrupoHandler;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class VistaPreguntaGrupo extends Pane {
    Stage stage;
    PreguntaGrupo preguntaGrupo;
    public VistaPreguntaGrupo(Stage stage, VistaPartida vistaPartida) {
        this.stage = stage;
        this.setPrefSize(1300,720);
        this.preguntaGrupo= (PreguntaGrupo) vistaPartida.partida().preguntaActual();

        ArrayList<Button> botonesDisponibles= new ArrayList<>();

        ArrayList<BotonResponderGrupoHandler> handlersDisponibles = new ArrayList<>();

        RespuestasJugador respuestasJugadorGrupoA= new RespuestasJugador(vistaPartida.partida().jugadorActual());
        RespuestasJugador respuestasJugadorGrupoB= new RespuestasJugador(vistaPartida.partida().jugadorActual());

        Label enunciadoPregunta = new Label(vistaPartida.partida().preguntaActual().devolverEnunciado());

        ToggleGroup botonesGrupo = new ToggleGroup();

        ToggleButton botonElegirGrupoA = new ToggleButton(((PreguntaGrupo) vistaPartida.partida().preguntaActual()).devolverEnunciadoGrupoA());
        ToggleButton botonElegirGrupoB = new ToggleButton(((PreguntaGrupo) vistaPartida.partida().preguntaActual()).devolverEnunciadoGrupoB());

        botonElegirGrupoA.setToggleGroup(botonesGrupo);
        botonElegirGrupoB.setToggleGroup(botonesGrupo);

        // Grupo A por defecto.
        botonElegirGrupoA.setSelected(true);

        for (Respuesta iteradorRespuesta: preguntaGrupo.devolverRespuestasPosibles()){
            Button botonNuevo = new Button(iteradorRespuesta.devolverEnunciado());
            BotonResponderGrupoHandler botonResponderGrupoHandler = new BotonResponderGrupoHandler(respuestasJugadorGrupoA,iteradorRespuesta,botonNuevo);
            handlersDisponibles.add(botonResponderGrupoHandler);
            botonNuevo.setOnAction(botonResponderGrupoHandler);
            botonesDisponibles.add(botonNuevo);
        }

        botonElegirGrupoB.setOnAction(ActionEvent->{
            for (BotonResponderGrupoHandler handlers: handlersDisponibles){
                handlers.modificarGrupo(respuestasJugadorGrupoB);
            }
        });

        botonElegirGrupoA.setOnAction(ActionEvent->{
            for (BotonResponderGrupoHandler handlers: handlersDisponibles){
                handlers.modificarGrupo(respuestasJugadorGrupoA);
            }
        });

        Button botonFinalizarTurno = new Button("Finalizar turno");
        botonFinalizarTurno.setOnAction(actionEvent -> {
                    vistaPartida.agregarRespuestaAJugadorActual(respuestasJugadorGrupoA);
                    vistaPartida.agregarRespuestaAJugadorActual(respuestasJugadorGrupoB);
                    vistaPartida.update();
                }
        );

        Button botonDeshacer = new Button ("Limpiar grupos");
        botonDeshacer.setOnAction(actionEvent -> {
                    respuestasJugadorGrupoA.limpiar();
                    respuestasJugadorGrupoB.limpiar();
                    for(Button iteradorBoton : botonesDisponibles){
                        iteradorBoton.setDisable(false);
                    }
                }
        );

        Button botonExclusividad = new Button("Exlusividad de puntaje");
        botonExclusividad.setOnAction(actionEvent -> {this.preguntaGrupo.usarExclusividad(); botonExclusividad.setDisable(true);});

        Label nombreJugador = new Label(vistaPartida.partida().jugadorActual().getNombre()+": "+vistaPartida.partida().jugadorActual().puntos());

        botonElegirGrupoA.setPrefSize(200,100);
        botonElegirGrupoB.setPrefSize(200,100);
        botonElegirGrupoA.relocate(300,100);
        botonElegirGrupoB.relocate(300,250);

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

        this.getChildren().addAll(enunciadoPregunta,nombreJugador,botonExclusividad,botonFinalizarTurno,botonDeshacer,botonElegirGrupoA,botonElegirGrupoB);

    }

}
