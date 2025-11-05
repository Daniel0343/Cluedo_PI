package org.example;


public class DatoGuardado {
    private String nombre;
    private int puntos;
    private String sala;

    public DatoGuardado(String nombre, int puntos, String sala) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.sala = sala;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getSala() {
        return sala;
    }
}
