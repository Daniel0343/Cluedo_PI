package org.example.Salas;

import org.example.Dialogos.Grabadora;
import org.example.Escaner;
import org.example.Jugador;
import org.example.Main;
import org.example.Objetos.Arma;
import org.example.Objetos.Objeto;
import org.example.Pausa;
import org.example.Personajes.Personaje;

import java.util.Scanner;

public class Salon extends Habitacion{
    public Salon(String nombre) {
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
        Scanner sc = new Scanner(System.in);

        Grabadora g = j.grabadora;
        Pausa.esperar(1000);
        System.out.println(Main.BOLD+"\nElige una de las opciones:"+Main.RESET);
        System.out.println("1 - Hablar con Prado");
        System.out.println("2 - Inspeccionar retrato Dr.Black");
        System.out.println("3 - Inspeccionar mesita del salón");

        int opcion = Escaner.entero();

        switch (opcion) {

            case 1:
                System.out.println(Main.YELLOW+"Ves en el sofa del salon sentado a uno de los invitados"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Parece estar leyendo un libro y no te presta mucha atención "+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Le preguntas que quien es y resulta ser el abogado"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Más famoso que hay por estas zonas"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Le dices porque está en la masnsion y te contexta sin mucho empeño: "+Main.RESET);
                Pausa.esperar(1000);
                Personaje p = new Personaje("Prado");
                g.addDialogo(p.getDialogo());
                System.out.println();
                System.out.println(p.getDialogo());

                System.out.println();
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"No entiendes nada de lo que dice, aceptas su tarjeta"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Y le pregutas que hacía aquí cuando se produjo el apagón"+Main.RESET);
                System.out.println(p.getDialogo_lupa());
                g.addDialogo(p.getDialogo_lupa());

                break;

            case 2:

                System.out.println("Te fijas bien en el retrato porque te recuerda");
                Pausa.esperar(1000);
                System.out.println(Main.BOLD+"Al de la foto que viste en el escritorio del estudio"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println("Que al mirarlo de cerca te das cuenta que hay un boton");
                Pausa.esperar(1000);
                System.out.println("Se ve muy poco pero lo presionas");
                Pausa.esperar(1000);

                System.out.println(Main.CYAN+"-- PUZZLE --"+Main.RESET);
                Pausa.esperar(1000);
                String resultado = "12031950";
                System.out.println("Se mueve el cuadro y aparece una pequeña caja fuerte");
                Pausa.esperar(1000);
                System.out.println("Parece que necesitas introducir un codigo de 8 cifras para abrirlo");
                Pausa.esperar(1000);
                System.out.println("Hay una nota que pone: La fecha que todos siempre nos acordamos es la que es");
                Pausa.esperar(1000);

                System.out.println("Introduce el codigo");
                String us = sc.nextLine();

                if (us.matches(resultado)){

                    System.out.println(Main.CYAN+"-- PUZZLE RESUELTO --"+Main.RESET);
                    Pausa.esperar(1000);

                    System.out.println("Dentro de la caja fuerte hay, un pequeño anillo rojo, lo coges (si/no)");
                    Pausa.esperar(1000);
                    if (Escaner.sn()){
                        if (!j.inventario.contieneItem("Anillo Rojo")){
                            j.inventario.agregarItem(new Objeto("Anillo Rojo"));

                            Pausa.esperar(1000);
                            System.out.println(Main.GREEN+"Has cogido el Anillo Rojo y te lo guardas en el inventario"+Main.RESET);
                        } else {
                            Pausa.esperar(1000);
                            System.out.println("Ya tienes el Anillo Rojo.");
                        }
                    }


                }else {
                    System.out.println("Codigo introducido incorrecto");
                }

                break;

            case 3:
                Pausa.esperar(1000);
                System.out.println("Ves que sobre la mesita de mármol, encuentras movido");
                Pausa.esperar(1000);
                System.out.println("Un candelabro que parece pesado");
                Pausa.esperar(1000);
                System.out.println("Lo coges (si/no)");

                Pausa.esperar(1000);
                if (Escaner.sn()){
                    if (!j.inventario.contieneItem("Candelabro")){
                        j.inventario.agregarItem(new Objeto("Candelabro"));
                        j.grabadora.addDialogo(new Arma("Candelabro").getDialogo());
                        System.out.println(Main.GREEN+"Has cogido el Candelabro y te lo guardas en el inventario"+Main.RESET);
                    } else {
                        System.out.println("Ya tienes el Candelabro.");
                    }
                }




        }

        return false;

    }
}
