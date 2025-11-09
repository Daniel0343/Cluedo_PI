package org.example;

import org.example.BaseDatos.Puntuacion;
import org.example.BaseDatos.Usuario;
import org.example.Dialogos.Grabadora;
import org.example.Salas.Habitacion;
import org.example.Salas.Invernadero;

import javax.xml.crypto.Data;
import java.io.File;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        Habitacion.crearInfo();
        // crear jugador y pasar al control por habitaciones
        Jugador j = null;
        String contrasena;
        String nombre;
        do {

            System.out.println("-- Iniciar Sesión --");
            System.out.println("Introduce tu nombre de usuario:");
            nombre = scanner.nextLine();
            System.out.println("Introduce tu contraseña: ");
            contrasena = scanner.nextLine();

            if (!Usuario.comprobarUsuario(nombre)) {

                System.out.println("Usuario no registrado. Crea tu cuenta.");
                Usuario.crearUsuario(nombre, contrasena);
                System.out.println("Usuario creado.");
                pausa(1000);

            }

            if (Usuario.validarUsuario(nombre, contrasena)) {
                System.out.println("Usuario valido.");
            }



        } while (!Usuario.validarUsuario(nombre, contrasena));



        String opcion_cargar = "";
        do {
            System.out.println("-- Carga Partida --");
            System.out.println("1. Nueva Partida");
            System.out.println("2. Cargar Partida");
            opcion_cargar = scanner.nextLine();

            switch (opcion_cargar) {

                case "1":

                    System.out.println("Nueva Partida");
                    j = new Jugador(nombre, Habitacion.habitaciones[0]);
                    break;


                case "2":

                    File fichero = new File("guardado");
                    if (!fichero.exists()) {
                        System.out.println("No existen partidas guardadas.");
                        opcion_cargar = " ";
                    }else {

                        System.out.println("Partida encontrada");
                        System.out.println("Cargando partida...");
                        pausa(2000);

                        DatoGuardado dg = Guardado.leerDato();
                        j = new Jugador(dg.getNombre(),dg.getSala());
                        j.grabadora = Guardado.leerGrabadora();
                        j.inventario = Guardado.leerInventario();
                    }
                    break;


            }

        }while (!opcion_cargar.matches("1|2"));



        inicio_juego();

        System.out.println("Empieza el juego: sala oscura.");
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

    public static void mostrarMapa(String actual) {
        final String RESET   = "\u001B[0m";
        final String GREEN   = "\u001B[32m";
        final String CYAN    = "\u001B[36m";
        final String BOLD    = "\u001B[1m";

        // resalta solo la sala actual
        java.util.function.Function<String, String> r = nombre ->
                nombre.equalsIgnoreCase(actual)
                        ? BOLD + GREEN + nombre.toUpperCase() + RESET
                        : nombre;

        System.out.println();
        System.out.println(CYAN + "╔════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║" + RESET + "                       MANSIÓN TUDOR (MAPA)                        " + CYAN + " ║" + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════════════════════════════╣" + RESET);
        System.out.println(CYAN + "║" + RESET + "  [" + r.apply("ESTUDIO") + "]───[" + r.apply("INVERNADERO") + "]───[" + r.apply("Sala del Billar") + "]───[" + r.apply("SALÓN") + "]           " + CYAN + "║" + RESET);
        System.out.println(CYAN + "║" + RESET + "       │              │                     │                       " + CYAN + "║" + RESET);
        System.out.println(CYAN + "║" + RESET + "  [" + r.apply("Vestibulo") + "]──────[" + r.apply("COCINA") + "]──────────────[" + r.apply("SÓTANO") + "]                   " + CYAN + "║" + RESET);
        System.out.println(CYAN + "╚════════════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }


    public static void inicio_juego() {
        System.out.println();
        pausa(500);
        System.out.println(CYAN + "╔════════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║" + RESET + "                                                                        " + CYAN + "║" + RESET);
        System.out.println(CYAN + "║" + RESET + "                " + BOLD + YELLOW + "CLUEDO" + RESET + "  " + BOLD + MAGENTA + "· traición en la mansión tudor" + RESET + "                  " + CYAN + "║" + RESET);
        System.out.println(CYAN + "║" + RESET + "                                                                        " + CYAN + "║" + RESET);
        System.out.println(CYAN + "╚════════════════════════════════════════════════════════════════════════╝" + RESET);
        pausa(800);
        System.out.println();
        System.out.println(RED + " Estabas tranquilamente en tu estudio resolviendo un misterio de un trabajo, "+RESET );
        pausa(800);
        System.out.println(RED + " cuando de repente suena una llamada y resulta que era el señor Black," + RESET);
        pausa(800);
        System.out.println(RED + " el mayor millonario que tiene residencia en este país,  resulta que quería que fuese como invitado oculto" +RESET);
        pausa(800);
        System.out.println(RED + " para investigar a los demás invitados que han sido elegidos para esa noche,"+ RESET);
        pausa(800);
        System.out.println(RED + " ya que dice que va quiere revelar al final de la cena delante de todos" + RESET);
        pausa(800);
        System.out.println(RED + " los secretos más oscuros de cada uno y no tiene confianza de ninguno de ellos. Te pide su ayuda.  " + RESET);


        System.out.println(GREEN + "    → comienza tu investigación..." + RESET);
        pausa(2000);
        System.out.println();

        // escena del apagón inicial
        System.out.println("   ");
        System.out.println(RED + "Al llegar a la mansión te das cuenta de que desde el exterior parece estar todo tranquilamente," + RESET);
        pausa(800);
        System.out.println(RED+ " pero de repente ves una sombra de alguien que se ve por una de las ventanas de la mansión,"+ RESET);
        pausa(800);
        System.out.println(RED+ " llegas a la puerta principal rápidamente y justo antes de entrar se escucha un CRAC,"+ RESET);
        pausa(800);
        System.out.println(RED+ " un trueno muy fuerte se escucha y rápidamente del susto entras por el vestíbulo  dándote cuenta de que está todo oscuro..."+ RESET);
        pausa(800);
    }

    public static void finalJuego(String nombre, Grabadora g, Inventario i, boolean acertado) {
        int puntos = g.getDialogos().size() + i.getInventario().size();
        if (acertado){
            puntos += 500;
        }
        Puntuacion.subirPuntuacion(nombre, puntos);
    }


}


