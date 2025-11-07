package org.example;


public class DatoGuardado {
    private String nombre;

    private String sala;

    public DatoGuardado(String nombre, String sala) {
        this.nombre = nombre;

        this.sala = sala;
    }

    public String getNombre() {
        return nombre;
    }



    public String getSala() {
        return sala;
    }
}
