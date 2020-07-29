package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreacionPreguntaVoFPenalTest {

    @Test
    public void TestPreguntaVerdaderaPenalSuma1PuntoConRespuestaVerdadera(){
        PreguntaVoFPenal pregunta1 = PreguntaVoFPenal.crearPreguntaVerdadera();
        int puntos = pregunta1.responderVerdadero();
        assertEquals(1, puntos);
    }

    @Test
    public void TestPreguntaVerdaderaPenalResta1PuntoConRespuestaVerdadera(){
        PreguntaVoFPenal pregunta1 = PreguntaVoFPenal.crearPreguntaVerdadera();
        int puntos = pregunta1.responderFalsa();
        assertEquals(-1, puntos);
    }

}
