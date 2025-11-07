package org.example.Salas;

import org.example.Dialogos.Dialogo;
import org.example.Dialogos.Grabadora;
import org.example.Escaner;
import org.example.Jugador;
import org.example.Objetos.Objeto;
import org.example.Pausa;
import org.example.Personajes.Personaje;

public class Cocina extends Habitacion{
    static boolean abierta = false;

    public Cocina(String nombre) {
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
        Grabadora g = new Grabadora();

        System.out.println("\nElige una de las opciones:");
        System.out.println("1 - Hablar con Celeste");
        System.out.println("2 - Inspeccionar utensilios colgantes");
        System.out.println("3 - Inpeccionar cuchillero de la mesa de la cocina ");
        Pausa.esperar(1000);
        int opcion = Escaner.entero();

        switch (opcion) {

            case 1:
                System.out.println("Hay una mujer con un vestido azul con un abrigo de plumas, tomandose un té, parece ser una de las invitadas");
                Pausa.esperar(1000);
                System.out.println("Pareces reconocerla, es una mujer llamada Celeste que es actualmente la novia del SR Black");
                Pausa.esperar(1000);
                System.out.println("te acercas por detras y del susto se lo tiras al suelo");
                Pausa.esperar(1000);
                System.out.println("Se da la vuelta y le preguntas que que hace aquí");
                Pausa.esperar(1000);

                Personaje p = new Personaje("Celeste");

                System.out.println(p.getDialogo());

                g.addDialogo(p.getDialogo());
                Pausa.esperar(1000);
                System.out.println("Entiendes su argumento pero le preguntas que hacía aquí cuando se produjo el apagón");
                Pausa.esperar(1000);
                System.out.println(p.getDialogo_lupa());


                Pausa.esperar(1000);
                break;

            case 2:

                System.out.println("Te acercas al banco de la cocina y vés unos utensilios raros, echas un vistazo");
                Pausa.esperar(1000);
                System.out.println("Resulta haber un hueco entre los utensilios");
                Pausa.esperar(1000);
                System.out.println("!Es un revolver¡");
                Pausa.esperar(1000);
                System.out.println("Quieres coger el revolver? (s/n)");

                if (Escaner.sn()){
                    if (!j.inventario.contieneItem("Revolver")){
                        j.inventario.agregarItem(new Objeto("Revolver"));
                        Pausa.esperar(1000);
                        System.out.println("Has cogido el revolver con cuidado a que no dispare");
                    }else {
                        Pausa.esperar(1000);
                        System.out.println("Ya tienes el revolver.");
                    }

                }

                break;

            case 3:
                Pausa.esperar(1000);
                System.out.println("Te llama la atención que el cuchillero de la mesa de la cocina le faltan cuchillos");
                Pausa.esperar(1000);
                System.out.println("Los puede haber cogido alguien?");


                break;

            default:
                System.out.println("Opción inválida, vuelve a intentarlo.");
                break;

        }






    }


}
