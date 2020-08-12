package edu.fiuba.algo3.modelo;

public class EvaluadorMCParcial implements Evaluador {
        private final Jugador jugador;
        private Puntaje puntaje;

        public EvaluadorMCParcial(Jugador jugador) {
            this.puntaje = new Puntaje();
            this.jugador=jugador;
        }

        public void acierto() { this.puntaje.sumarPunto(); }

        public void fallido() {this.puntaje = new PuntajeNulo();}

    @Override
        public void sumarPuntosParciales() {
        }

        @Override
        public Puntaje puntaje() {
                return this.puntaje;
        }

        @Override
        public Jugador jugador() {
                return this.jugador;
        }
}
