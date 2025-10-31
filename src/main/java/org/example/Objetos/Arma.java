package org.example.Objetos;

import org.example.Dialogos.Dialogos;

public class Arma extends Objeto {
    private String dialogo;

    public Arma(String nombre) {
        super(nombre);
        dialogo = Dialogos.getDialogos().stream().filter(d -> d.getNombre().equals(nombre)).findFirst().get().getDialogo();
    }

    public String getDialogo() {
        return dialogo;
    }
}
