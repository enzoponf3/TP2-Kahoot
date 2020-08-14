package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.imagenes.VistaPartida;
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
        int j1 = vistaPartida.partida().jugadorActual().puntos();
        vistaPartida.partida().cambiarJugador();
        int j2 = vistaPartida.partida().jugadorActual().puntos();
        if(j1<j2){resultado.setText("Ganó {jugador2}");}
        if(j2<j1){resultado.setText("Ganó {jugador1}");}
        Text detalleTitulo = new Text("Puntos");
        Text j1Detalle = new Text("{Jugador1}: "+j1);
        Text j2Detalle = new Text("{Jugador2}: "+j2);

        titulo.relocate(550,50);
        resultado.relocate(550,60);
        detalleTitulo.relocate(450,80);
        j1Detalle.relocate(450,90);
        j2Detalle.relocate(450,100);

        this.getChildren().addAll(titulo,resultado,detalleTitulo,j1Detalle,j2Detalle);


    }
}
