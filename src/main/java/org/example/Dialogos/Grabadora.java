package org.example.Dialogos;

import java.util.ArrayList;

public class Grabadora {
    ArrayList<String> dialogos = new ArrayList<>();

    public Grabadora() {
        dialogos = new ArrayList<>();
    }

    public ArrayList<String> getDialogos() {
        return dialogos;
    }

    public void addDialogo(String dialogo){
        if (!dialogos.contains(dialogo)){
            dialogos.add(dialogo);
        }

    }






}
