package org.example;

import java.util.ArrayList;

public class Jugador {
    String nombre;
    Habitacion ubicacion;
    ArrayList<Object> inventario;

    public Jugador(String nombre, Habitacion vestibulo){
        this.nombre = nombre;
        this.ubicacion = vestibulo;
    }
}
