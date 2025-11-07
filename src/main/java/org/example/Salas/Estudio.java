package org.example.Salas;

import org.example.Escaner;
import org.example.Jugador;
import org.example.Objetos.Objeto;

public class Estudio extends Habitacion {
    public Estudio(String nombre) {
        super(nombre);
    }

    @Override
    public Habitacion movimiento() {
        System.out.println("¿Dónde quieres ir?");
        int i = 1;
        for (Habitacion habitacion : accesos) {
            System.out.println(i + " - " + habitacion.nombre);
            i++;
        }
        int opcion = Escaner.entero();
        if (opcion > 0 && opcion <= accesos.length) {
            return accesos[opcion - 1];
        } else if (opcion == 0) {
            return this;
        }
        System.out.println("Has introducido información errónea, no te mueves");
        return this;
    }

    @Override
    public void acciones(Jugador j) {
        System.out.println("\nElige una de las opciones:");
        System.out.println("1 - Inspeccionar armadura");
        System.out.println("2 - Inspeccionar escritorio del Sr. Black");
        System.out.println("3 - Inspeccionar chimenea");
        System.out.println("4 - Inspeccionar armario");

        int opcion = Escaner.entero();

        switch (opcion) {
            case 1:
                System.out.println("Inspeccionas la armadura detenidamente y ves una pluma blanca que sobresale un poco. ¿Quieres cogerla? (s/n)");
                if (Escaner.sn()) {
                    if (!j.inventario.contieneItem("Pluma")) {
                        j.inventario.agregarItem(new Objeto("Pluma"));
                        System.out.println("Has cogido la pluma y la guardas en tu inventario.");
                    } else {
                        System.out.println("Ya tienes la pluma.");
                    }
                }
                break;

            case 2:
                System.out.println("Encuentras un documento legal con un retrato del Dr. Black.");
                System.out.println("En él se lee por encima su fecha de nacimiento: 12.03.1950.");
                break;

            case 3:
                System.out.println("Te acercas a la chimenea. Entre las cenizas ves algo brillante.");
                if (j.inventario.contieneItem("Tubería")) {
                    System.out.println("Con la ayuda de la tubería alcanzas el objeto brillante. Es una llave con forma de corazón. ¿Quieres cogerla? (s/n)");
                    if (Escaner.sn()) {
                        if (!j.inventario.contieneItem("Llave corazón")) {
                            j.inventario.agregarItem(new Objeto("Llave corazón"));
                            System.out.println("Has cogido la Llave Corazón.");
                        } else {
                            System.out.println("Ya tienes la llave corazón.");
                        }
                    }
                } else {
                    System.out.println("Parece que necesitas algo largo y resistente al fuego para alcanzarlo.");
                }
                break;

            case 4:
                System.out.println("Intentas abrir el armario, pero está cerrado con una cerradura en forma de corazón.");
                if (j.inventario.contieneItem("Llave corazón")) {
                    System.out.println("Usas la llave corazón para abrir el armario...");
                    System.out.println("Dentro encuentras el cadáver del Dr. Black. 🕯️");
                    System.out.println("El misterio empieza a tomar forma...");
                } else {
                    System.out.println("No tienes la llave adecuada. Quizás esté en algún otro lugar.");
                }
                break;

            default:
                System.out.println("Opción inválida, vuelve a intentarlo.");
                break;
        }
    }
}
