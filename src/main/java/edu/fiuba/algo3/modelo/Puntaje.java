package edu.fiuba.algo3.modelo;

public class Puntaje {
    private int valor;

    public Puntaje(){this.valor=0;}

    public int darPuntosTests(){
        return this.valor;
    }

    protected int darPuntos(){
        return this.valor;
    }

    public void sumar(Puntaje puntaje){
        this.valor+= puntaje.darPuntos();
    }

    public void sumarPunto() {
        this.valor ++;
    }

    public void restarPunto() { this.valor--; }

    public void duplicar() {
        this.valor = this.valor*2;
    }
    public void triplicar(){
        this.valor = this.valor*3;
    }

    public boolean esMenor(Puntaje unPuntaje){
        if(this.darPuntos()<unPuntaje.darPuntos()) {
            return true;
        }
        return false;
    }
}
