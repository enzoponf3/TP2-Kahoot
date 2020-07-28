package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidezTests {
    @Test
    public void testAcertadoDevuelvePuntajeUno(){
        Acertado acertado = new Acertado();
        assertEquals(1, acertado.puntuar() );
    }
    @Test
    public void testNoAcertadoDevuelvePuntajeCero(){
        NoAcertado noAcertado = new NoAcertado();
        assertEquals(0, noAcertado.puntuar());
    }
}
