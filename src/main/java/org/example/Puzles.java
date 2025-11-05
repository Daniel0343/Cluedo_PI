package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Puzles {
    public static boolean puzle1(){

        return  true;
    }

    public static boolean puzle2(){
        ArrayList<String> resultado = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            resultado.add("Enrredadera "+i);
        }
        Collections.shuffle(resultado);


        return  true;
    }
}
