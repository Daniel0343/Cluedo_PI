package org.example.Objetos;

import org.example.Dialogos.Dialogos;

public class Arma extends Objeto {
    private String dialogo;
    private String dialogo_lupa;

    public Arma(String nombre) {
        super(nombre);
        dialogo = Dialogos.getDialogos().stream().filter(d -> d.getNombre().equals(nombre)).findFirst().get().getDialogo();
        dialogo_lupa = Dialogos.getDialogos().stream().filter(d -> d.getNombre().equals(nombre)).findFirst().get().getDialogo_lupa();

    }

    public String getDialogo() {
        return dialogo;
    }
    public String getDialogo_lupa() {return dialogo_lupa;}
}
