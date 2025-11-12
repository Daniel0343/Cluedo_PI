package org.example.Salas;

import org.example.*;
import org.example.Dialogos.Dialogo;
import org.example.Dialogos.Dialogos;
import org.example.Dialogos.Grabadora;
import org.example.Dialogos.TipoDialogo;
import org.example.Objetos.Arma;
import org.example.Objetos.Objeto;
import org.example.Objetos.Tipo;

import java.util.Objects;

public class Estudio extends Habitacion {
    public Estudio(String nombre) {
        super(nombre);
    }

    @Override
    public Habitacion movimiento() {
        System.out.println();
        System.out.println(Main.BOLD +"Donde quieres ir?"+Main.RESET);
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
        System.out.println(Main.BOLD+"\nElige una de las opciones:"+Main.RESET);
        System.out.println("1 - Inspeccionar armadura");
        System.out.println("2 - Inspeccionar escritorio del Sr. Black");
        System.out.println("3 - Inspeccionar chimenea");
        System.out.println("4 - Inspeccionar armario");

        int opcion = Escaner.entero();

        switch (opcion) {
            case 1:
                Pausa.esperar(1000);
                System.out.println("Ves una armadura tirada en el suelo, como si alguien ha pasado coriendo y la ha tirado");
                Pausa.esperar(1000);
                System.out.println("Inspeccionas la armadura detenidamente y ves una"+ Main.BOLD+" pluma blanca "+Main.RESET +"que sobresale un poco. ¿Quieres cogerla? (s/n)");
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
                Pausa.esperar(1000);
                System.out.println("Encuentras un documento legal con un retrato del Dr. Black.");
                Pausa.esperar(1000);
                System.out.println("En él se lee por encima su fecha de nacimiento: "+ Main.RED+"12.03.1950."+Main.RESET);
                Pausa.esperar(1000);
                break;

            case 3:
                Pausa.esperar(1000);
                System.out.println("Te acercas a la chimenea. Entre las cenizas ves algo brillante.");
                System.out.println();
                if (j.inventario.contieneItem("Tubería")) {
                    Pausa.esperar(1000);
                    System.out.println("Con la ayuda de la tubería alcanzas el objeto brillante. Es una llave con forma de corazón. ¿Quieres cogerla? (s/n)");
                    if (Escaner.sn()) {
                        if (!j.inventario.contieneItem("Llave corazón")) {
                            j.inventario.agregarItem(new Objeto("Llave corazón"));
                            System.out.println(Main.GREEN+"Has cogido la Llave Corazón."+Main.RESET);
                        } else {
                            System.out.println("Ya tienes la llave corazón.");
                        }
                    }
                } else {
                    System.out.println("Parece que necesitas algo largo y resistente al fuego para alcanzarlo.");
                }
                break;

            case 4:
                Pausa.esperar(1000);
                System.out.println("Ves al fondo del estudio, un armario grande que parece bastante viejo");
                Pausa.esperar(1000);
                System.out.println("Intentas abrir el armario, pero está cerrado con una" +Main.RED+" cerradura en forma de corazón."+Main.RESET);
                Pausa.esperar(1000);
                if (j.inventario.contieneItem("Llave corazón")) {
                    System.out.println("Usas la llave corazón para abrir el armario...");
                    Pausa.esperar(1000);
                    System.out.println(Main.RED+"Dentro encuentras el cadáver del Dr. Black. 🕯️"+Main.RESET);
                    Pausa.esperar(1000);

                    System.out.println("Encuentras en uno de sus bolsillos una " +Main.RED+"carta "+Main.RESET);
                    Pausa.esperar(1000);
                    System.out.println("Quieres coger la carta? (s/n)");

                    if (Escaner.sn()){
                        if (!j.inventario.contieneItem("Carta amapola")){
                            j.inventario.agregarItem(new Objeto("Carta amapola"));
                            Pausa.esperar(1000);
                            System.out.println(Main.GREEN+"Has cogido la carta de amapola"+Main.RESET);

                        }else {
                            Pausa.esperar(1000);
                            System.out.println("Ya tienes la carta.");
                        }

                    }

                    if (j.inventario.contieneItem("Lupa")) {
                        Pausa.esperar(1000);
                        System.out.println("Con la lupa examinas el cuerpo entero del Dr. Black: "+Main.BOLD+"no hay marcas raras ni NINGUNA herida visible."+Main.RESET);
                        Pausa.esperar(2000);

                    }else {
                        Pausa.esperar(1000);
                        System.out.println("\n Encuentras la carta, pero la causa de la muerte sigue siendo un misterio visual.");
                    }

                    //Final llama policia y resolver asesinato

                    Pausa.esperar(1000);
                    System.out.println("Te das cuenta que al encontrar el cuerpo sin vida del SR Black");
                    Pausa.esperar(1000);
                    System.out.println("Y piensas que ya tienes que dar por acabado el caso para encontrar al asesino");

                    if (j.inventario.contieneItem("Lupa")) {
                        j.grabadora.addDialogo(new Arma("Revolver").getDialogo_lupa());
                        j.grabadora.addDialogo(new Arma("Veneno").getDialogo_lupa());
                        j.grabadora.addDialogo(new Arma("Candelabro").getDialogo_lupa());
                        j.grabadora.addDialogo(new Arma("Tubería").getDialogo_lupa());
                        j.grabadora.addDialogo(new Arma("Cuerda").getDialogo_lupa());
                        j.grabadora.addDialogo(new Arma("Cuchillo").getDialogo_lupa());

                    }

                    String opcion_resolver = "";
                    do {

                        Pausa.esperar(1000);
                        System.out.println("Elige una de estas opciones antes de dar tu testimonio");
                        Pausa.esperar(1000);
                        System.out.println("A la policía de quien es el ASESINO, en que LUGAR y con cual ARMA");
                        Pausa.esperar(2000);

                        System.out.println();
                        System.out.println(Main.BOLD+"1- Inventario Completo"+Main.RESET);
                        System.out.println(Main.BOLD+"2- Buscar objeto del inventario (Si tienes lupa)"+Main.RESET);
                        System.out.println(Main.BOLD+"3- Escuchar Grabadora"+Main.RESET);
                        System.out.println(Main.BOLD+"4- Resolver el misterio "+Main.RED+"(No retorno)"+Main.RESET);

                        opcion_resolver = Escaner.string();

                        switch (opcion_resolver) {

                            case "1":
                                Pausa.esperar(1000);
                                j.mostrarInventario();
                                break;

                            case "2":
                                Pausa.esperar(1000);
                                System.out.println("Que objeto del inventario quieres ver? ");
                                Pausa.esperar(1000);
                                j.mostrarInventario();

                                String objeto =  Escaner.string();

                                if (j.inventario.contieneItem(objeto)) {
                                    System.out.println(new Objeto(objeto).getDescripcion());
                                    if (j.inventario.contieneItem("Lupa")) {
                                        if (Dialogos.getDialogos().stream().filter(d -> d.getTipo() == TipoDialogo.ARMA && d.getNombre().equals(objeto)).count() > 0) {
                                            String d_lupa = Dialogos.getDialogos().stream().filter(o -> o.getNombre().equals(objeto)).findFirst().get().getDialogo_lupa();
                                            System.out.println(d_lupa);
                                            System.out.println();
                                            Pausa.esperar(1000);
                                        }

                                    }

                                }else {
                                    System.out.println("Ese objeto no existe en el inventario");
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
                                System.out.println();
                                System.out.println("\nDecides llamar ya a la polcia, y a la salida de la mansion");
                                Pausa.esperar(2000);
                                System.out.println("te reunes con todos los sospechosos y decides revelar delante de ellos y la policia");
                                Pausa.esperar(2000);
                                System.out.println("Quien es el asesino, donde ha matado al señor Black y con que arma");
                                Pausa.esperar(2000);
                                System.out.println("Asesino: ");
                                Pausa.esperar(2000);
                                System.out.println(Main.BOLD+"Rubio, Mora, Amapola, Orqídea, Celeste, Prado"+Main.RESET);
                                Pausa.esperar(1000);
                                String asesino = Escaner.string();

                                if (asesino.matches("Celeste")){
                                    System.out.println();
                                    System.out.println("Parece que has dado en el clavo");
                                    System.out.println(Main.MAGENTA+"+500 pts"+Main.RESET);
                                    asesino_boolean = true;

                                }else {
                                    Pausa.esperar(1000);
                                    System.out.println("El sospechoso "+asesino+ " te mira con preocupación cuando se lo lleva la policia");
                                }
                                Pausa.esperar(1000);
                                System.out.println(Main.BOLD+"Vestíbulo, Invernadero, Estudio, Sótano, Salón, Cocina, Billar"+Main.RESET);
                                Pausa.esperar(1000);
                                System.out.println("Lugar del asesinato: ");
                                Pausa.esperar(1000);
                                String lugar = Escaner.string();

                                if (lugar.matches("Invernadero")){
                                    Pausa.esperar(1000);
                                    System.out.println("SR Black fue verdaderamente asesinado en el invernadero y arrastrado hacia el estudio");
                                    System.out.println(Main.MAGENTA+"+500 pts"+Main.RESET);
                                    lugar_boolean = true;
                                }else {
                                    Pausa.esperar(1000);
                                    System.out.println("Solo has confundido más a las autoridades con el lugar: " + lugar);
                                }
                                Pausa.esperar(1000);
                                System.out.println(Main.BOLD+"Candelabro, Cuchillo, Revolver, Cuerda, Veneno,Tuberia"+Main.RESET);
                                Pausa.esperar(1000);
                                System.out.println("Y con cual arma: ");
                                String arma = Escaner.string();

                                if (arma.matches("Cuerda")){
                                    Pausa.esperar(1000);
                                    System.out.println("La cuerda fue una prueba esencial para resolver este misterio");
                                    System.out.println(Main.MAGENTA+"+500 pts"+Main.RESET);
                                    arma_boolean = true;
                                } else {
                                    System.out.println("Según la policia el " + arma + " no fue la causa de la muerte");
                                }

                                Main.finalJuego(j.getNombre(),j.grabadora,j.inventario, asesino_boolean,arma_boolean,lugar_boolean);
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
