package edu.fiuba.algo3.modelo;

public class Incorrecta implements ValidezRespuesta {
    public void evaluarCon(Puntuador puntuador) { puntuador.fallido(); }
}
