package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidezTests {
    @Test
    public void testAcertadoDevuelvePuntajeUno(){
        Correcta acertado = new Correcta();
        assertEquals(1, acertado.puntuar() );
    }
    @Test
    public void testNoAcertadoDevuelvePuntajeCero(){
        Incorrecta noAcertado = new Incorrecta();
        assertEquals(0, noAcertado.puntuar());
    }

    @Test
    public void testNoAcertadoPenalDevuelvePuntajeMenosUno(){
        IncorrectaPenal noAcertadoPenal = new IncorrectaPenal();
        assertEquals(-1, noAcertadoPenal.puntuar());
    }
}
