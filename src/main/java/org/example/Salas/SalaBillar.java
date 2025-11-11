package org.example.Salas;

import org.example.*;
import org.example.Dialogos.Grabadora;
import org.example.Objetos.Arma;
import org.example.Objetos.Objeto;
import org.example.Personajes.Personaje;

public class SalaBillar extends Habitacion{
    private boolean puzzleResuelto = false;
    static boolean abierta = false;
    public SalaBillar(String nombre) {
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

        System.out.println(Main.BOLD+"\nElige una de las opciones:"+Main.RESET);
        System.out.println("1 - Hablar con Orquidea");
        System.out.println("2 - Hablar con Rubio");
        System.out.println("3 - Inspeccionar Bar");
        System.out.println("4 - Inspeccionar Diana");
        System.out.println("5 - Investigar Puzzle");
        Pausa.esperar(1000);

        int opcion = Escaner.entero();

        switch (opcion) {

            case 1:

                System.out.println(Main.YELLOW+"A primera vista a la izquierda de la sala del billar"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Ves a una mujer asiatica vestida de negro, con una copa en la mano"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Sentada en lo que parece ser un mini bar de la zona del billar"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Se da la vuelta y te mira, parece confundida como si no deberias estar allí"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Le preguntas que que hace aquí, y te responde:"+Main.RESET);
                Pausa.esperar(1000);
                Personaje p_orquidea = new Personaje("Orquídea");
                g.addDialogo(p_orquidea.getDialogo());
                System.out.println();
                System.out.println(p_orquidea.getDialogo());
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Entiendes su argumento pero le preguntas que hacía aquí cuando se produjo el apagón"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(p_orquidea.getDialogo_lupa());
                g.addDialogo(p_orquidea.getDialogo_lupa());

                Pausa.esperar(1000);

                break;

            case 2:

                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Te acercas al fondo de la sala y ves a un hombre mayor, te mira fijamente"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Está apoyado en la parez fumando de una pipa, el olor esta repartido por toda la sala"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Se te acerca y te dice que se llama Rubio y que es uno de los invitados"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Le preguntas que que hace aquí, y te responde:"+Main.RESET);
                System.out.println();
                Personaje p_rubio = new Personaje("Rubio");
                g.addDialogo(p_rubio.getDialogo());

                System.out.println(p_rubio.getDialogo());
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Entiendes su argumento pero le preguntas que hacía aquí cuando se produjo el apagón"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(p_rubio.getDialogo_lupa());
                g.addDialogo(p_rubio.getDialogo_lupa());

                Pausa.esperar(1000);

                break;


            case 3:

                System.out.println("En el mini bar donde está orquidea, te fijas q hay una pequeña botella");
                Pausa.esperar(1000);
                System.out.println("detras de una botella de ginebra cara grande");
                Pausa.esperar(1000);
                System.out.println("es una botellita gris con una foto de calavera incrustada en ella");
                Pausa.esperar(1000);
                System.out.println("Parece "+Main.RED+" veneno "+Main.RESET+"¿Quieres cogerlo? (s/n)");
                Pausa.esperar(1000);

                if (Escaner.sn()){
                    if (!j.inventario.contieneItem("Veneno")){
                        j.inventario.agregarItem(new Objeto("Veneno"));
                        j.grabadora.addDialogo(new Arma("Veneno").getDialogo());
                        System.out.println(Main.GREEN+"Has cogido el veneno y lo guardas en tu inventario."+Main.RESET);
                    }else {
                        System.out.println("Ya tienes el veneno.");
                    }

                }

                break;

            case 4:


                System.out.println("Al pasar al lado de rubio, tiene al lado una diana vieja");
                Pausa.esperar(1000);
                System.out.println("En el que hay un "+Main.RED+"cuchillo "+Main.RESET+" clavado en el medio de la diana");
                Pausa.esperar(1000);
                System.out.println("Parece ser como un cuchillo de cocina ¿Quieres cogerlo? (s/n)");
                Pausa.esperar(1000);

                if (Escaner.sn()){
                    if (!j.inventario.contieneItem("Cuchillo")){
                        j.inventario.agregarItem(new Objeto("Cuchillo"));
                        j.grabadora.addDialogo(new Arma("Cuchillo").getDialogo());
                        System.out.println(Main.GREEN+"Has cogido el cuchillo y te lo guardas en el inventario"+Main.RESET);
                    } else {
                        System.out.println("Ya tienes el cuchillo.");
                    }
                }

                break;


            case 5:

                System.out.println("Ves en la mesa de billar del centro que abajo hay una nota pegada");
                Pausa.esperar(1000);
                System.out.println("Te acercas para ver que es:");
                Pausa.esperar(1000);


                if (Puzles.puzle_billar()){

                    System.out.println();
                    System.out.println("Coges la lupa");
                    Pausa.esperar(1000);

                    if (Escaner.sn()){

                        if (!j.inventario.contieneItem("Lupa")){
                            j.inventario.agregarItem(new Objeto("Lupa"));
                            System.out.println(Main.GREEN+"Has cogido la lupa y lo guardas en tu inventario."+Main.RESET);
                        }else {
                            System.out.println("Ya tienes el Lupa.");
                        }

                    }


                }else {
                    System.out.println("Puzzle no resuelto");
                }





        }

        return false;



    }
}
