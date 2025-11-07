package org.example;

import org.example.Salas.Habitacion;

public class Jugador {
    String nombre;
    Habitacion ubicacion;
    public Inventario inventario;

    public Jugador(String nombre, Habitacion vestibulo) {
        this.nombre = nombre;
        this.ubicacion = vestibulo;
        this.inventario = new Inventario(); // cada jugador tiene su propio inventario
    }

    private void setUbicanción(Habitacion nuevaUbi) {
        this.ubicacion = nuevaUbi;
    }

    public void acciones() {
        System.out.println("¿Qué quieres hacer en " + ubicacion.getNombre() + "?");
        System.out.println("1 - Acciones en la habitación");
        System.out.println("2 - Cambiar de habitación");
        System.out.println("3 - Ver inventario");

        int opcion = Escaner.entero();

        switch (opcion) {
            case 1:
                ubicacion.acciones(this);
                break;

            case 2:
                setUbicanción(ubicacion.movimiento());
                break;

            case 3:
                mostrarInventario();
                break;

            default:
                System.out.println("Valor incorrecto, vuelve a intentarlo.");
                acciones();
                break;
        }
    }

    private void mostrarInventario() {
        System.out.println("\nInventario:");
        if (inventario.getInventario().isEmpty()) {
            System.out.println("(vacío)");
        } else {
            inventario.mostrarInventario();
        }
        System.out.println();
    }
}
