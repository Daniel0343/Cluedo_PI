package org.example.Salas;

import org.example.Dialogos.Grabadora;
import org.example.Escaner;
import org.example.Jugador;
import org.example.Main;
import org.example.Objetos.Arma;
import org.example.Objetos.Objeto;
import org.example.Pausa;
import org.example.Personajes.Personaje;

public class Sotano extends Habitacion{
    public Sotano(String nombre) {
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

        System.out.println("Bajas an lugar frío, húmedo y oscuro. Huele a moho y a tierra. Hay cajas viejas y herramientas.");
        Pausa.esperar(1000);
        Grabadora g = j.grabadora;

        System.out.println(Main.BOLD+"\nElige una de las opciones:"+Main.RESET);
        System.out.println("1 - Hablar con el Profesor Mora");
        System.out.println("2 - Hablar con Amapola");
        System.out.println("3 - Inspeccionar Caja herramientas");
        System.out.println("4 - Ir al rincón oscuro");

        Pausa.esperar(1000);

        int opcion = Escaner.entero();

        switch (opcion){

            case 1:

                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Ves a un hombre que parece preocupado, sentado en una silla a oscuras"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Te acercas a el y parece que no se da cuenta de tu presencia"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Desde un poco lejos, le preguntas porque esta en la mansión"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Resulta que se llama Mora y que es profesor y investigador"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"De una de las universidades más importantes, te dice:"+Main.RESET);
                Pausa.esperar(2000);
                Personaje p = new Personaje("Profesor Mora");

                g.addDialogo(p.getDialogo());
                System.out.println(p.getDialogo());

                System.out.println(Main.YELLOW+"Haces como si lo entendieses, y le preguntas que hace aquí en el sótano"+Main.RESET);
                Pausa.esperar(2000);
                g.addDialogo(p.getDialogo_lupa());
                System.out.println(p.getDialogo_lupa());
                    break;
            case 2:


                System.out.println(Main.YELLOW+"Hay una mujer tambien aquí abajo"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Va de rojo y parece que como el profesor, está muy nerviosa"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Te acercas a ella y intentas calmarla "+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Por la oscuridad no se veia bien, pero ella es"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Una de las actrices más famosas actualmente"+Main.RESET);
                Pausa.esperar(1000);
                System.out.println(Main.YELLOW+"Le preguntas que hace en la mansión, te dice:"+Main.RESET);
                Pausa.esperar(2000);

                Personaje p_a = new Personaje("Amapola");


                g.addDialogo(p_a.getDialogo());
                System.out.println(p_a.getDialogo());

                System.out.println(Main.YELLOW+"Te sorprendes, y le preguntas que hace aquí en el sotano"+Main.RESET);
                Pausa.esperar(2000);
                g.addDialogo(p_a.getDialogo_lupa());
                System.out.println(p_a.getDialogo_lupa());

                break;

            case 3:

                System.out.println("A la esquina del sótano, ves una extraña caja de herramientas");
                Pausa.esperar(1000);
                System.out.println("Al abrirla, solo hay un "+Main.RED+"tubo de metal "+Main.RESET+"fino y hueco, que parece dañado con quemaduras");
                Pausa.esperar(1000);
                System.out.println("Y que parece haber sido utilizado hace poco, pero no consigues ver más");
                Pausa.esperar(1000);
                System.out.println("Quieres coger la tubería? (s/n)");
                Pausa.esperar(1000);
                if (Escaner.sn()){
                    if (!j.inventario.contieneItem("Tubería")){
                        j.inventario.agregarItem(new Objeto("Tubería"));
                        j.grabadora.addDialogo(new Arma("Tubería").getDialogo());
                        Pausa.esperar(1000);
                        System.out.println(Main.GREEN+"Has cogido la Tubería"+Main.RESET);
                    }else {
                        Pausa.esperar(1000);
                        System.out.println("Ya tienes la Tubería.");
                    }

                }
                break;
            case 4:

                System.out.println("En la otra esquina del, hay un hueco muy oscuro y una mesa bastante alta");
                Pausa.esperar(1000);
                System.out.println("Al asomarte por debajo, ves una "+Main.RED+"cuerda "+Main.RESET+" muy sucia que esta muy al fondo");
                Pausa.esperar(1000);

                System.out.println("Quieres coger la cuerda? (s/n)");
                Pausa.esperar(1000);

                if (Escaner.sn()){
                    if (!j.inventario.contieneItem("Cuerda")){
                        j.inventario.agregarItem(new Objeto("Cuerda"));
                        j.grabadora.addDialogo(new Arma("Cuerda").getDialogo());
                        Pausa.esperar(1000);
                        System.out.println(Main.GREEN+"Has cogido la Cuerda"+Main.RESET);
                    }else {
                        Pausa.esperar(1000);
                        System.out.println("Ya tienes la Cuerda.");
                    }

                }



                break;

        }

        return false;


    }
}
