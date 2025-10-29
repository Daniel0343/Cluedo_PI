package org.example.Dialogos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Dialogos {
    public static ArrayList<Dialogo> getDialogos() {
        ArrayList<Dialogo> dialogos = new ArrayList<>();
        Gson gson = new Gson();
        Type tipoLista = new TypeToken<ArrayList<Dialogo>>() {}.getType();

        try (FileReader reader = new FileReader("json/dialogos.json")) {
            dialogos = gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dialogos;
    }

}