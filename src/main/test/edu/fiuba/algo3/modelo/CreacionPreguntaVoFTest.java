package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreacionPreguntaVoFTest {

    @Test
    public void CreacionPreguntaConRespuestaVerdadera(){
        PreguntaVoF2 preguntaV = PreguntaVoF2.crearPreguntaVoFConRespuesta(true);

        assertEquals(true, preguntaV.tipo());
    }

    @Test
    public void CreacionPreguntaFalsa(){
        PreguntaVoF2 preguntaF = PreguntaVoF2.crearPreguntaVoFConRespuesta(false);
        //pregunta1.setTipo(true);

        assertEquals(false, preguntaF.tipo());
    }

    @Test
    public void PreguntaVerdaderaSumaUnPuntoConRespVerdaderaTest(){
        PreguntaVoF2 preguntaV = PreguntaVoF2.crearPreguntaVoFConRespuesta(true);

        boolean respuesta = true;

        assertEquals(1, preguntaV.asignarPuntos(respuesta));

    }

    @Test
    public void PreguntaVerdaderaSumaCeroPuntosConRespFalsaTest(){
        PreguntaVoF2 preguntaV = PreguntaVoF2.crearPreguntaVoFConRespuesta(true);

        boolean respuesta = false;

        assertEquals(0, preguntaV.asignarPuntos(respuesta));

    }

}
