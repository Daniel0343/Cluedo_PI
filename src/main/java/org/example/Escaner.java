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
        int devuelto;
        String opcion;
        do{
            opcion = scanner.nextLine();
            if(!opcion.matches("\\d+")){
                System.out.print("Introduce un numero: ");
            }
        }while (!opcion.matches("\\d+"));
        devuelto = Integer.parseInt(opcion);
        return devuelto;
    }

    public static boolean sn () {
        String eleccion = "";
        do {
            System.out.print("(s/n)");
            eleccion = Escaner.string();
            if (eleccion.equals("n") || eleccion.equals("s")) {
                if (eleccion.equals("s")) {
                    return true;
                } else {
                    return false;
                }
            }
        } while (!eleccion.matches("s|n"));
        return false;
    }

}
