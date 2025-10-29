package org.example.Personajes;

import org.example.Dialogos.Dialogos;
import org.example.Objetos.Tipo;

public class Personaje {
    private String nombre;
    private String dialogo;

    public Personaje(String nombre, String dialogo) {
        this.nombre = nombre;
        this.dialogo = Dialogos.getDialogos().stream().filter(s -> s.getNombre().equals(nombre)).findFirst().get().getDialogo();
    }
}
