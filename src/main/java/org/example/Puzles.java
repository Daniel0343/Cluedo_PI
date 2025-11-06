package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Puzles {

    private static final String BOLD    = "\u001B[1m";
    private static final String RESET   = "\u001B[0m";
    private static final String RED     = "\u001B[31m";
    private static final String GREEN   = "\u001B[32m";
    private static final String YELLOW  = "\u001B[33m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String CYAN    = "\u001B[36m";

      public static boolean puzle1(){

          Scanner scanner = new Scanner(System.in);
          String intento = "";
          boolean puzleResuelto = false;

          System.out.println(BOLD + "\n-- PUZZLE BOLAS DEL BILLAR --" + RESET);
          System.out.println("Echando un vistazo al billar que parece bastante viejo te das cuenta que por " +
                  "debajo sobresale una parte del billar.");
          System.out.println("Te acercas y te das cuenta de que es un compartimento que está cerrado con un codigo de 7 cifras.");

          System.out.println(BOLD + "\nHay una nota pegada al compartimento, junto a una hoja de puntuación borrosa:" + RESET);
          System.out.println(GREEN + "---------------------------------------------------------------------" + RESET);
          System.out.println(BOLD + "LA CLAVE DEL COMPARTIMENTO (7 dígitos):" + RESET);
          System.out.print(BOLD + "SECUENCIA DE ENTRADA: " + RESET);
          System.out.print(YELLOW + "4 (S)" + RESET + " - ");
          System.out.print(MAGENTA + "12 (R)" + RESET + " - ");
          System.out.print(CYAN + "8 (N)" + RESET + " - ");
          System.out.print(YELLOW + "6 (S)" + RESET + " - ");
          System.out.print(MAGENTA + "13 (R)" + RESET + " - ");
          System.out.print(YELLOW + "1 (S)" + RESET + " - ");
          System.out.println(MAGENTA + "15 (R)" + RESET);

          System.out.println(BOLD + "\nREGLAS DEL CÓDIGO (Ordenadas 1-7, pero mezcladas en el texto):" + RESET);

          // Las reglas mezcladas
          System.out.println(RED + "7.  El número de la TERCERA bola Sólida que entró. (Posición 7 del Código)" + RESET);
          System.out.println("4.  La BOLA NEGRA que entró. (Posición 4 del Código)");
          System.out.println(RED + "2.  El número de la PRIMERA bola Sólida que entró. (Posición 2 del Código)" + RESET);
          System.out.println("5.  El PRIMER dígito de la SEGUNDA bola Rayada. (Posición 5 del Código)");
          System.out.println(RED + "1.  La SEGUNDA bola Sólida que entró. (Posición 1 del Código)" + RESET);
          System.out.println("3.  El SEGUNDO dígito de la ÚLTIMA bola Rayada. (Posición 3 del Código)");
          System.out.println(RED + "6.  El número de la PRIMERA bola que entró (de toda la secuencia). (Posición 6 del Código)" + RESET);
          System.out.println(GREEN + "---------------------------------------------------------------------" + RESET);


          String solucion = "6458141";

          // --- Bucle de intento y reintento ---
          while (!puzleResuelto) {
              System.out.println("\nIntroduce el código de 7 dígitos o 'SALIR' para volver a la sala:");

              if (scanner.hasNextLine()) {
                  intento = scanner.nextLine();
              }

              if (intento.equalsIgnoreCase("SALIR")) {
                  System.out.println(BOLD + "Has abandonado el puzle por ahora. Puedes volver cuando tengas el código." + RESET);
                  return false;
              }

              if (intento.equals(solucion)) {
                  System.out.println(BOLD + GREEN + "\n¡CLAC! El compartimento se ha abierto. Dentro encuentras una LUPA." + RESET);
                  puzleResuelto = true; // Termina el bucle
              } else {
                  System.out.println(BOLD + RED + "Código incorrecto. Inténtalo de nuevo." + RESET);
              }
          }

          return true; // Devuelve true solo si el puzle fue resuelto
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
