package edu.fiuba.algo3.modelo;

import com.google.gson.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Stack;

public class PreguntasJuego {
    private final ArrayList<Pregunta> listaPreguntas;

    public PreguntasJuego(){
        this.listaPreguntas = new ArrayList<>();
    }

    public void add(Pregunta pregunta) {
        listaPreguntas.add(pregunta);
    }

    public Stack<Pregunta> preguntasToStack(){
        Stack<Pregunta> preguntasStack = new Stack<>();
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
        jsonObjectPreguntasJuego.add("Preguntas", jsonArrayPreguntas);
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

        JsonArray listaPreguntas = jsonObjectPreguntasJuego.getAsJsonArray("Preguntas");
        for (JsonElement jsonPregunta : listaPreguntas) {
            String nombreTipo = jsonPregunta.getAsJsonObject().get("Tipo").getAsString();
            switch (nombreTipo) {
                case ("PreguntaVoFClasica") :
                    if (jsonPregunta.getAsJsonObject().get("verdad").getAsBoolean()){
                        PreguntaVoFClasica pregunta = PreguntaVoFClasica.crearPreguntaVerdadera(jsonPregunta.getAsJsonObject().get("enunciado").getAsString());
                        preguntasJuego.add(pregunta);
                    }
                    else{
                        PreguntaVoFClasica pregunta = PreguntaVoFClasica.crearPreguntaFalsa(jsonPregunta.getAsJsonObject().get("enunciado").getAsString());
                        preguntasJuego.add(pregunta);
                    }
                    break;
                case ("PreguntaVoFPenal") :
                    if (jsonPregunta.getAsJsonObject().get("verdad").getAsBoolean()){
                        PreguntaVoFPenal pregunta = PreguntaVoFPenal.crearPreguntaVerdadera(jsonPregunta.getAsJsonObject().get("enunciado").getAsString());
                        preguntasJuego.add(pregunta);
                    }
                    else{
                        PreguntaVoFPenal pregunta = PreguntaVoFPenal.crearPreguntaFalsa(jsonPregunta.getAsJsonObject().get("enunciado").getAsString());
                        preguntasJuego.add(pregunta);
                    }
                    break;
                case ("PreguntaChoiceClasica") :
                    PreguntaChoiceClasica pregunta2 = PreguntaChoiceClasica.recuperar(jsonPregunta.getAsJsonObject());
                    preguntasJuego.add(pregunta2);
                    break;
                case ("PreguntaChoiceParcial") :
                    PreguntaChoiceParcial pregunta3 = PreguntaChoiceParcial.recuperar(jsonPregunta.getAsJsonObject());
                    preguntasJuego.add(pregunta3);
                    break;
                case ("PreguntaChoicePenal") :
                    PreguntaChoicePenal pregunta4 = PreguntaChoicePenal.recuperar(jsonPregunta.getAsJsonObject());
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
