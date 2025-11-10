package org.example;

import org.example.Dialogos.Grabadora;
import org.example.Salas.Habitacion;

public class Jugador {
    String nombre;
    Habitacion ubicacion;
    public Inventario inventario = new Inventario();
    public Grabadora grabadora = new Grabadora();

    public Jugador(String nombre, Habitacion vestibulo) {
        this.nombre = nombre;
        this.ubicacion = vestibulo;
        this.inventario = new Inventario(); // cada jugador tiene su propio inventario
    }

    public String getNombre() {
        return nombre;
    }

    private void setUbicacion(Habitacion nuevaUbi) {
        this.ubicacion = nuevaUbi;
    }

    public boolean acciones() {

        Main.mostrarMapa(ubicacion.getNombre());
        Pausa.esperar(1000);
        System.out.println("¿Qué quieres hacer en " + ubicacion.getNombre() + "?");
        System.out.println("1 - Acciones en la habitación");
        System.out.println("2 - Cambiar de habitación");
        System.out.println("3 - Ver inventario");
        System.out.println("4 - Consultar grabadora");
        System.out.println("5 - Salir y Guardar Partida");

        int opcion = Escaner.entero();
        boolean respuesta = false;
        switch (opcion) {
            case 1:
                respuesta = ubicacion.acciones(this);
                break;

            case 2:
                setUbicacion(ubicacion.movimiento());
                break;

            case 3:
                mostrarInventario();
                break;

            case 4:
                mostrarGrabadora();

                break;

            case 5:

                Guardado.guardarPartida(nombre,ubicacion,grabadora,inventario);
                System.exit(1);

                break;

            default:
                System.out.println("Valor incorrecto, vuelve a intentarlo.");
                acciones();
                break;
        }
        return respuesta;
    }

    public void mostrarInventario() {
        System.out.println("\nInventario:");
        if (inventario.getInventario().isEmpty()) {
            System.out.println("(vacío)");
        } else {
            inventario.mostrarInventario();
        }
        System.out.println();
    }

    public void mostrarGrabadora() {
        System.out.println("\nGrabadora");
        if (grabadora.getDialogos().isEmpty()) {
            System.out.println("La grabadora no tiene dialgos");
        } else {

            grabadora.getDialogos().forEach(s -> {

                System.out.println(s);
                System.out.println();

            });

        }


    }


}
