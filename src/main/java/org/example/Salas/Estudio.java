package org.example.Salas;

import org.example.Escaner;

public class Estudio extends Habitacion{
    public Estudio(String nombre) {
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
            return accesos[opcion - 1];
        } else if (opcion == 0) {
            return this;
        }
        System.out.println("Has introducido información herronea, no te mueves");
        return this;
    }
    @Override
    public void acciones() {
        System.out.println("Elige una de las opciones:");
        System.out.println("1 - Ispeccionar armadura");
        System.out.println("2 - Inspeccionar escritorio de SR.Black");
    }
}
