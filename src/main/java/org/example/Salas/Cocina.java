package org.example.Salas;

import org.example.Dialogos.Grabadora;
import org.example.Escaner;
import org.example.Jugador;
import org.example.Main;
import org.example.Objetos.Arma;
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
        System.out.println();
        System.out.println(Main.BOLD +"Donde quieres ir?"+Main.RESET);
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
    public boolean acciones(Jugador j) {
        Grabadora g = j.grabadora;

        Pausa.esperar(1000);
        System.out.println(Main.BOLD+"\nElige una de las opciones:"+Main.RESET);
        System.out.println("1 - Hablar con Celeste");
        System.out.println("2 - Inspeccionar utensilios colgantes");
        System.out.println("3 - Inpeccionar cuchillero de la mesa de la cocina ");
        Pausa.esperar(1000);
        int opcion = Escaner.entero();

        switch (opcion) {

            case 1:
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Hay una mujer con un vestido azul con un abrigo de plumas, tomandose un té, parece ser una de las invitadas"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Pareces reconocerla, es una mujer llamada Celeste que es actualmente la novia del SR Black"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"te acercas por detras y del susto se lo tiras al suelo"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Se da la vuelta y le preguntas que que hace aquí"+Main.RESET);
                Pausa.esperar(1000);

                Personaje p = new Personaje("Celeste");

                System.out.println(p.getDialogo());
                Pausa.esperar(1000);
                g.addDialogo(p.getDialogo());
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Entiendes su argumento pero le preguntas que hacía aquí cuando se produjo el apagón"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(p.getDialogo_lupa());
                g.addDialogo(p.getDialogo_lupa());


                Pausa.esperar(1000);
                break;

            case 2:

                System.out.println("Te acercas al banco de la cocina y vés unos utensilios raros, echas un vistazo");
                Pausa.esperar(1000);
                System.out.println("Resulta haber un hueco entre los utensilios");
                Pausa.esperar(1000);
                System.out.println(Main.RED+"!Es un revolver¡"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println("Quieres coger el revolver? (s/n)");

                if (Escaner.sn()){
                    if (!j.inventario.contieneItem("Revolver")){
                        j.inventario.agregarItem(new Objeto("Revolver"));
                        j.grabadora.addDialogo(new Arma("Revolver").getDialogo());
                        Pausa.esperar(1000);
                        System.out.println(Main.GREEN+"Has cogido el revolver con cuidado a que no dispare"+Main.RESET);
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





        return false;
    }


}
