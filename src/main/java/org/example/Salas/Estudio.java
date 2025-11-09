package org.example.Salas;

import org.example.*;
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
    public boolean acciones(Jugador j) {
        System.out.println("\nElige una de las opciones:");
        System.out.println("1 - Inspeccionar armadura");
        System.out.println("2 - Inspeccionar escritorio del Sr. Black");
        System.out.println("3 - Inspeccionar chimenea");
        System.out.println("4 - Inspeccionar armario");

        int opcion = Escaner.entero();

        switch (opcion) {
            case 1:
                System.out.println("Ves una armadura tirada en el suelo, como si alguien ha pasado coriendo y la ha tirado");
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
                System.out.println("Ves al fondo del estudio, un armario grande que parece bastante viejo");
                Pausa.esperar(1000);
                System.out.println("Intentas abrir el armario, pero está cerrado con una cerradura en forma de corazón.");
                Pausa.esperar(1000);
                if (j.inventario.contieneItem("Llave corazón")) {
                    System.out.println("Usas la llave corazón para abrir el armario...");
                    Pausa.esperar(1000);
                    System.out.println("Dentro encuentras el cadáver del Dr. Black. 🕯️");
                    Pausa.esperar(1000);

                    System.out.println("Encuentras en uno de sus bolsillos una carta ");
                    Pausa.esperar(1000);
                    System.out.println("Quieres coger la carta? (s/n)");

                    if (Escaner.sn()){
                        if (!j.inventario.contieneItem("Carta amapola")){
                            j.inventario.agregarItem(new Objeto("Carta amapola"));
                            Pausa.esperar(1000);
                            System.out.println("Has cogido la carta de amapola");

                        }else {
                            Pausa.esperar(1000);
                            System.out.println("Ya tienes la carta.");
                        }

                    }

                    if (j.inventario.contieneItem("Lupa")) {

                        System.out.println("Con la lupa examinas el cuello del Dr. Black: no hay marcas raras ni NINGUNA herida visible.");
                        Pausa.esperar(1000);

                    }else {
                        Pausa.esperar(1000);
                        System.out.println("\n Encuentras la carta, pero la causa de la muerte sigue siendo un misterio visual.");
                    }

                    //Final llama policia y resolver asesinato

                    Pausa.esperar(1000);
                    System.out.println("Te das cuenta que al encontrar el cuerpo sin vida del SR Black");
                    Pausa.esperar(1000);
                    System.out.println("Y piensas que ya tienes que dar por acabado el caso para encontrar al asesino");

                    String opcion_resolver = "";
                    do {

                        System.out.println("Elige una de estas opciones antes de dar tu testimonio");
                        Pausa.esperar(1000);
                        System.out.println("A la policía de quien es el ASESINO, en que LUGAR y con cual ARMA");
                        Pausa.esperar(2000);

                        System.out.println("1- Inventario Completo");
                        System.out.println("2- Buscar objeto del inventario");
                        System.out.println("3- Escuchar Grabadora");
                        System.out.println("4- Resolver el misterio(No retorno)");

                        opcion_resolver = Escaner.string();

                        switch (opcion_resolver) {

                            case "1":

                                j.mostrarInventario();
                                break;

                            case "2":

                                System.out.println("Que objeto del inventario quieres ver? ");
                                j.mostrarInventario();

                                String objeto =  Escaner.string();

                                if (j.inventario.contieneItem(objeto)) {
                                    System.out.println(new Objeto(objeto).getDescripcion());

                                }else {
                                    System.out.println("Ese objeto no existe");
                                }

                                break;


                            case "3":


                                j.mostrarGrabadora();

                                break;

                            case "4":
                                Boolean asesino_boolean = false;
                                Boolean arma_boolean = false;
                                Boolean lugar_boolean = false;

                                Pausa.esperar(1000);
                                System.out.println("\nDecides llamar ya a la polcia, y a la salida de la mansion");
                                Pausa.esperar(1000);
                                System.out.println("te reunes con todos los sospechosos y decides revelar delante de ellos y la polcia");
                                Pausa.esperar(1000);
                                System.out.println("Quien es el asesino, donde ha matado al señor Black y con que arma");
                                Pausa.esperar(1000);
                                System.out.println("Asesino: ");
                                Pausa.esperar(1000);
                                System.out.println("Rubio, Mora, Amapola, Orqídea, Celeste, Prado");
                                Pausa.esperar(1000);
                                String asesino = Escaner.string();

                                if (asesino.matches("Celeste")){
                                    System.out.println("Parece que has dado en el clavo");
                                    asesino_boolean = true;

                                }else {
                                    System.out.println("El sospechoso "+asesino+ " te mira con preocupación cuando se lo lleva la policia");
                                }
                                Pausa.esperar(1000);
                                System.out.println("Vestíbulo, Invernadero, Estudio, Sótano, Salón, Cocina, Billar");
                                Pausa.esperar(1000);
                                System.out.println("Lugar del asesinato: ");
                                Pausa.esperar(1000);
                                String lugar = Escaner.string();

                                if (lugar.matches("Invernadero")){
                                    System.out.println("SR Black fue verdaderamente asesesinado en el invernadero y arrastrado hacia el estudio");
                                    lugar_boolean = true;
                                }else {
                                    System.out.println("Solo has confundido más a las autoridades con el lugar: " + lugar);
                                }

                                System.out.println("Candelabro, Cuchillo, Revolver, Cuerda, Veneno,Tuberia");
                                System.out.println("Y con cual arma: ");
                                String arma = Escaner.string();

                                if (arma.matches("Cuerda")){
                                    System.out.println("La cuerda fue una prueba esencial para resolver este misterio");
                                    arma_boolean = true;
                                } else {
                                    System.out.println("Según la policia el " + arma + " no fue la causa de la muerte");
                                }

                                Main.finalJuego(nombre,j.grabadora,j.inventario, asesino_boolean,arma_boolean,lugar_boolean);
                                return true;










                        }


                    }while (!opcion_resolver.matches("4"));








                    System.out.println("El misterio empieza a tomar forma...");
                } else {
                    System.out.println("No tienes la llave adecuada. Quizás esté en algún otro lugar.");
                }
                break;

            default:
                System.out.println("Opción inválida, vuelve a intentarlo.");
                break;
        }
        return false;
    }
}
