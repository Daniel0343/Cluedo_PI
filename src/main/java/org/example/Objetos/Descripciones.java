package org.example.Objetos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Descripciones {
    public static ArrayList<Descripcion> getDescripciones() {
        ArrayList<Descripcion> descripciones = new ArrayList<>();
        Gson gson = new Gson();
        Type tipoLista = new TypeToken<ArrayList<Descripcion>>() {}.getType();

        try (FileReader reader = new FileReader("json/descripciones.json")) {
            descripciones = gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return descripciones;
    }

}
