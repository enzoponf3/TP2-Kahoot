package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadDePuntajeTest {

    @Test
    public void testPreguntaVoFConExclusividadPuntua2ParaJugadorQueEligioYAcerto () {
        Jugador jugador1 = new Jugador("");
        Jugador jugador2 = new Jugador("");
        PreguntaVoFClasica preguntaV = PreguntaVoFClasica.crearPreguntaVerdadera("pepegrillo");
        ArrayList<RespuestasJugador> respuestasJugadores = new ArrayList<>();

        preguntaV.usarExclusividad();  //La usa el jugador1

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaV.elegirRespuesta(0));
        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaV.elegirRespuesta(1));

        respuestasJugadores.add( respuestasJugador1);
        respuestasJugadores.add( respuestasJugador2);

        preguntaV.evaluarRespuestas(respuestasJugadores);

        assertEquals(2, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }

    @Test
    public void testPreguntaVoFConDobleExclusividadPuntua4ParaJugadorQueEligioYAcerto () {
        Jugador jugador1 = new Jugador("");
        Jugador jugador2 = new Jugador("");
        PreguntaVoFClasica preguntaV = PreguntaVoFClasica.crearPreguntaVerdadera("pepegrillo");
        ArrayList<RespuestasJugador> respuestasJugadores = new ArrayList<>();

        preguntaV.usarExclusividad();  //La usa el jugador1
        preguntaV.usarExclusividad();  //La usa el jugador2

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaV.elegirRespuesta(0));
        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaV.elegirRespuesta(1));

        respuestasJugadores.add( respuestasJugador1);
        respuestasJugadores.add( respuestasJugador2);

        preguntaV.evaluarRespuestas(respuestasJugadores);

        assertEquals(4, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }

    @Test
    public void testPreguntaMCClasicaConExclusividadPuntua2ParaJugadorQueEligioYAcerto(){
        Jugador jugador1 = new Jugador("");
        Jugador jugador2 = new Jugador("");
        ArrayList<RespuestasJugador> respuestasJugadores = new ArrayList<>();

        Respuesta respuesta1 = new Respuesta("Algo");
        Respuesta respuesta2 = new Respuesta("Algo");
        Respuesta respuesta3 = new Respuesta("Algo");
        Respuesta respuesta4 = new Respuesta("Algo");

        PreguntaChoiceClasica preguntaMCClasica = new PreguntaChoiceClasica("Pregunta");
        preguntaMCClasica.agregarRespuestaCorrecta(respuesta1);
        preguntaMCClasica.agregarRespuestaCorrecta(respuesta2);
        preguntaMCClasica.agregarRespuestaCorrecta(respuesta3);
        preguntaMCClasica.agregarRespuesta(respuesta4);

        preguntaMCClasica.usarExclusividad();  //La usa el jugador1

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(respuesta1);
        respuestasJugador1.agregarRespuesta(respuesta2);
        respuestasJugador1.agregarRespuesta(respuesta3);

        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(respuesta2);
        respuestasJugador2.agregarRespuesta(respuesta4);

        respuestasJugadores.add(respuestasJugador1);
        respuestasJugadores.add(respuestasJugador2);

        preguntaMCClasica.evaluarRespuestas(respuestasJugadores);

        assertEquals(2, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }

    @Test
    public void TestPreguntaMCParcialClasicaConExclusividadPuntua2ParaJugadorQueEligioYAcerto(){
        ArrayList <RespuestasJugador> RespuestasJugadores= new ArrayList<>();
        Jugador jugador1 = new Jugador("");
        Jugador jugador2 = new Jugador("");

        Respuesta respuesta1 = new Respuesta("Algo");
        Respuesta respuesta2 = new Respuesta("Algo");
        Respuesta respuesta3 = new Respuesta("Algo");
        Respuesta respuesta4 = new Respuesta("Algo");

        PreguntaChoiceParcial preguntaMCParcial = new PreguntaChoiceParcial("Pregunta");
        preguntaMCParcial.agregarRespuestaCorrecta(respuesta1);
        preguntaMCParcial.agregarRespuestaCorrecta(respuesta2);
        preguntaMCParcial.agregarRespuestaCorrecta(respuesta3);
        preguntaMCParcial.agregarRespuesta(respuesta4);

        preguntaMCParcial.usarExclusividad();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(respuesta1);
        respuestasJugador1.agregarRespuesta(respuesta2);
        respuestasJugador1.agregarRespuesta(respuesta3);


        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(respuesta2);
        respuestasJugador2.agregarRespuesta(respuesta4);
        respuestasJugador2.agregarRespuesta(respuesta3);

        RespuestasJugadores.add( respuestasJugador1);
        RespuestasJugadores.add( respuestasJugador2);

        preguntaMCParcial.evaluarRespuestas(RespuestasJugadores);

        assertEquals(6, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }

    @Test
    public void TestPreguntaMCOrdererConExclusividadPuntua2ParaJugadorQueEligioYAcerto() {
        ArrayList<RespuestasJugador> respuestasJugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador("");
        Jugador jugador2 = new Jugador("");

        Respuesta respuesta1 = new Respuesta("Algo");
        Respuesta respuesta2 = new Respuesta("Algo");
        Respuesta respuesta3 = new Respuesta("Algo");
        Respuesta respuesta4 = new Respuesta("Algo");

        PreguntaOrdenada preguntaOrdenada = new PreguntaOrdenada("");
        preguntaOrdenada.agregarRespuesta(respuesta1);
        preguntaOrdenada.agregarRespuesta(respuesta2);
        preguntaOrdenada.agregarRespuesta(respuesta3);
        preguntaOrdenada.agregarRespuesta(respuesta4);
        preguntaOrdenada.usarExclusividad();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(respuesta1);
        respuestasJugador1.agregarRespuesta(respuesta2);
        respuestasJugador1.agregarRespuesta(respuesta3);
        respuestasJugador1.agregarRespuesta(respuesta4);

        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(respuesta2);
        respuestasJugador2.agregarRespuesta(respuesta4);

        respuestasJugadores.add(respuestasJugador1);
        respuestasJugadores.add(respuestasJugador2);

        preguntaOrdenada.evaluarRespuestas(respuestasJugadores);

        assertEquals(2, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void TestPreguntaGrupoConExclusividadPuntua2ParaJugadorQueEligioYAcerto() {
        ArrayList<RespuestasJugador> respuestasJugadores= new ArrayList<>();
        Jugador jugador1 = new Jugador("");
        Jugador jugador2 = new Jugador("");

        PreguntaGrupo preguntaGroup = new PreguntaGrupo( "Enunciado pregunta grupo", "en grupo A", "en grupo B");
        preguntaGroup.usarExclusividad();

        Respuesta respuesta1 = new Respuesta("Algo");
        Respuesta respuesta2 = new Respuesta("Algo");
        Respuesta respuesta3 = new Respuesta("Algo");
        Respuesta respuesta4 = new Respuesta("Algo");
        Respuesta respuesta5 = new Respuesta("Algo");

        preguntaGroup.agregarRespuestaGrupoA(respuesta1);
        preguntaGroup.agregarRespuestaGrupoA(respuesta2);
        preguntaGroup.agregarRespuestaGrupoA(respuesta3);
        preguntaGroup.agregarRespuestaGrupoB(respuesta4);
        preguntaGroup.agregarRespuestaGrupoB(respuesta5);

        RespuestasJugador respJugador1GrupoA = new RespuestasJugador(jugador1);
        RespuestasJugador respJugador1GrupoB = new RespuestasJugador(jugador1);

        respJugador1GrupoA.agregarRespuesta(preguntaGroup.elegirRespuesta(0));
        respJugador1GrupoA.agregarRespuesta(preguntaGroup.elegirRespuesta(1));
        respJugador1GrupoA.agregarRespuesta(preguntaGroup.elegirRespuesta(2));

        respJugador1GrupoB.agregarRespuesta(preguntaGroup.elegirRespuesta(3));
        respJugador1GrupoB.agregarRespuesta(preguntaGroup.elegirRespuesta(4));

        RespuestasJugador respJugador2GrupoA = new RespuestasJugador(jugador2);
        RespuestasJugador respJugador2GrupoB = new RespuestasJugador(jugador2);

        respJugador2GrupoA.agregarRespuesta(preguntaGroup.elegirRespuesta(0));
        respJugador2GrupoA.agregarRespuesta(preguntaGroup.elegirRespuesta(1));
        respJugador2GrupoA.agregarRespuesta(preguntaGroup.elegirRespuesta(4));

        respJugador2GrupoB.agregarRespuesta(preguntaGroup.elegirRespuesta(3));
        respJugador2GrupoB.agregarRespuesta(preguntaGroup.elegirRespuesta(2));

        respuestasJugadores.add(respJugador1GrupoA);
        respuestasJugadores.add(respJugador1GrupoB);
        respuestasJugadores.add(respJugador2GrupoA);
        respuestasJugadores.add(respJugador2GrupoB);

        preguntaGroup.evaluarRespuestas(respuestasJugadores);

        assertEquals(2, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }
}
