package org.example.Salas;

import org.example.Dialogos.Grabadora;
import org.example.Escaner;
import org.example.Jugador;
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
        Scanner sc = new Scanner(System.in);

        Grabadora g = new Grabadora();
        System.out.println("Hablar con Prado");
        System.out.println("Inspeccionar retrato Dr.Black");
        System.out.println("Inspeccionar mesita del salón");

        int opcion = Escaner.entero();

        switch (opcion) {

            case 1:
                System.out.println("Ves en el sofa del salon sentado a uno de los invitados");
                Pausa.esperar(1000);
                System.out.println("Parece estar leyendo un libro y no te presta mucha atención ");
                Pausa.esperar(1000);
                System.out.println("Le preguntas que quien es y resulta ser el abogado");
                Pausa.esperar(1000);
                System.out.println("Más famoso que hay por estas zonas");
                System.out.println("Le dices porque está en la masnsion y te contexta sin mucho empeño: ");
                Pausa.esperar(1000);
                Personaje p = new Personaje("Prado");
                g.addDialogo(p.getDialogo());

                System.out.println(p.getDialogo());

                System.out.println("No entiendes nada de lo que dice, aceptas su tarjeta");
                Pausa.esperar(1000);
                System.out.println("Y le pregutas que hacía aquí cuando se produjo el apagón");
                System.out.println(p.getDialogo_lupa());
                g.addDialogo(p.getDialogo_lupa());

                break;

            case 2:

                System.out.println("Te fijas bien en el retrato porque te recuerda");
                Pausa.esperar(1000);
                System.out.println("Al de la foto que viste en el escritorio del estudio");
                Pausa.esperar(1000);
                System.out.println("Que al mirarlo de cerca te das cuenta que hay un boton");
                Pausa.esperar(1000);
                System.out.println("Se ve muy poco pero lo presionas");
                Pausa.esperar(1000);

                System.out.println("-- PUZZLE --");
                String resultado = "12031950";
                System.out.println("Se mueve el cuadro y aparece una pequeña caja fuerte");
                System.out.println("Parece que necesitas introducir un codigo de 8 cifras para abrirlo");
                System.out.println("Hay una nota que pone: La fecha que todos siempre nos acordamos es la que es");
                Pausa.esperar(1000);

                System.out.println("Introduce el codigo");
                String us = sc.nextLine();

                if (us.matches("12031950")){

                    System.out.println("-- PUZZLE RESUELTO --");

                    System.out.println("Dentro de la caja fuerte hay, un pequeño anillo rojo, lo coges (si/no)");
                    if (Escaner.sn()){
                        if (!j.inventario.contieneItem("Anillo Rojo")){
                            j.inventario.agregarItem(new Objeto("Anillo Rojo"));
                            System.out.println("Has cogido el Anillo Rojo y te lo guardas en el inventario");
                        } else {
                            System.out.println("Ya tienes el Anillo Rojo.");
                        }
                    }


                }else {
                    System.out.println("Codigo introducido incorrecto");
                }

            case 3:

                System.out.println("Ves que sobre la mesita de mármol, encuentras movido");
                Pausa.esperar(1000);
                System.out.println("Un candelabro que parece pesado");
                Pausa.esperar(1000);
                System.out.println("Lo coges (si/no)");


                if (Escaner.sn()){
                    if (!j.inventario.contieneItem("Candelabro")){
                        j.inventario.agregarItem(new Objeto("Candelabro"));
                        System.out.println("Has cogido el Candelabro y te lo guardas en el inventario");
                    } else {
                        System.out.println("Ya tienes el Candelabro.");
                    }
                }




        }



    }
}
