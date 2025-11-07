package org.example.Salas;

import org.example.Escaner;
import org.example.Jugador;
import org.example.Objetos.Items;
import org.example.Objetos.Objeto;

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
    public void acciones(Jugador j) {
        System.out.println("Elige una de las opciones:");
        System.out.println("1 - Ispeccionar armadura");
        System.out.println("2 - Inspeccionar escritorio de SR.Black");
        System.out.println("3 - Inspeccionar chimenea");
        System.out.println("4 - Inspeccionar armario");
        int opcion = Escaner.entero();
        String eleccion = "";
        switch (opcion){
            case 1:
                System.out.println("Has hecho una inspeccion de armadura");
                System.out.println("Miras la armadura detenidamente y ves una pluma blanca que sobresale un poco ¿quieres cogerla? (s/n)");

                if (Escaner.sn()) {
                    j.inventario.agregarItem(new Objeto("pluma"));
                    System.out.println("Has cogido la pluma");
                }
                break;
            case 2:
                System.out.println("Has hecho una inspeccion de escritorio de SR.Black");
                System.out.println("Encuentras un documento legal con un Retrato del Dr. Black. En él se lee por encima su fecha de nacimiento: 12.03.1950." );
                break;
            case 3:
                System.out.println("Has hecho una inspeccion de chimenea");
                if (j.inventario.contieneItem("Tubería")) {
                    System.out.println("Al acercarte a echar un vistazo a la chimenea ves como un objeto brillante que asoma entre las cenizas, parece que intentas alcanzarlo, pero no llegas bien. Con la ayuda de la tubería alcanzas el objeto brillante con la tubería y resulta ser una llave con forma de corazón. ¿Coges la llave? (s/n)");

                    if (Escaner.sn()) {
                        j.inventario.agregarItem(new Objeto("Pluma"));
                        System.out.println("Has cogido la pluma");
                    }
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + opcion);
        }

    }
}
