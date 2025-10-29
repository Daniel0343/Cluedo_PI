package org.example.Objetos;

import org.example.Salas.Sala;

public class Objeto extends Items{

    private Sala posicion;

    public Objeto(String nombre, Sala posicion) {
        super(nombre);
        this.posicion = posicion;
    }
}
