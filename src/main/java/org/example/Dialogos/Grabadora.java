package org.example.Dialogos;

import java.util.ArrayList;

public class Grabadora {
    ArrayList<Dialogo> dialogos;

    public Grabadora() {
        dialogos = new ArrayList<>();
    }

    public ArrayList<Dialogo> getDialogos() {
        return dialogos;
    }

    public void addDialogo(Dialogo dialogo){
        dialogos.add(dialogo);
    }

    public Dialogo buscarDialogo(String nombre){
        return  dialogos.stream().filter(d -> d.getNombre().equals(nombre)).findFirst().orElse(null);
    }
}
