package edu.fiuba.algo3.modelo;

import com.google.gson.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Stack;

public class PreguntasJuego {
    private ArrayList<Pregunta> listaPreguntas;

    public PreguntasJuego(){
        this.listaPreguntas = new ArrayList<Pregunta>();
    }

    public void add(Pregunta pregunta) {
        listaPreguntas.add(pregunta);
    }

    public Stack<Pregunta> preguntasToStack(){
        Stack<Pregunta> preguntasStack = new Stack<Pregunta>();
        for (Pregunta p: listaPreguntas) {
            preguntasStack.push(p);
        }
        return preguntasStack;
    }

    public JsonObject guardar() {
        JsonObject jsonObjectPreguntasJuego = new JsonObject();

        JsonArray jsonArrayPreguntas = new JsonArray();
        for (Pregunta pregunta : this.listaPreguntas) {
            jsonArrayPreguntas.add(pregunta.guardar());
        }
        jsonObjectPreguntasJuego.add("preguntas", jsonArrayPreguntas);
        //jsonObjectPreguntasJuego.addProperty();

        return jsonObjectPreguntasJuego;
    }

    public void guardar(String archivo) throws IOException{
        Gson gson = new Gson();

        String json = gson.toJson(this.guardar());

        FileWriter writer = new FileWriter(archivo);
        writer.write(json);
        writer.close();
    }

    public static PreguntasJuego recuperar(JsonObject jsonObjectPreguntasJuego) throws IOException {
        PreguntasJuego preguntasJuego = new PreguntasJuego();

        JsonArray listaPreguntas = jsonObjectPreguntasJuego.getAsJsonArray("preguntas");
        for (JsonElement jsonPregunta : listaPreguntas) {
            String nombreTipo = jsonPregunta.getAsJsonObject().get("nombreTipo").getAsString();
            switch (nombreTipo) {
                case ("PreguntaVoFClasica") :
                    if (jsonPregunta.getAsJsonObject().get("verdad").getAsBoolean()){
                        PreguntaVoFClasica pregunta = PreguntaVoFClasica.crearPreguntaVerdadera(
                        jsonPregunta.getAsJsonObject().get("enunciado").getAsString());
                        preguntasJuego.add(pregunta);
                    }
                    else{
                        PreguntaVoFClasica pregunta = PreguntaVoFClasica.crearPreguntaFalsa();
                        preguntasJuego.add(pregunta);
                    }
                    break;
                case ("PreguntaVoFPenal") :
                    if (jsonPregunta.getAsJsonObject().get("verdad").getAsBoolean()){
                        PreguntaVoFPenal pregunta = PreguntaVoFPenal.crearPreguntaVerdadera();
                        preguntasJuego.add(pregunta);
                    }
                    else{
                        PreguntaVoFPenal pregunta = PreguntaVoFPenal.crearPreguntaFalsa();
                        preguntasJuego.add(pregunta);
                    }
                    break;
                case ("PreguntaChoiceClasica") :
                    PreguntaChoiceClasica pregunta2 = new PreguntaChoiceClasica(3,2);
                    preguntasJuego.add(pregunta2);
                    break;
                case ("PreguntaChoiceParcial") :
                    PreguntaChoiceParcial pregunta3 = new PreguntaChoiceParcial(3,2);
                    preguntasJuego.add(pregunta3);
                    break;
                case ("PreguntaChoicePenal") :
                    PreguntaChoicePenal pregunta4 = new PreguntaChoicePenal(3,2);
                    preguntasJuego.add(pregunta4);
                    break;
                case ("PreguntaGrupo") :
                    PreguntaGrupo pregunta5 = new PreguntaGrupo(3,2);
                    preguntasJuego.add(pregunta5);
                    break;
                case ("PreguntaOrdernada") :
                    PreguntaOrdenada pregunta6 = new PreguntaOrdenada(5);
                    preguntasJuego.add(pregunta6);
                    break;
            }
        }
        return preguntasJuego;
    }

    public static PreguntasJuego recuperar(String archivo) throws IOException{
        String texto = Files.readString(Path.of(archivo));

        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        return recuperar(jsonObject);
    }
}
