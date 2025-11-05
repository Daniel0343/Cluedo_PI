package org.example;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.BaseDatos.*;
import org.example.Dialogos.*;
import org.example.Dialogos.Dialogos;
import org.example.Objetos.*;
import org.example.Objetos.Descripcion;
import org.example.Objetos.Descripciones;

public class Main {

    // códigos ansi para color en terminal
    private static final String RESET   = "\u001B[0m";
    private static final String RED     = "\u001B[31m";
    private static final String GREEN   = "\u001B[32m";
    private static final String YELLOW  = "\u001B[33m";
    private static final String BLUE    = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String CYAN    = "\u001B[36m";
    private static final String BOLD    = "\u001B[1m";

    public static void main(String[] args) {

        // bienvenida - pantalla inicial llamativa
        System.out.println();
        System.out.println(CYAN + "╔════════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║" + RESET + "                                                                        " + CYAN + "║" + RESET);
        System.out.println(CYAN + "║" + RESET + "                " + BOLD + YELLOW + "CLUEDO" + RESET + "  " + BOLD + MAGENTA + "· traición en la mansión tudor" + RESET + "                  " + CYAN + "║" + RESET);
        System.out.println(CYAN + "║" + RESET + "                                                                        " + CYAN + "║" + RESET);
        System.out.println(CYAN + "╚════════════════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
        System.out.println(RED + "    Un asesinato. una mansión. secretos que no quieren salir a la luz." + RESET);
        System.out.println(RED + "    el reloj corre. eres el detective. ¿podrás descubrir la verdad?" + RESET);
        System.out.println();

        System.out.println();

        System.out.println();


        /*

        Scanner sc = new Scanner(System.in);

        // --- conexión base de datos ---
        Connection conexion = ConexionBD.getConnection();
        if (conexion != null) {
            System.out.println("conectado correctamente a la base de datos.");
        } else {
            System.out.println("no se pudo conectar con la base de datos.");
        }

        // --- login / creación de usuario ---
        System.out.print("\n¿tienes una cuenta existente? (s/n): ");
        String tieneCuenta = sc.nextLine();

        Usuario usuario = null; // inicialización explícita, buena práctica.

        if (tieneCuenta.equalsIgnoreCase("s")) {
            System.out.print("introduce tu nombre de usuario: ");
            String nombre = sc.nextLine();
            System.out.print("introduce tu contraseña: ");
            String pass = sc.nextLine();

            if (usuario.validarUsuario(nombre, pass)) {
                System.out.println("usuario validado correctamente. ¡bienvenido, " + nombre + "!");
            } else {
                System.out.println("usuario o contraseña incorrectos. saliendo...");
                ConexionBD.closeConnection();
                return;
            }

        } else {
            System.out.print("introduce tu nombre de usuario nuevo: ");
            String nombre = sc.nextLine();
            System.out.print("introduce una contraseña: ");
            String pass = sc.nextLine();

            if (usuario.crearUsuario(nombre, pass)) {
                System.out.println("usuario creado correctamente.");
            }  else {
                System.out.println("fallo al crear usuario");
            }
        }

        // --- carga de archivos json ---
        ArrayList<Dialogo> dialogos = Dialogos.getDialogos();
        ArrayList<Descripcion> descripciones = Descripciones.getDescripciones();

        System.out.println("\ndatos de juego cargados:");
        System.out.println("- " + dialogos.size() + " diálogos disponibles");
        System.out.println("- " + descripciones.size() + " descripciones cargadas");

        // --- inicializar inventario ---
        Inventario inventario = new Inventario();

        System.out.println("\nempiezas tu investigación en el vestíbulo de la mansión tudor.");
        System.out.println("escribe 'ayuda' para ver los comandos disponibles.");

        // --- bucle principal del juego ---
        boolean jugando = true;
        while (jugando) {
            System.out.print("\n> ");
            String comando = sc.nextLine().trim().toLowerCase();

            if (comando.equals("ayuda")) {

                System.out.println("comandos disponibles:");
                System.out.println("- hablar [nombre]       → habla con un personaje");
                System.out.println("- examinar [nombre]     → examina un objeto");
                System.out.println("- inventario            → muestra tus objetos");
                System.out.println("- ranking               → muestra el ranking global");
                System.out.println("- salir                 → termina la partida");

            } else if (comando.equals("inventario")) {
                System.out.println("tu inventario:");
                inventario.mostrarInventario();

            } else if (comando.equals("ranking")) {
                Puntuaciones.mostrarPuntuaciones();

            } else if (comando.equals("salir")) {
                System.out.println("saliendo del juego... hasta la próxima, detective.");
                jugando = false;

            } else if (comando.startsWith("hablar")) {
                String nombre = comando.replace("hablar", "").trim();

                if (nombre.isEmpty()) {
                    System.out.println("debes indicar con quién quieres hablar.");
                } else {

                    Dialogo dialogoEncontrado = null;

                    for (int i = 0; i < dialogos.size(); i++) {
                        Dialogo d = dialogos.get(i);

                        if (d.getNombre().equalsIgnoreCase(nombre) && d.getTipo() == TipoDialogo.PERSONAJE) {
                            dialogoEncontrado = d;
                            break; // romper el bucle for
                        }
                    }

                    if (dialogoEncontrado != null) {
                        System.out.println(nombre + ": \"" + dialogoEncontrado.getDialogo() + "\"");
                    } else {
                        System.out.println("no hay ningún personaje llamado '" + nombre + "' aquí o no tiene diálogo.");
                    }
                }

            } else if (comando.startsWith("examinar")) {
                String nombre = comando.replace("examinar", "").trim();

                if (nombre.isEmpty()) {
                    System.out.println("debes indicar qué objeto quieres examinar.");
                } else {

                    Descripcion descripcionEncontrada = null;

                    for (Descripcion desc : descripciones) {
                        if (desc.getNombre().equalsIgnoreCase(nombre)) {
                            descripcionEncontrada = desc;
                            break; // romper el bucle
                        }
                    }

                    if (descripcionEncontrada != null) {
                        System.out.println("🔍 " + descripcionEncontrada.getDescripcion());
                    } else {
                        System.out.println("no ves nada interesante en " + nombre + ".");
                    }
                }

            } else {
                System.out.println("comando no reconocido. escribe 'ayuda' para ver los comandos disponibles.");
            }
        }

        // --- cerrar conexión bd ---
        ConexionBD.closeConnection();
        */
    }
}
