package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

public class Respuesta {
    private ValidezRespuesta validez;
    private final String enunciado;

    public Respuesta(String enunciado) {
        this.validez = new Incorrecta();
        this.enunciado = enunciado;
    }

    public void establecerComoRespuestaAcertada() {
        this.validez = new Correcta();
    }

    public void evaluarCon(Evaluador evaluador) {
        this.validez.evaluarCon(evaluador);
    }

    public String devolverEnunciado() {
        return this.enunciado;
    }

    public JsonObject guardar() {
        JsonObject jsonRespuesta = new JsonObject();
        jsonRespuesta.addProperty("Respuesta", this.enunciado);
        String validez = "Incorrecta";
        if(this.validez.getClass() == Correcta.class) { validez = "Correcta"; }
        jsonRespuesta.addProperty("Validez", validez);
        return jsonRespuesta;
    }

    public static Respuesta recuperar(JsonObject jsonRespuesta) {
        String enunciado = jsonRespuesta.get("Respuesta").getAsString();
        String validez = jsonRespuesta.get("Validez").getAsString();
        Respuesta respuesta = new Respuesta(enunciado);
        if(validez.equals("Correcta")) { respuesta.establecerComoRespuestaAcertada(); }
        return respuesta;
    }
}
