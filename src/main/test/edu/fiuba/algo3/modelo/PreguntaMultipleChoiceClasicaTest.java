package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceClasicaTest {
    @Test
    public void TestCreacionPreguntaMCClasicaConDosRespuestasCorrectas(){
        PreguntaChoiceClasica pregunta1 = new PreguntaChoiceClasica(4);
        ArrayList <ListaRespuesta> listaRespuestasJugadores= new <ListaRespuesta>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Respuesta resp1 = new Respuesta();
        Respuesta resp2 = new Respuesta();
        Respuesta resp3 = new Respuesta();
        Respuesta resp4 = new Respuesta();

        pregunta1.agregarRespuestaCorrecta(resp1);
        pregunta1.agregarRespuestaCorrecta(resp3);

        assertEquals(2, pregunta1.cantidadRespuestasCorrectas());
    }

    @Test
    public void TestPreguntaMCClasicaSuma1ParaJugadorConTodasCorrectasY0ParaJugadorConUnaIncorrecta(){
        PreguntaChoiceClasica pregunta1 = new PreguntaChoiceClasica(4);
        ArrayList <ListaRespuesta> listaRespuestasJugadores= new <ListaRespuesta>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Respuesta resp1 = new Respuesta();
        Respuesta resp2 = new Respuesta();
        Respuesta resp3 = new Respuesta();
        Respuesta resp4 = new Respuesta();

        pregunta1.agregarRespuestaCorrecta(resp1);
        pregunta1.agregarRespuestaCorrecta(resp3);

        ListaRespuesta listaRespuestasJugador1 = new ListaRespuesta(jugador1);
        listaRespuestasJugador1.agregarRespuesta(resp1);
        listaRespuestasJugador1.agregarRespuesta(resp2);
        listaRespuestasJugador1.agregarRespuesta(resp3);

        ListaRespuesta listaRespuestasJugador2 = new ListaRespuesta(jugador2);
        listaRespuestasJugador2.agregarRespuesta(resp1);
        listaRespuestasJugador2.agregarRespuesta(resp3);

        listaRespuestasJugadores.add( listaRespuestasJugador1);
        listaRespuestasJugadores.add( listaRespuestasJugador2);

        pregunta1.evaluarRespuesta(listaRespuestasJugadores);

        assertEquals(0, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    //Refactor

    @Test
    public void testPreguntaMcConDosRespuestasCorrectas(){
        PreguntaChoiceClasica pregunta = new PreguntaChoiceClasica(2);
        pregunta.agregarRespuestaCorrecta();
        pregunta.agregarRespuestaCorrecta();
        ArrayList<Integer> respuestas = new ArrayList<>(){{
            add(0);
            add(1);
        }};
        assertEquals(1,pregunta.puntuarRespuestas(respuestas));
    }
    @Test
    public void testPreguntaMcConUnaRespuestaCorrectaOtraIncorrectaPuntua0(){
        PreguntaChoiceClasica pregunta = new PreguntaChoiceClasica(2);
        pregunta.agregarRespuestaCorrecta();
        pregunta.agregarRespuestaIncorrecta();
        ArrayList<Integer> respuestas = new ArrayList<>(){{
            add(0);
            add(1);
        }};
        assertEquals(0,pregunta.puntuarRespuestas(respuestas));
    }
    @Test
    public void testPreguntaMcConDosRespuestasCorrectasPeroDaUnaRespuestaPuntua0(){
        PreguntaChoiceClasica pregunta = new PreguntaChoiceClasica(2);
        pregunta.agregarRespuestaCorrecta();
        pregunta.agregarRespuestaCorrecta();
        pregunta.agregarRespuestaIncorrecta();
        ArrayList<Integer> respuestas = new ArrayList<>(){{
            add(0);
        }};
        assertEquals(0,pregunta.puntuarRespuestas(respuestas));
    }

    @Test
    public void testJugadorRespondeTodoBienSuma1Punto(){
        PreguntaChoiceClasica pregunta = new PreguntaChoiceClasica(2);
        Jugador jugador = new Jugador();
        pregunta.agregarRespuestaCorrecta();
        pregunta.agregarRespuestaCorrecta();
        ListaRespuesta respuesta = new ListaRespuesta(jugador);
        respuesta.agregarRespuesta(0);
        respuesta.agregarRespuesta(1);
        ArrayList<ListaRespuesta> listaRespuestas = new ArrayList<>();
        listaRespuestas.add(respuesta);
        pregunta.puntuarJugadores(listaRespuestas);

        assertEquals(1,jugador.darPuntos());
    }

    @Test
    public void testJugadorResponde1De2BienNoSuma(){
        PreguntaChoiceClasica pregunta = new PreguntaChoiceClasica(2);
        Jugador jugador = new Jugador();
        pregunta.agregarRespuestaCorrecta();
        pregunta.agregarRespuestaCorrecta();
        ListaRespuesta respuesta = new ListaRespuesta(jugador);
        respuesta.agregarRespuesta(0);
        ArrayList<ListaRespuesta> listaRespuestas = new ArrayList<>();
        listaRespuestas.add(respuesta);
        pregunta.puntuarJugadores(listaRespuestas);

        assertEquals(0,jugador.darPuntos());
    }
    @Test
    public void testJugadorRespondeIncorrectamenteNoSuma(){
        PreguntaChoiceClasica pregunta = new PreguntaChoiceClasica(2);
        Jugador jugador = new Jugador();
        pregunta.agregarRespuestaCorrecta();
        pregunta.agregarRespuestaIncorrecta();
        ListaRespuesta respuesta = new ListaRespuesta(jugador);
        respuesta.agregarRespuesta(0);
        respuesta.agregarRespuesta(1);
        ArrayList<ListaRespuesta> listaRespuestas = new ArrayList<>();
        listaRespuestas.add(respuesta);
        pregunta.puntuarJugadores(listaRespuestas);

        assertEquals(0,jugador.darPuntos());
    }
    @Test
    public void testUnJugadorAciertaYSumaElOtroNo(){
        PreguntaChoiceClasica pregunta = new PreguntaChoiceClasica(2);
        pregunta.agregarRespuestaCorrecta();
        pregunta.agregarRespuestaCorrecta();
        pregunta.agregarRespuestaIncorrecta();
        Jugador jugador = new Jugador();
        ListaRespuesta respuesta = new ListaRespuesta(jugador);
        respuesta.agregarRespuesta(0);
        respuesta.agregarRespuesta(1);
        Jugador jugador2 = new Jugador();
        ListaRespuesta respuesta2 = new ListaRespuesta(jugador2);
        respuesta2.agregarRespuesta(0);
        respuesta2.agregarRespuesta(2);
        ArrayList<ListaRespuesta> listaRespuestas = new ArrayList<>();
        listaRespuestas.add(respuesta);
        listaRespuestas.add(respuesta2);
        pregunta.puntuarJugadores(listaRespuestas);

        assertEquals(1,jugador.darPuntos());
        assertEquals(0,jugador2.darPuntos());
    }

    @Test
    public void testAmbosJugadoresAciertanYSuman(){
        PreguntaChoiceClasica pregunta = new PreguntaChoiceClasica(2);
        pregunta.agregarRespuestaCorrecta();
        pregunta.agregarRespuestaCorrecta();
        pregunta.agregarRespuestaIncorrecta();
        Jugador jugador = new Jugador();
        ListaRespuesta respuesta = new ListaRespuesta(jugador);
        respuesta.agregarRespuesta(0);
        respuesta.agregarRespuesta(1);
        Jugador jugador2 = new Jugador();
        ListaRespuesta respuesta2 = new ListaRespuesta(jugador2);
        respuesta2.agregarRespuesta(0);
        respuesta2.agregarRespuesta(1);
        ArrayList<ListaRespuesta> listaRespuestas = new ArrayList<>();
        listaRespuestas.add(respuesta);
        listaRespuestas.add(respuesta2);
        pregunta.puntuarJugadores(listaRespuestas);

        assertEquals(1,jugador.darPuntos());
        assertEquals(1,jugador2.darPuntos());
    }

    @Test
    public void testAmbosJugadoresRespondenIncorrectamenteNoSuman(){
        PreguntaChoiceClasica pregunta = new PreguntaChoiceClasica(2);
        pregunta.agregarRespuestaCorrecta();
        pregunta.agregarRespuestaCorrecta();
        pregunta.agregarRespuestaIncorrecta();
        Jugador jugador = new Jugador();
        ListaRespuesta respuesta = new ListaRespuesta(jugador);
        respuesta.agregarRespuesta(0);
        respuesta.agregarRespuesta(2);
        Jugador jugador2 = new Jugador();
        ListaRespuesta respuesta2 = new ListaRespuesta(jugador2);
        respuesta2.agregarRespuesta(1);
        respuesta2.agregarRespuesta(2);
        ArrayList<ListaRespuesta> listaRespuestas = new ArrayList<>();
        listaRespuestas.add(respuesta);
        listaRespuestas.add(respuesta2);
        pregunta.puntuarJugadores(listaRespuestas);

        assertEquals(0,jugador.darPuntos());
        assertEquals(0,jugador2.darPuntos());
    }

}


