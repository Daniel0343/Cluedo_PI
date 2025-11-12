package org.example;

import org.example.BaseDatos.Puntuacion;
import org.example.BaseDatos.Puntuaciones;
import org.example.BaseDatos.Usuario;
import org.example.Dialogos.Grabadora;
import org.example.Objetos.Objeto;
import org.example.Salas.Habitacion;
import org.example.Salas.Invernadero;

import javax.xml.crypto.Data;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // colores ansi para consola
    public static final String RESET   = "\u001B[0m";
    public static final String RED     = "\u001B[31m";
    public static final String GREEN   = "\u001B[32m";
    public static final String YELLOW  = "\u001B[33m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN    = "\u001B[36m";
    public static final String BOLD    = "\u001B[1m";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Habitacion.crearInfo();
        // crear jugador y pasar al control por habitaciones
        Jugador j = null;
        String contrasena;
        String nombre;
        do {

            System.out.println(CYAN+"-- Iniciar Sesión --" +RESET);
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
            } else {
                System.out.println("Usuario incorrecto.");
            }



        } while (!Usuario.validarUsuario(nombre, contrasena));


        boolean cargado = false;
        String opcion_cargar = "";
        do {
            System.out.println();
            System.out.println(CYAN+"-- Carga Partida --"+RESET);
            System.out.println("1. Nueva Partida");
            System.out.println("2. Cargar Partida");
            opcion_cargar = scanner.nextLine();

            switch (opcion_cargar) {

                case "1":

                    System.out.println("Nueva Partida");
                    j = new Jugador(nombre, Habitacion.habitaciones[0]);
                    inicio_juego();
                    System.out.println("Empieza el juego: sala oscura.");
                    pausa(1000);
                    break;


                case "2":
                    cargado = true;
                    File fichero = new File("guardado");
                    if (!fichero.exists()) {
                        System.out.println("No existen partidas guardadas.");
                        opcion_cargar = " ";
                    }else {

                        System.out.println("Partida encontrada");
                        System.out.println("Cargando partida...");
                        pausa(2000);

                        DatoGuardado dg = Guardado.leerDato();
                        Habitacion[] todas = Habitacion.crearInfo();

                        if (dg.getHabitacionesDescubiertas() != null) {
                            for (Habitacion h : todas) {
                                Boolean descubierto = dg.getHabitacionesDescubiertas().get(h.getNombre());
                                if (descubierto != null) {
                                    h.setDescubierta(descubierto);
                                }
                            }
                        }

                        Habitacion salaActual = Arrays.stream(todas)
                                .filter(h -> h.getNombre().equals(dg.getNombreSalaActual()))
                                .findFirst()
                                .orElse(todas[0]);

                        j = new Jugador(nombre, salaActual);
                        j.inventario = Guardado.leerInventario();
                        j.grabadora = Guardado.leerGrabadora();



                    }
                    break;


            }

        }while (!opcion_cargar.matches("1|2"));






        boolean apagada = true;

        while (apagada && !cargado) {
            System.out.println(CYAN+"\nElige una opción:"+RESET);
            System.out.println(BOLD+"1 - buscar alrededor del escritorio"+RESET);
            System.out.println(BOLD+"2 - inspeccionar el mueble cercano"+RESET);
            System.out.println(BOLD+"3 - avanzar hacia el fondo de la sala"+RESET);

            int opcion = Escaner.entero();
            switch (opcion) {
                case 1:
                    System.out.println("Has chocado contra algo, no distingues bien qué es.");
                    Pausa.esperar(1000);


                    if (j.inventario.contieneItem("Linterna")) {
                        pausa(1000);
                        System.out.println("Con la linterna ves una llave triangular bajo el escritorio. ¿la coges? (s/n)");
                        String eleccion = Escaner.string();
                        if (eleccion.equalsIgnoreCase("s")) {
                            pausa(1000);
                            if (!j.inventario.contieneItem("Llave Triangular")){
                                j.inventario.agregarItem(new Objeto("Llave Triangular"));
                                Pausa.esperar(1000);
                                System.out.println(Main.GREEN+"Has cogido la llave triangular"+Main.RESET);
                            }else {
                                Pausa.esperar(1000);
                                System.out.println("Ya tienes la Llave Triangular.");
                            }
                        }
                    }else {
                        Pausa.esperar(1000);
                        System.out.println("Necesitas un objeto luminoso para poder verlo");
                        Pausa.esperar(1000);
                    }
                    break;

                case 2:
                    Pausa.esperar(1000);
                    System.out.println("Tocas lo que parece un mueble... abres un cajón y notas algo metálico. ¿lo coges? (s/n)");
                    if (Escaner.sn()){
                        if (!j.inventario.contieneItem("Linterna")){
                            j.inventario.agregarItem(new Objeto("Linterna"));
                            Pausa.esperar(1000);
                            System.out.println(GREEN+"Has cogido la linterna"+RESET);
                        }else {
                            Pausa.esperar(1000);
                            System.out.println(GREEN+"Ya tienes la linterna"+RESET);
                        }

                    }
                    break;

                case 3:
                    Pausa.esperar(1000);
                    System.out.println("Te golpeas con algo grande y frío. no ves qué es.");
                    if (j.inventario.contieneItem("Linterna")) {
                        pausa(1000);
                        System.out.println("con la linterna ves un cuadro de luz cerrado con llave triangular.");
                        if (j.inventario.contieneItem("Llave Triangular")) {
                            pausa(1000);
                            System.out.println("¿quieres intentar abrirlo con la llave? (s/n)");
                            String eleccion3 = Escaner.string();
                            if (eleccion3.equalsIgnoreCase("s")) {
                                pausa(1000);
                                System.out.println("abres la tapa... dentro hay una palanca. ¿quieres subirla? (s/n)");
                                String eleccion4 = Escaner.string();
                                if (eleccion4.equalsIgnoreCase("s")) {
                                    pausa(1000);
                                    System.out.println(GREEN + "\n💡 las luces se encienden de golpe. la sala brilla. estás en el vestíbulo." + RESET);
                                    apagada = false;
                                }
                            }
                        } else {
                            System.out.println("Parece que no tienes la llave adecuada.");
                        }
                    } else {
                        System.out.println("No ves nada. Tal vez una linterna ayudaría.");
                    }
                    break;
            }
        }

        boolean salir = false;
        do{
            salir = j.acciones();
        }while (!salir);
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

        Pausa.esperar(1000);
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
        System.out.println(RED + " Al llegar a la mansión te das cuenta de que desde el exterior parece estar todo tranquilamente," + RESET);
        pausa(800);
        System.out.println(RED+ " pero de repente ves una sombra de alguien que se ve por una de las ventanas de la mansión,"+ RESET);
        pausa(800);
        System.out.println(RED+ " llegas a la puerta principal rápidamente y justo antes de entrar se escucha un CRAC,"+ RESET);
        pausa(800);
        System.out.println(RED+ " un trueno muy fuerte se escucha y rápidamente del susto entras por el vestíbulo  dándote cuenta de que está todo oscuro..."+ RESET);
        pausa(800);
    }

    public static void finalJuego(String nombre, Grabadora g, Inventario i, boolean acertado_asesino, boolean acertado_arma, boolean acertado_lugar) {
        int puntos = g.getDialogos().size() + i.getInventario().size();
        if (acertado_asesino){
            puntos += 500;
        }
        if (acertado_lugar){
            puntos += 500;
        }
        if (acertado_arma){
            puntos += 500;
        }
        Puntuacion.subirPuntuacion(nombre, puntos);
        Pausa.esperar(1000);
        System.out.println("Top - 10");
        Pausa.esperar(1000);
        Puntuaciones.mostrarPuntuaciones();
    }


}


