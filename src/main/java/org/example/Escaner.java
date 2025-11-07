package org.example;

import org.example.Objetos.Objeto;

import java.util.Scanner;

public class Escaner {
    public static String string(){
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
    public static int entero(){
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public static boolean sn () {

        do {
            System.out.print("(s/n)");
            String eleccion = Escaner.string();
            if (eleccion.equals("n") || eleccion.equals("s")) {
                if (eleccion.equals("s")) {

                    return true;
                }
                return false;
            }
        } while (true);
    }

}
