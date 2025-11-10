package org.example.Salas;

import org.example.Escaner;
import org.example.Jugador;

public class Vestibulo extends Habitacion{

    public Vestibulo(String nombre) {
        super(nombre);
    }

    @Override
    public Habitacion movimiento(){
        System.out.println("Donde quieres ir? (0 para quedarse en el vestibulo)");
        int i = 1;
        for (Habitacion habitacion : accesos){
            System.out.println(i + " - " + habitacion.nombre);
            i++;
        }
        int opcion = Escaner.entero();
        if (opcion > 0 && opcion <= accesos.length) {
            if (accesos[opcion - 1].nombre.equals("Cocina") && !Cocina.abierta) {
                System.out.println("No puedes abrir esta puerta, parece que está cerrada");
                return this;
            }
            return accesos[opcion - 1];
        } else if (opcion == 0) {
            return this;
        }
        System.out.println("Has introducido información herronea, no te mueves");
        return this;
    }

    @Override
    public boolean acciones(Jugador j) {



        return false;
    }
}
