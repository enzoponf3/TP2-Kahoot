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

    /*public PreguntasJuego recuperar(JsonObject jsonObjectPreguntasJuego) {
        PreguntasJuego preguntasJuego = new PreguntasJuego();
        /*
        JsonArray listaPreguntas = jsonObjectPreguntasJuego.getAsJsonArray("preguntas");
        for (JsonElement jsonPregunta : listaPreguntas) {

            Pregunta pregunta = Pregunta.recuperar(jsonPregunta.getAsJsonObject());
            preguntasJuego.add(pregunta);
        }
        return preguntasJuego;
    }

    public static PreguntasJuego recuperar(String archivo) throws IOException{
        String texto = Files.readString(Path.of(archivo));

        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        return recuperar(jsonObject);
    }*/
}
