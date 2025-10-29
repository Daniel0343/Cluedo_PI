package org.example;

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
}
