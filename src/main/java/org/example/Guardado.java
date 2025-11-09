package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Dialogos.Grabadora;
import org.example.Salas.Habitacion;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Guardado {

    public static void guardarPartida(String nombreJugador, Habitacion salaActual, Grabadora grabadora, Inventario inventario) {
        DatoGuardado datoGuardado = new DatoGuardado(nombreJugador, salaActual, Habitacion.habitaciones);
        guardarDato(datoGuardado);
        guardarGrabadora(grabadora);
        guardarInventario(inventario);
    }



    public static void guardarDato(DatoGuardado datoGuardado) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File("guardado/dato.json");
        file.getParentFile().mkdirs();
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(datoGuardado, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DatoGuardado leerDato() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("guardado/dato.json")) {
            return gson.fromJson(reader, DatoGuardado.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Habitacion reconstruirSala(String nombreSala) {
        Habitacion.crearInfo();
        return Arrays.stream(Habitacion.habitaciones)
                .filter(h -> h.getNombre().equals(nombreSala))
                .findFirst()
                .orElse(Habitacion.habitaciones[0]);
    }

    public static void guardarGrabadora(Grabadora grabadora) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File("guardado/grabadora.json");
        file.getParentFile().mkdirs();
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(grabadora, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Grabadora leerGrabadora() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("guardado/grabadora.json")) {
            return gson.fromJson(reader, Grabadora.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void guardarInventario(Inventario inventario) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File("guardado/inventario.json");
        file.getParentFile().mkdirs();
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(inventario, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Inventario leerInventario() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("guardado/inventario.json")) {
            return gson.fromJson(reader, Inventario.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
