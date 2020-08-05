package edu.fiuba.algo3.modelo;

public class Incorrecta implements ValidezRespuesta {
    public int puntuar(){return 0;}

    public void evaluarCon(Puntuador puntuador) { puntuador.fallido(); }
}
