package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class PantallaFinal extends Pane {
    private Stage stage;
    public PantallaFinal(Stage stage, VistaPartida vistaPartida) {
        this.stage = stage;
        this.setPrefSize(1300,720);

        Text titulo = new Text("Resultado Final");
        Text resultado = new Text("El resultado es un empate!");
        Jugador j1 = vistaPartida.partida().jugadorActual();
        vistaPartida.partida().cambiarJugador();
        Jugador j2 = vistaPartida.partida().jugadorActual();
        if(j1.puntos()<j2.puntos()){resultado.setText("Ganó "+j2.getNombre());}
        if(j2.puntos()<j1.puntos()){resultado.setText("Ganó "+j1.getNombre());}
        Text detalleTitulo = new Text("Puntos");
        Text j1Detalle = new Text(j1.getNombre()+": "+j1.puntos());
        Text j2Detalle = new Text(j2.getNombre()+": "+j2.puntos());

        titulo.relocate(550,50);
        resultado.relocate(550,60);
        detalleTitulo.relocate(450,80);
        j1Detalle.relocate(450,90);
        j2Detalle.relocate(450,100);

        this.getChildren().addAll(titulo,resultado,detalleTitulo,j1Detalle,j2Detalle);


    }
}
