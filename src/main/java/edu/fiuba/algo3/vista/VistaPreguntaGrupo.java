package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class VistaPreguntaGrupo extends Pane {
    Stage stage;
    PreguntaGrupo preguntaGrupo;
    public VistaPreguntaGrupo(Stage stage, VistaPartida vistaPartida) {
        this.stage = stage;
        this.setPrefSize(1300,720);
        this.preguntaGrupo= (PreguntaGrupo) vistaPartida.partida().preguntaActual();

        ArrayList<Button> botonesDeshabilitados = new ArrayList<>();

        AtomicBoolean grupoAElegido = new AtomicBoolean(true);

        RespuestasJugador respuestasJugadorGrupoA= new RespuestasJugador(vistaPartida.partida().jugadorActual());
        RespuestasJugador respuestasJugadorGrupoB= new RespuestasJugador(vistaPartida.partida().jugadorActual());

        Label enunciadoPregunta = new Label(vistaPartida.partida().preguntaActual().devolverEnunciado());

        ArrayList<Button> botonesDisponibles= new ArrayList<>();

        for (Respuesta iteradorRespuesta: preguntaGrupo.devolverRespuestasPosibles()){
            Button botonNuevo = new Button(iteradorRespuesta.devolverEnunciado());
            botonesDisponibles.add(botonNuevo);
            botonNuevo.setOnAction(actionEvent -> {
                        if(grupoAElegido.get()){
                            respuestasJugadorGrupoA.agregarRespuesta(iteradorRespuesta);
                        }
                        else{
                            respuestasJugadorGrupoB.agregarRespuesta(iteradorRespuesta);
                        }
                        botonNuevo.setDisable(true);
                        botonesDeshabilitados.add(botonNuevo);
                    }
            );
            //BotonResponderMCHandler botonMCHandler = new BotonResponderMCHandler(respuestasJugador,iteradorRespuesta);
            //botonNuevo.setOnAction(botonMCHandler);
        }

        Button botonElegirGrupoA = new Button("Elegir grupo A");
        botonElegirGrupoA.setOnAction(actionEvent -> grupoAElegido.set(true));

        Button botonElegirGrupoB = new Button("Elegir grupo B");
        botonElegirGrupoB.setOnAction(actionEvent -> grupoAElegido.set(false));

        Button botonFinalizarTurno = new Button("Finalizar turno");
        botonFinalizarTurno.setOnAction(actionEvent -> {
            vistaPartida.agregarRespuestaAJugadorActual(respuestasJugadorGrupoA);
            vistaPartida.agregarRespuestaAJugadorActual(respuestasJugadorGrupoB);
            vistaPartida.update();
            }
            );

        //BotonFinalizarTurnoMCHandler botonFinalizarTurnoMCHandler = new BotonFinalizarTurnoMCHandler(respuestasJugador,vistaPartida);
        //botonFinalizarTurno.setOnAction(botonFinalizarTurnoMCHandler);

        Button botonDeshacer = new Button ("Limpiar grupos");
        botonDeshacer.setOnAction(actionEvent -> {
                    respuestasJugadorGrupoA.limpiar();
                    respuestasJugadorGrupoB.limpiar();
                    for(Button iteradorBoton : botonesDeshabilitados){
                        iteradorBoton.setDisable(false);
                    }
                }
        );

        Button botonExclusividad = new Button("Exlusividad de puntaje");
        botonExclusividad.setOnAction(actionEvent -> {this.preguntaGrupo.usarExclusividad(); botonExclusividad.setDisable(true);});

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
        this.getChildren().addAll(enunciadoPregunta,nombreJugador,botonExclusividad,botonFinalizarTurno,botonDeshacer);

    }

}
