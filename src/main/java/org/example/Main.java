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

    public static void main(String[] args) {

        // --- BIENVENIDA ---
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a CLUEDO: Traición en la Mansión Tudor");
        System.out.println("-----------------------------------------------------------");

        // --- CONEXIÓN BASE DE DATOS ---
        Connection conexion = ConexionBD.getConnection();
        if (conexion != null) {
            System.out.println("Conectado correctamente a la base de datos.");
        } else {
            System.out.println("No se pudo conectar con la base de datos.");
        }

        // --- LOGIN / CREACIÓN DE USUARIO ---
        System.out.print("\n¿Tienes una cuenta existente? (s/n): ");
        String tieneCuenta = sc.nextLine();

        Usuario usuario = null; // Inicialización explícita, buena práctica.

        if (tieneCuenta.equalsIgnoreCase("s")) {
            System.out.print("Introduce tu nombre de usuario: ");
            String nombre = sc.nextLine();
            System.out.print("Introduce tu contraseña: ");
            String pass = sc.nextLine();

            if (usuario.validarUsuario(nombre, pass)) {
                System.out.println("Usuario validado correctamente. ¡Bienvenido, " + nombre + "!");
            } else {
                System.out.println("Usuario o contraseña incorrectos. Saliendo...");
                ConexionBD.closeConnection();
                return;
            }

        } else {
            System.out.print("Introduce tu nombre de usuario nuevo: ");
            String nombre = sc.nextLine();
            System.out.print("Introduce una contraseña: ");
            String pass = sc.nextLine();

            usuario.crearUsuario(nombre, pass);
            System.out.println("Usuario creado correctamente.");
        }

        // --- CARGA DE ARCHIVOS JSON ---
        ArrayList<Dialogo> dialogos = Dialogos.getDialogos();
        ArrayList<Descripcion> descripciones = Descripciones.getDescripciones();

        System.out.println("\nDatos de juego cargados:");
        System.out.println("- " + dialogos.size() + " diálogos disponibles");
        System.out.println("- " + descripciones.size() + " descripciones cargadas");

        // --- INICIALIZAR INVENTARIO ---
        Inventario inventario = new Inventario();

        System.out.println("\nEmpiezas tu investigación en el Vestíbulo de la mansión Tudor.");
        System.out.println("Escribe 'ayuda' para ver los comandos disponibles.");

        // --- BUCLE PRINCIPAL DEL JUEGO ---
        boolean jugando = true;
        while (jugando) {
            System.out.print("\n> ");
            String comando = sc.nextLine().trim().toLowerCase();



            if (comando.equals("ayuda")) {

                System.out.println("Comandos disponibles:");
                System.out.println("- hablar [nombre]       → habla con un personaje");
                System.out.println("- examinar [nombre]     → examina un objeto");
                System.out.println("- inventario            → muestra tus objetos");
                System.out.println("- ranking               → muestra el ranking global");
                System.out.println("- salir                 → termina la partida");

            } else if (comando.equals("inventario")) {
                System.out.println("Tu inventario:");
                inventario.mostrarInventario();

            } else if (comando.equals("ranking")) {
                Puntuaciones.mostrarPuntuaciones();

            } else if (comando.equals("salir")) {
                System.out.println("Saliendo del juego... hasta la próxima, detective.");
                jugando = false;

            } else if (comando.startsWith("hablar")) {
                String nombre = comando.replace("hablar", "").trim();

                if (nombre.isEmpty()) {
                    System.out.println("Debes indicar con quién quieres hablar.");
                } else {

                    Dialogo dialogoEncontrado = null;

                    for (int i = 0; i < dialogos.size(); i++) {
                        Dialogo d = dialogos.get(i);

                        if (d.getNombre().equalsIgnoreCase(nombre) && d.getTipo() == TipoDialogo.PERSONAJE) {
                            dialogoEncontrado = d;
                            break; // Romper el bucle for
                        }
                    }

                    if (dialogoEncontrado != null) {
                        System.out.println(nombre + ": \"" + dialogoEncontrado.getDialogo() + "\"");
                    } else {
                        System.out.println("No hay ningún personaje llamado '" + nombre + "' aquí o no tiene diálogo.");
                    }
                }

            } else if (comando.startsWith("examinar")) {
                String nombre = comando.replace("examinar", "").trim();

                if (nombre.isEmpty()) {
                    System.out.println("Debes indicar qué objeto quieres examinar.");
                } else {

                    Descripcion descripcionEncontrada = null;

                    for (Descripcion desc : descripciones) {
                        if (desc.getNombre().equalsIgnoreCase(nombre)) {
                            descripcionEncontrada = desc;
                            break; // Romper el bucle
                        }
                    }

                    if (descripcionEncontrada != null) {
                        System.out.println("🔍 " + descripcionEncontrada.getDescripcion());
                    } else {
                        System.out.println("No ves nada interesante en " + nombre + ".");
                    }
                }

            } else {
                System.out.println("Comando no reconocido. Escribe 'ayuda' para ver los comandos disponibles.");
            }
        }

        // --- CERRAR CONEXIÓN BD ---
        ConexionBD.closeConnection();
    }
}