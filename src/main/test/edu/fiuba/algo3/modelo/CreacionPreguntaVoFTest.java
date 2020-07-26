package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreacionPreguntaVoFTest {

    @Test
    public void TestPreguntaVerdaderaSumaUnPuntoConRespVerdadera(){
        PreguntaVoF3 preguntaV = PreguntaVoF3.crearPreguntaVerdadera();

        int puntos = preguntaV.responderVerdadero();

        assertEquals(1, puntos);

    }

    @Test
    public void TestPreguntaVerdaderaSumaCeroPuntosConRespFalsa(){
        PreguntaVoF3 preguntaV = PreguntaVoF3.crearPreguntaVerdadera();

        int puntos = preguntaV.responderFalso();

        assertEquals(0, puntos);

    }

    @Test
    public void TestPreguntaFalsaSumaUnPuntoConRespFalsa(){
        PreguntaVoF3 preguntaF = PreguntaVoF3.crearPreguntaFalsa();

        int puntos = preguntaF.responderFalso();

        assertEquals(1, puntos);

    }

    @Test
    public void TestPreguntaFalsaSumaCeroPuntosConRespVerdadera(){
        PreguntaVoF3 preguntaF = PreguntaVoF3.crearPreguntaFalsa();

        int puntos = preguntaF.responderVerdadero();

        assertEquals(0, puntos);

    }
}
