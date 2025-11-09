package org.example.Salas;

import org.example.Dialogos.Grabadora;
import org.example.Escaner;
import org.example.Jugador;
import org.example.Objetos.Objeto;
import org.example.Pausa;
import org.example.Personajes.Personaje;

public class Sotano extends Habitacion{
    public Sotano(String nombre) {
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

        System.out.println("Bajas an lugar frío, húmedo y oscuro. Huele a moho y a tierra. Hay cajas viejas y herramientas.");
        Pausa.esperar(1000);
        Grabadora g = j.grabadora;

        System.out.println("\nElige una de las opciones:");
        System.out.println("1 - Hablar con el Profesor Mora");
        System.out.println("2 - Hablar con Amapola");
        System.out.println("3 - Inspeccionar Caja herramientas");
        System.out.println("4 - Ir al rincón oscuro");

        Pausa.esperar(1000);

        int opcion = Escaner.entero();

        switch (opcion){

            case 1:

                System.out.println("Ves a un hombre que parece preocupado, sentado en una silla a oscuras");
                Pausa.esperar(1000);
                System.out.println("Te acercas a el y parece que no se da cuenta de tu presencia");
                Pausa.esperar(1000);
                System.out.println("Desde un poco lejos, le preguntas porque esta en la mansión");
                Pausa.esperar(1000);
                System.out.println("Resulta que se llama Mora y que es profesor y investigador");
                Pausa.esperar(1000);
                System.out.println("De una de las universidades más imporantes, te dice:");
                Pausa.esperar(2000);
                Personaje p = new Personaje("Profesor Mora");

                g.addDialogo(p.getDialogo());
                System.out.println(p.getDialogo());

                System.out.println("Haces como si lo entendieses, y le preguntas que hace aquuí en el sotano");
                Pausa.esperar(2000);
                g.addDialogo(p.getDialogo_lupa());
                System.out.println(p.getDialogo_lupa());

            case 2:


                System.out.println("Hay una mujer tambien aquí abajo");
                Pausa.esperar(1000);
                System.out.println("Va de rojo y parece que como el profesor, está muy nerviosa");
                Pausa.esperar(1000);
                System.out.println("Te acercas a ella y intentas calmarla ");
                Pausa.esperar(1000);
                System.out.println("Por la oscuridad no se veia bien, pero ella es");
                Pausa.esperar(1000);
                System.out.println("Una de las actrices más famosas actualmente");
                Pausa.esperar(1000);
                System.out.println("Le preguntas que hace en la mansión, te dice:");
                Pausa.esperar(2000);

                Personaje p_a = new Personaje("Amapola");


                g.addDialogo(p_a.getDialogo());
                System.out.println(p_a.getDialogo());

                System.out.println("Te sorprendes, y le preguntas que hace aquuí en el sotano");
                Pausa.esperar(2000);
                g.addDialogo(p_a.getDialogo_lupa());
                System.out.println(p_a.getDialogo_lupa());

            case 3:

                System.out.println("A la esquina del sótano, ves una extraña caja de herramientas");
                Pausa.esperar(1000);
                System.out.println("Al abrirla, solo hay un tubo de metal fino y hueco, que parece dañado con quemaduras");
                Pausa.esperar(1000);
                System.out.println("Y que parece haber sido utilizado hace poco, pero no consigues ver más");
                Pausa.esperar(1000);
                System.out.println("Quieres coger la tubería? (s/n)");
                Pausa.esperar(1000);
                if (Escaner.sn()){
                    if (!j.inventario.contieneItem("Tubería")){
                        j.inventario.agregarItem(new Objeto("Tubería"));
                        Pausa.esperar(1000);
                        System.out.println("Has cogido la Tubería");
                    }else {
                        Pausa.esperar(1000);
                        System.out.println("Ya tienes la Tubería.");
                    }

                }

            case 4:

                System.out.println("En la otra esquina del, hay un hueco muy oscuro y una mesa bastante alta");
                Pausa.esperar(1000);
                System.out.println("Al asomarte por debajo, ves una cuerda muy sucia que esta muy al fondo");
                Pausa.esperar(1000);

                System.out.println("Quieres coger la cuerda? (s/n)");
                Pausa.esperar(1000);

                if (Escaner.sn()){
                    if (!j.inventario.contieneItem("Cuerda")){
                        j.inventario.agregarItem(new Objeto("Cuerda"));
                        Pausa.esperar(1000);
                        System.out.println("Has cogido la Cuerda");
                    }else {
                        Pausa.esperar(1000);
                        System.out.println("Ya tienes la Cuerda.");
                    }

                }





        }




    }
}
