package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadDePuntajeTest {

    @Test
    public void testPreguntaVoFConExclusividadPuntua2ParaJugadorQueEligioYAcerto () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaVoFClasica preguntaV = PreguntaVoFClasica.crearPreguntaVerdadera();
        ArrayList<RespuestasJugador> respuestasJugadores = new <RespuestasJugador>ArrayList();

        preguntaV.usarExclusividad();  //La usa el jugador1

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaV.ElegirRespuestaVerdadera());
        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaV.ElegirRespuestaFalsa());

        respuestasJugadores.add( respuestasJugador1);
        respuestasJugadores.add( respuestasJugador2);

        preguntaV.evaluarRespuestas(respuestasJugadores);

        assertEquals(2, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }

    @Test
    public void testPreguntaVoFConDobleExclusividadPuntua4ParaJugadorQueEligioYAcerto () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaVoFClasica preguntaV = PreguntaVoFClasica.crearPreguntaVerdadera();
        ArrayList<RespuestasJugador> respuestasJugadores = new <RespuestasJugador>ArrayList();

        preguntaV.usarExclusividad();  //La usa el jugador1
        preguntaV.usarExclusividad();  //La usa el jugador2

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaV.ElegirRespuestaVerdadera());
        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaV.ElegirRespuestaFalsa());

        respuestasJugadores.add( respuestasJugador1);
        respuestasJugadores.add( respuestasJugador2);

        preguntaV.evaluarRespuestas(respuestasJugadores);

        assertEquals(4, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }

    @Test
    public void testPreguntaMCClasicaConExclusividadPuntua2ParaJugadorQueEligioYAcerto(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        ArrayList<RespuestasJugador> respuestasJugadores = new <RespuestasJugador>ArrayList();
        PreguntaChoiceClasica preguntaMCClasica = new PreguntaChoiceClasica(5,3);

        preguntaMCClasica.usarExclusividad();  //La usa el jugador1

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaMCClasica.elegirRespuesta(0));
        respuestasJugador1.agregarRespuesta(preguntaMCClasica.elegirRespuesta(1));
        respuestasJugador1.agregarRespuesta(preguntaMCClasica.elegirRespuesta(2));

        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaMCClasica.elegirRespuesta(1));
        respuestasJugador2.agregarRespuesta(preguntaMCClasica.elegirRespuesta(3));

        respuestasJugadores.add(respuestasJugador1);
        respuestasJugadores.add(respuestasJugador2);

        preguntaMCClasica.evaluarRespuestas(respuestasJugadores);

        assertEquals(2, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }

    @Test
    public void TestPreguntaMCParcialClasicaConExclusividadPuntua2ParaJugadorQueEligioYAcerto(){
        ArrayList <RespuestasJugador> RespuestasJugadores= new <RespuestasJugador>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaChoiceParcial preguntaMCParcial = new PreguntaChoiceParcial(4,3);

        preguntaMCParcial.usarExclusividad();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaMCParcial.elegirRespuesta(0));
        respuestasJugador1.agregarRespuesta(preguntaMCParcial.elegirRespuesta(1));
        respuestasJugador1.agregarRespuesta(preguntaMCParcial.elegirRespuesta(2));


        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaMCParcial.elegirRespuesta(1));
        respuestasJugador2.agregarRespuesta(preguntaMCParcial.elegirRespuesta(3));
        respuestasJugador2.agregarRespuesta(preguntaMCParcial.elegirRespuesta(2));

        RespuestasJugadores.add( respuestasJugador1);
        RespuestasJugadores.add( respuestasJugador2);

        preguntaMCParcial.evaluarRespuestas(RespuestasJugadores);

        assertEquals(6, jugador1.puntos());
        assertEquals(0, jugador2.puntos());

    }

    @Test
    public void TestPreguntaMCOrdererConExclusividadPuntua2ParaJugadorQueEligioYAcerto() {
        ArrayList<RespuestasJugador> respuestasJugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaOrdenada preguntaOrdenada = new PreguntaOrdenada(4);
        preguntaOrdenada.usarExclusividad();

        RespuestasJugador respuestasJugador1 = new RespuestasJugador(jugador1);
        respuestasJugador1.agregarRespuesta(preguntaOrdenada.elegirRespuesta(0));
        respuestasJugador1.agregarRespuesta(preguntaOrdenada.elegirRespuesta(1));
        respuestasJugador1.agregarRespuesta(preguntaOrdenada.elegirRespuesta(2));
        respuestasJugador1.agregarRespuesta(preguntaOrdenada.elegirRespuesta(3));

        RespuestasJugador respuestasJugador2 = new RespuestasJugador(jugador2);
        respuestasJugador2.agregarRespuesta(preguntaOrdenada.elegirRespuesta(1));
        respuestasJugador2.agregarRespuesta(preguntaOrdenada.elegirRespuesta(3));

        respuestasJugadores.add(respuestasJugador1);
        respuestasJugadores.add(respuestasJugador2);

        preguntaOrdenada.evaluarRespuestas(respuestasJugadores);

        assertEquals(2, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void TestPreguntaGrupoConExclusividadPuntua2ParaJugadorQueEligioYAcerto() {
        ArrayList <RespuestasJugadorAgrupable> respuestasJugadores= new <RespuestasJugadorAgrupable>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PreguntaGrupo preguntaGroup = new PreguntaGrupo(3,2);

        preguntaGroup.usarExclusividad();

        RespuestasJugadorAgrupable respuestasJugador1 = new RespuestasJugadorAgrupable(jugador1);
        respuestasJugador1.agregarRespuestaAContenedorA(preguntaGroup.elegirRespuesta(0));
        respuestasJugador1.agregarRespuestaAContenedorA(preguntaGroup.elegirRespuesta(1));
        respuestasJugador1.agregarRespuestaAContenedorA(preguntaGroup.elegirRespuesta(2));
        respuestasJugador1.agregarRespuestaAContenedorB(preguntaGroup.elegirRespuesta(3));
        respuestasJugador1.agregarRespuestaAContenedorB(preguntaGroup.elegirRespuesta(4));

        RespuestasJugadorAgrupable respuestasJugador2 = new RespuestasJugadorAgrupable(jugador2);
        respuestasJugador2.agregarRespuestaAContenedorA(preguntaGroup.elegirRespuesta(1));
        respuestasJugador2.agregarRespuestaAContenedorA(preguntaGroup.elegirRespuesta(3));
        respuestasJugador2.agregarRespuestaAContenedorA(preguntaGroup.elegirRespuesta(4));
        respuestasJugador2.agregarRespuestaAContenedorB(preguntaGroup.elegirRespuesta(0));
        respuestasJugador2.agregarRespuestaAContenedorB(preguntaGroup.elegirRespuesta(2));

        respuestasJugadores.add(respuestasJugador1);
        respuestasJugadores.add(respuestasJugador2);
        preguntaGroup.evaluarRespuestas(respuestasJugadores);

        assertEquals(2, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }
}
