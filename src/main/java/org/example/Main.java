package org.example;

import org.example.Salas.Habitacion;

public class Main {

    // colores ansi para consola
    private static final String RESET   = "\u001B[0m";
    private static final String RED     = "\u001B[31m";
    private static final String GREEN   = "\u001B[32m";
    private static final String YELLOW  = "\u001B[33m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String CYAN    = "\u001B[36m";
    private static final String BOLD    = "\u001B[1m";

    public static void main(String[] args) {

        Habitacion.crearInfo();

        // introducción llamativa
        System.out.println();
        pausa(500);
        System.out.println(CYAN + "╔════════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║" + RESET + "                                                                        " + CYAN + "║" + RESET);
        System.out.println(CYAN + "║" + RESET + "                " + BOLD + YELLOW + "CLUEDO" + RESET + "  " + BOLD + MAGENTA + "· traición en la mansión tudor" + RESET + "                  " + CYAN + "║" + RESET);
        System.out.println(CYAN + "║" + RESET + "                                                                        " + CYAN + "║" + RESET);
        System.out.println(CYAN + "╚════════════════════════════════════════════════════════════════════════╝" + RESET);
        pausa(800);
        System.out.println();
        System.out.println(RED + "    un asesinato. una mansión. secretos que no quieren salir a la luz." + RESET);
        pausa(1500);
        System.out.println(RED + "    el reloj corre. eres el detective. ¿podrás descubrir la verdad?" + RESET);
        pausa(1800);
        System.out.println();
        System.out.println(GREEN + "    → comienza tu investigación..." + RESET);
        pausa(2000);
        System.out.println();

        // escena del apagón inicial
        System.out.println("empieza el juego. sala oscura.");
        pausa(1000);
        boolean apagada = true;
        boolean linterna = false;
        boolean llave = false;

        while (apagada) {
            System.out.println("\nelige una opción:");
            System.out.println("1 - buscar alrededor del escritorio");
            System.out.println("2 - inspeccionar el mueble cercano");
            System.out.println("3 - avanzar hacia el fondo de la sala");

            int opcion = Escaner.entero();
            switch (opcion) {
                case 1:
                    System.out.println("has chocado contra algo, no distingues bien qué es.");
                    if (linterna) {
                        pausa(800);
                        System.out.println("con la linterna ves una llave triangular bajo el escritorio. ¿la coges? (s/n)");
                        String eleccion = Escaner.string();
                        if (eleccion.equalsIgnoreCase("s")) {
                            pausa(600);
                            System.out.println("has recogido la llave triangular.");
                            llave = true;
                        }
                    }
                    break;

                case 2:
                    System.out.println("tocas lo que parece un mueble... abres un cajón y notas algo metálico. ¿lo coges? (s/n)");
                    String eleccion2 = Escaner.string();
                    if (eleccion2.equalsIgnoreCase("s")) {
                        pausa(600);
                        System.out.println("has cogido el objeto: una linterna.");
                        linterna = true;
                    }
                    break;

                case 3:
                    System.out.println("te golpeas con algo grande y frío. no ves qué es.");
                    if (linterna) {
                        pausa(700);
                        System.out.println("con la linterna ves un cuadro de luz cerrado con llave triangular.");
                        if (llave) {
                            pausa(600);
                            System.out.println("¿quieres intentar abrirlo con la llave? (s/n)");
                            String eleccion3 = Escaner.string();
                            if (eleccion3.equalsIgnoreCase("s")) {
                                pausa(700);
                                System.out.println("abres la tapa... dentro hay una palanca. ¿quieres subirla? (s/n)");
                                String eleccion4 = Escaner.string();
                                if (eleccion4.equalsIgnoreCase("s")) {
                                    pausa(1000);
                                    System.out.println(GREEN + "\n💡 las luces se encienden de golpe. la sala brilla. estás en el vestíbulo." + RESET);
                                    apagada = false;
                                }
                            }
                        } else {
                            System.out.println("parece que no tienes la llave adecuada.");
                        }
                    } else {
                        System.out.println("no ves nada. tal vez una linterna ayudaría.");
                    }
                    break;
            }
        }

        // crear jugador y pasar al control por habitaciones
        Jugador j = new Jugador("jugador", Habitacion.habitaciones[0]);
        while (true) {
            j.acciones();
        }
    }

    // pausas dramaticas
    private static void pausa(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}
