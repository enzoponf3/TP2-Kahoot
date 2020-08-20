package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntasJuegoTest {
    @Test
    public void testGuardadpDePreguntas() {
        String FILENAME_RELATIVE_PATH = "preguntasFile.json";

        Respuesta respuesta1 = new Respuesta("Algo1");
        Respuesta respuesta2 = new Respuesta("Algo2");
        Respuesta respuesta3 = new Respuesta("Algo3");
        Respuesta respuesta4 = new Respuesta("Algo4");

        PreguntaChoiceClasica preguntaMC = new PreguntaChoiceClasica("¿?clasica");
        preguntaMC.agregarRespuestaCorrecta(respuesta1);
        preguntaMC.agregarRespuestaCorrecta(respuesta2);
        preguntaMC.agregarRespuestaCorrecta(respuesta3);
        preguntaMC.agregarRespuesta(respuesta4);

        Respuesta respuesta5 = new Respuesta("Algo5");
        Respuesta respuesta6 = new Respuesta("Algo6");
        Respuesta respuesta7 = new Respuesta("Algo7");
        Respuesta respuesta8 = new Respuesta("Algo8");

        PreguntaChoiceParcial preguntaMCParcial = new PreguntaChoiceParcial("¿?parcial");
        preguntaMCParcial.agregarRespuestaCorrecta(respuesta5);
        preguntaMCParcial.agregarRespuesta(respuesta6);
        preguntaMCParcial.agregarRespuestaCorrecta(respuesta7);
        preguntaMCParcial.agregarRespuestaCorrecta(respuesta8);

        Respuesta respuesta9 = new Respuesta("Algo");
        Respuesta respuesta10 = new Respuesta("Algo");
        Respuesta respuesta11 = new Respuesta("Algo");
        Respuesta respuesta12 = new Respuesta("Algo");

        PreguntaChoicePenal preguntaMCPenal = new PreguntaChoicePenal("¿?penal");
        preguntaMCPenal.agregarRespuestaCorrecta(respuesta9);
        preguntaMCPenal.agregarRespuestaCorrecta(respuesta10);
        preguntaMCPenal.agregarRespuestaCorrecta(respuesta11);
        preguntaMCPenal.agregarRespuesta(respuesta12);

        //PreguntaVoFClasica preguntaV = PreguntaVoFClasica.crearPreguntaVerdadera("¿?VoF");
        //PreguntaVoFPenal preguntaVPenal = PreguntaVoFPenal.crearPreguntaFalsa("¿?VoFPenal");

        PreguntasJuego preguntas = new PreguntasJuego();
        preguntas.add(preguntaMC);
        preguntas.add(preguntaMCParcial);
        preguntas.add(preguntaMCPenal);
        //preguntas.add(preguntaV);
        //preguntas.add(preguntaVPenal);
        /*try {
            preguntas.guardar(FILENAME_RELATIVE_PATH);
        } catch (IOException ex) {
            System.out.println("Problemas" + ex);
        }*/
    }
}
