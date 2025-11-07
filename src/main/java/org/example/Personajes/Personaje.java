package org.example.Personajes;

import org.example.Dialogos.Dialogo;
import org.example.Dialogos.Dialogos;

public class Personaje {
    private String nombre;
    private String dialogo;
    private String dialogo_lupa;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.dialogo = Dialogos.getDialogos().stream().filter(s -> s.getNombre().equals(nombre)).findFirst().get().getDialogo();
        this.dialogo_lupa = Dialogos.getDialogos().stream().filter(s -> s.getNombre().equals(nombre)).findFirst().get().getDialogo_lupa();
    }

    public String getDialogo() {
        return dialogo;
    }

    public String getDialogo_lupa() {
        return dialogo_lupa;
    }
}
