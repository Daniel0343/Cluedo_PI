package org.example;

import org.example.Dialogos.Dialogos;
import org.example.Objetos.Descripcion;
import org.example.Objetos.Descripciones;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


        Dialogos.getDialogos().forEach(d -> System.out.println(d.getNombre()+" "+d.getDialogo()+" "+d.getTipo()));
    }
}
