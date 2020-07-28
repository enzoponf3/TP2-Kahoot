package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreacionPreguntaVoFTest {

    @Test
    public void TestPreguntaVerdaderaSumaUnPuntoConRespVerdadera(){
        PreguntaVoF preguntaV = PreguntaVoF.crearPreguntaVerdadera();

        int puntos = preguntaV.responderVerdadero();

        assertEquals(1, puntos);

    }

    @Test
    public void TestPreguntaVerdaderaSumaCeroPuntosConRespFalsa(){
        PreguntaVoF preguntaV = PreguntaVoF.crearPreguntaVerdadera();

        int puntos = preguntaV.responderFalso();

        assertEquals(0, puntos);

    }

    @Test
    public void TestPreguntaFalsaSumaUnPuntoConRespFalsa(){
        PreguntaVoF preguntaF = PreguntaVoF.crearPreguntaFalsa();

        int puntos = preguntaF.responderFalso();

        assertEquals(1, puntos);

    }

    @Test
    public void TestPreguntaFalsaSumaCeroPuntosConRespVerdadera(){
        PreguntaVoF preguntaF = PreguntaVoF.crearPreguntaFalsa();

        int puntos = preguntaF.responderVerdadero();

        assertEquals(0, puntos);

    }
}
