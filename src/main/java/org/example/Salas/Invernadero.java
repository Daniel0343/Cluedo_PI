package org.example.Salas;

import org.example.Escaner;

public class Invernadero extends Habitacion{
    public Invernadero(String nombre) {
        super(nombre);
    }

    @Override
    public Habitacion movimiento(){
        System.out.println("Donde quieres ir?");
        int i = 1;
        for (Habitacion habitacion : accesos){
            System.out.println(i + " - " + habitacion.nombre);
            i++;
        }
        int opcion = Escaner.entero();
        if (opcion > 0 && opcion <= accesos.length) {
            if (accesos[opcion - 1].nombre.equals("Sala del Billar") && !SalaBillar.abierta) {
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
    public void acciones() {

    }
}
