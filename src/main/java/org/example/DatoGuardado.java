package org.example;


import org.example.Salas.Habitacion;

public class DatoGuardado {
    private String nombre;

    private Habitacion sala;

    public DatoGuardado(String nombre, Habitacion sala) {
        this.nombre = nombre;

        this.sala = sala;
    }

    public String getNombre() {
        return nombre;
    }



    public Habitacion getSala() {
        return sala;
    }
}
