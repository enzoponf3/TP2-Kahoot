package edu.fiuba.algo3.vista.imagenes;

import edu.fiuba.algo3.modelo.Partida;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class VistaPartida {

    private final Partida partida;

    public VistaPartida(Partida partida) {
        this.partida = partida;
    }

    public void dibujar() {
        this.dibujarTablero();
    }

    private void dibujarTablero() {
        this.clean();
    }

    public void clean() {
    }

    public void update() {
        this.dibujar();
    }

}
