package org.example;


import org.example.Salas.Habitacion;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Habitacion.crearInfo();

        System.out.println("Empieza el juego. Sala oscura.");
        boolean apagada = true;
        boolean linterna = false;
        boolean llave = false;
        while (apagada) {
            System.out.println("Elige una opción");
            System.out.println("1 - Opción");
            System.out.println("2 - Opción");
            System.out.println("3 - Opción");
            int opcion = Escaner.entero();
            switch (opcion) {
                case 1:
                    System.out.println("Has chocado contra algo, no distingues bien que es");
                    if (linterna) {
                        System.out.println("Con la linterna consigues diferenciar un mueble, debajo del mueble ves una llave con forma de triángulo. ¿La coges? (s/n)");
                        String eleccion = Escaner.string();
                        if (eleccion.equals("s")) {
                            System.out.println("Llave recogida");
                            llave = true;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Te has chocado con lo que parece un mueble, abres un cajón y distingues un objeto, lo cojes? (s/n)");
                    String eleccion = Escaner.string();
                    if (eleccion.equals("s")) {
                        System.out.println("Has cojado el objeto, es una linterna");
                        linterna = true;
                    }
                    break;
                case 3:
                    System.out.println("Covas contra algo, no distingues bien que es");
                    if (linterna) {
                        System.out.println("Con la linterna consigues diferenciar que es un cuadro de luz, pero está cerrado con llave, la cerradura tiene forma de triangulo");
                        if (llave) {
                            System.out.println("Quieres probar a abrir la cerradura con la llave? (s/n)");
                            String eleccion2 = Escaner.string();

                            if (eleccion2.equals("s")) {
                                System.out.println("Abres la cerradura");
                                System.out.println("Enfocas con la linterna y ves una palanca hacia abajo, la quieres levantar? (s/n)");

                                String eleccion3 = Escaner.string();
                                if (eleccion3.equals("s")) {
                                    System.out.println("Levantas la palanca. Al instante un brillo extremo te sorprende, has encedido la luz de la habitación. Te encuentras en el vestibulo");
                                    apagada = false;
                                }
                            }
                        }else{
                            System.out.println("No tienes forma de abrir la cerradura");
                        }
                    }

                    break;
            }
        }
        Jugador j = new Jugador("nombre", Habitacion.habitaciones[0]);

        while (true) {
            j.acciones();
        }
    }

}
