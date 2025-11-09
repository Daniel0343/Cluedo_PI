package org.example;

import org.example.Salas.Habitacion;

import java.util.HashMap;
import java.util.Map;

public class DatoGuardado {
    private String nombreJugador;
    private String nombreSalaActual;
    private Map<String, Boolean> habitacionesDescubiertas;

    public DatoGuardado(String nombreJugador, Habitacion salaActual, Habitacion[] todas) {
        this.nombreJugador = nombreJugador;
        this.nombreSalaActual = salaActual.getNombre();
        this.habitacionesDescubiertas = new HashMap<>();

        for (Habitacion h : todas) {
            habitacionesDescubiertas.put(h.getNombre(), h.isDescubierta());
        }
    }

    public Map<String, Boolean> getHabitacionesDescubiertas() {
        return habitacionesDescubiertas;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public String getNombreSalaActual() {
        return nombreSalaActual;
    }
}
