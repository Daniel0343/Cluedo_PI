package org.example.Salas;

import org.example.Escaner;
import org.example.Jugador;
import org.example.Objetos.Objeto;
import org.example.Pausa;
import org.example.Puzles;

public class Invernadero extends Habitacion {
    private boolean puzzleResuelto = false;

    public Invernadero(String nombre) {
        super(nombre);
    }

    @Override
    public Habitacion movimiento() {
        System.out.println("¿Dónde quieres ir?");
        int i = 1;
        for (Habitacion habitacion : accesos) {
            if (habitacion.nombre.equals("Sala del Billar") && !SalaBillar.abierta) {
                System.out.println(i + " - " + habitacion.nombre + " (cerrada)");
            } else if (habitacion.nombre.equals("Cocina") && !Cocina.abierta) {
                System.out.println(i + " - " + habitacion.nombre + " (cerrada)");
            } else {
                System.out.println(i + " - " + habitacion.nombre);
            }
            i++;
        }

        int opcion = Escaner.entero();
        if (opcion > 0 && opcion <= accesos.length) {
            Habitacion destino = accesos[opcion - 1];

            if (destino.nombre.equals("Sala del Billar") && !SalaBillar.abierta) {
                System.out.println("No puedes abrir esta puerta, parece que está cerrada.");
                return this;
            }
            if (destino.nombre.equals("Cocina") && !Cocina.abierta) {
                System.out.println("Parece que hay una trampilla cerrada. Tal vez haya un mecanismo que la desbloquee.");
                return this;
            }
            return destino;
        } else if (opcion == 0) {
            return this;
        }

        System.out.println("Has introducido información errónea, no te mueves.");
        return this;
    }

    @Override
    public void acciones(Jugador j) {

        System.out.println("El aire se vuelve denso y húmedo, lleno del olor a tierra mojada y flores exóticas.");
        System.out.println("La luz de la luna apenas se filtra por el techo de cristal. Notas un rastro de tierra que no pertenece a las macetas.\n");

        System.out.println("Elige una de las opciones:");
        System.out.println("1 - Inspeccionar la alfombra");
        System.out.println("2 - Resolver el puzzle de las plantas");
        System.out.println("3 - Desbloquear la losa y la trampilla");
        System.out.println("4 - Salir del invernadero");

        int opcion = Escaner.entero();

        switch (opcion) {
            case 1:
                System.out.println("Levantas una alfombra pesada y descubres marcas de arrastre oscuras y húmedas que van hacia el estudio.");
                if (!j.inventario.contieneItem("Llave circular")) {
                    System.out.println("Entre las marcas, encuentras una pequeña llave con forma de círculo. ¿Quieres cogerla? (s/n)");
                    if (Escaner.sn()) {
                        j.inventario.agregarItem(new Objeto("Llave circular"));
                        System.out.println("Has añadido la Llave Circular a tu inventario.");
                    }
                } else {
                    System.out.println("Ya recogiste la llave con forma de círculo antes.");
                }
                break;

            case 2:
                System.out.println("Ves al fondo de el invernadero, un monton de enredaderas en el suelo");
                Pausa.esperar(1000);
                System.out.println("-- PUZZLE -- ");
                Pausa.esperar(1000);

                if (!puzzleResuelto) {
                    if (Escaner.sn()) {
                        if (Puzles.puzzle_enredaderas()) {
                            puzzleResuelto = true;
                            System.out.println("Al activar el mecanismo con la secuencia correcta, las plantas se retraen y revelan una losa con una ranura circular.");
                        } else {
                            System.out.println("No consigues resolver el puzzle. Tal vez deberías intentarlo de nuevo más tarde.");
                        }
                    }
                } else {
                    System.out.println("Ya has resuelto el puzzle de las plantas. La losa con la ranura circular sigue ahí.");
                }
                break;

            case 3:
                if (!puzzleResuelto) {
                    System.out.println("No parece haber nada que abrir por ahora. Tal vez primero debas resolver el puzzle.");
                    break;
                }
                if (j.inventario.contieneItem("Llave circular")) {
                    System.out.println("La Llave Circular encaja perfectamente en la losa. Al girarla, el mecanismo cede y se abre una trampilla.");
                    System.out.println("Una escalera desciende hacia un pasadizo oscuro que lleva a la cocina.");
                    Cocina.abierta = true;

                    boolean tieneCocina = false;
                    for (Habitacion h : accesos) {
                        if (h.getNombre().equalsIgnoreCase("Cocina")) {
                            tieneCocina = true;
                            break;
                        }
                    }
                    if (!tieneCocina) {
                        Habitacion[] nuevosAccesos = new Habitacion[accesos.length + 1];
                        System.arraycopy(accesos, 0, nuevosAccesos, 0, accesos.length);
                        nuevosAccesos[accesos.length] = Habitacion.habitaciones[4]; // cocina
                        accesos = nuevosAccesos;
                    }

                } else {
                    System.out.println("La losa tiene una ranura circular. Tal vez necesites una llave con esa forma.");
                }
                break;

            case 4:
                System.out.println("Decides no hacer nada más en el invernadero por ahora.");
                break;

            default:
                System.out.println("Opción inválida, vuelve a intentarlo.");
                break;
        }
    }
}
