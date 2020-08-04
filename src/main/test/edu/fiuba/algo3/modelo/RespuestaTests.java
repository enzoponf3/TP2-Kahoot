package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaTests {
    @Test
    public void testRespuestaCreadaPuntuaConCero(){
        Respuesta respuesta = new Respuesta();
        //   assertEquals(0, respuesta.puntuar());
    }

    @Test
    public void testRespuestaComoRespuestaAcertadaPuntuaConUno(){
        Respuesta respuesta = new Respuesta();
        respuesta.establecerComoRespuestaAcertada();
        // assertEquals(1,respuesta.puntuar());
    }

}
