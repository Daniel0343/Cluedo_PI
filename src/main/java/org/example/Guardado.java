package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Dialogos.Grabadora;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Guardado {
    public static void guardarPartida(String nombre, String sala, Grabadora grabadora, Inventario inventario) {
        DatoGuardado datoGuardado = new DatoGuardado(nombre, sala);
        guardarDato(datoGuardado);
        guardarGrabadora(grabadora);
        guardarInventario(inventario);
    }

    public static void guardarDato(DatoGuardado datoGuardado) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("guardado/dato.json")) {
            gson.toJson(datoGuardado, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static DatoGuardado leerDato(){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("guardado/grabadora.json")) {
            DatoGuardado datoGuardado = gson.fromJson(reader, DatoGuardado.class);
            return datoGuardado;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void guardarGrabadora(Grabadora grabadora) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("guardado/grabadora.json")) {
            gson.toJson(grabadora, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Grabadora leerGrabadora(){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("guardado/grabadora.json")) {
            Grabadora grabadora = gson.fromJson(reader, Grabadora.class);
            return grabadora;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void guardarInventario(Inventario inventario) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("guardado/inventario.json")) {
            gson.toJson(inventario, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Inventario leerInventario(){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("guardado/inventario.json")) {
            Inventario inventario = gson.fromJson(reader, Inventario.class);
            return inventario;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
