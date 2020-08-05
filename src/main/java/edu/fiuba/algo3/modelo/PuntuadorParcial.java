package edu.fiuba.algo3.modelo;

public class PuntuadorParcial implements Puntuador {

        private Puntaje puntaje;

        public PuntuadorParcial() {
            this.puntaje = new Puntaje();
        }

        public void acierto() { this.puntaje.sumarPunto(); }

        public void fallido() {this.puntaje = new PuntajeNulo();}

        public void puntuar(Jugador jugador) { jugador.puntuar(this.puntaje); }
}
