package edu.fiuba.algo3.modelo.NoUse;

import edu.fiuba.algo3.modelo.PreguntaChoiceClasica;
import edu.fiuba.algo3.modelo.PreguntaOrdenada;
import edu.fiuba.algo3.modelo.RespuestasJugador;
import edu.fiuba.algo3.vista.VistaPartida;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaPreguntaOrdenadaDradNDrop extends Pane {
    Stage stage;
    PreguntaOrdenada preguntaOrdenada;
    TextField sourceFld1;
    TextField sourceFld2;
    TextField targetFld;

    public VistaPreguntaOrdenadaDradNDrop(Stage stage, VistaPartida vistaPartida){
        this.stage = stage;
        this.setPrefSize(1300,720);
        this.preguntaOrdenada= (PreguntaOrdenada) vistaPartida.partida().preguntaActual();

        ArrayList<RespuestasJugador> respuestasJugadores = new ArrayList<>();
        RespuestasJugador respuestasJugador= new RespuestasJugador(vistaPartida.partida().jugadorActual());

        Label enunciadoPregunta = new Label(vistaPartida.partida().preguntaActual().devolverEnunciado());

        ArrayList<Button> botonesDisponibles= new ArrayList<>();

        this.sourceFld1 = new TextField("This is the Source Text");
        this.sourceFld2 = new TextField("This is the Source Text 2");
        this.targetFld = new TextField("Drag and drop the source text here");

        this.sourceFld1.setPrefSize(200, 20);
        this.sourceFld2.setPrefSize(200, 20);
        this.targetFld.setPrefSize(200, 20);
        this.sourceFld1.relocate(100,400);
        this.sourceFld2.relocate(100,100);
        this.targetFld.relocate(700,400);


        sourceFld1.setOnMousePressed(event -> {
            sourceFld1.setMouseTransparent(true);
            event.setDragDetect(true);
        });

        sourceFld2.setOnMousePressed(event -> {
            sourceFld2.setMouseTransparent(true);
            event.setDragDetect(true);
        });

        sourceFld1.setOnMouseReleased(event -> sourceFld1.setMouseTransparent(false));

        sourceFld1.setOnMouseDragged(event -> event.setDragDetect(false));
        sourceFld2.setOnMouseDragged(event -> event.setDragDetect(false));

        sourceFld1.setOnDragDetected(this::dragDetected);
        sourceFld2.setOnDragDetected(this::dragDetected);

        targetFld.setOnDragOver(this::dragOver);

        targetFld.setOnDragDropped(this::dragDropped);

        sourceFld1.setOnDragDone(this::dragDone);

        this.getChildren().addAll(enunciadoPregunta,sourceFld1,targetFld,sourceFld2);


    }

    private void dragDone(DragEvent event)
    {
        // Check how data was transfered to the target. If it was moved, clear the text in the source.
        TransferMode modeUsed = event.getTransferMode();

        if (modeUsed == TransferMode.MOVE)
        {
            sourceFld1.setText("");
        }

        event.consume();
    }

    private void dragDropped(DragEvent event)
    {
        // Transfer the data to the target
        Dragboard dragboard = event.getDragboard();

        if (dragboard.hasString())
        {
            targetFld.setText(dragboard.getString());

            // Data transfer is successful
            event.setDropCompleted(true);
        }
        else
        {
            // Data transfer is not successful
            event.setDropCompleted(false);
        }

        event.consume();
    }



    private void dragOver(DragEvent event)
    {
        // If drag board has a string, let the event know that
        // the target accepts copy and move transfer modes
        Dragboard dragboard = event.getDragboard();

        if (dragboard.hasString())
        {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

        event.consume();
    }

    private void dragDetected(MouseEvent event)
    {
        // User can drag only when there is text in the source field
        String sourceText = this.sourceFld1.getText();

        if (sourceText == null || sourceText.trim().equals(""))
        {
            event.consume();
            return;
        }

        // Initiate a drag-and-drop gesture
        Dragboard dragboard = this.sourceFld1.startDragAndDrop(TransferMode.COPY_OR_MOVE);

        // Add the source text to the Dragboard
        ClipboardContent content = new ClipboardContent();
        content.putString(sourceText);
        dragboard.setContent(content);
        event.consume();
    }
}
