package org.example.Salas;

import org.example.Escaner;

import java.util.ArrayList;

public class Habitacion {
    String nombre;
    ArrayList<Object> opciones;
    Habitacion [] accesos;
    static public Habitacion[] habitaciones;
    boolean descubierto = false;

    public Habitacion(String nombre) {
        this.nombre = nombre;
        //this.opciones = asignaOpciones();
    }

    public Habitacion[] getAccesos() {
        return accesos;
    }

    public ArrayList<Object> getOpciones() {
        return opciones;
    }
    public void setOpciones(ArrayList<Object> opciones) {
        this.opciones = opciones;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {}

    private ArrayList<Object> asignaOpciones(ArrayList<Object> totalObjetos) {
        ArrayList<Object> opciones = new ArrayList<Object>();

        for(Object opcion : totalObjetos){
//            if (objeto.habitacion.equals(this.nombre)){
//                opciones.add(opcion);
//            }
        }
        return opciones;
    }




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

    public static Habitacion[] crearInfo(){
        habitaciones = new Habitacion[7];
        Habitacion vestibulo = new Habitacion("Vestibulo");
        Habitacion estudio = new Habitacion("Estudio");
        Habitacion invernadero = new Habitacion("Invernadero");
        Habitacion salaBillar = new Habitacion("Sala del Billar");
        Habitacion cocina = new Habitacion("Cocina");
        Habitacion salon = new Habitacion("Salón");
        Habitacion sotano = new Habitacion("Sótano");

        vestibulo.accesos = new Habitacion[]{estudio, cocina};
        estudio.accesos = new Habitacion[]{vestibulo, invernadero};
        invernadero.accesos = new Habitacion[]{estudio, salaBillar};
        salaBillar.accesos = new Habitacion[]{invernadero, salon};
        salon.accesos = new Habitacion[]{salaBillar, cocina};
        cocina.accesos = new Habitacion[]{salon, sotano, vestibulo};

        habitaciones[0] = vestibulo;
        habitaciones[1] = estudio;
        habitaciones[2] = invernadero;
        habitaciones[3] = salaBillar;
        habitaciones[4] = cocina;
        habitaciones[5] = salon;
        habitaciones[6] = sotano;


        return habitaciones;
    }
}
