package org.example.Salas;

import org.example.Escaner;
import org.example.Jugador;

import java.util.ArrayList;

public abstract class Habitacion {
    String nombre;
    ArrayList<Object> opciones;
    transient Habitacion [] accesos;
    transient static public Habitacion[] habitaciones;
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

    public abstract Habitacion movimiento();

    public static Habitacion[] crearInfo(){
        habitaciones = new Habitacion[7];
        Vestibulo vestibulo = new Vestibulo("Vestibulo");
        Estudio estudio = new Estudio("Estudio");
        Invernadero invernadero = new Invernadero("Invernadero");
        SalaBillar salaBillar = new SalaBillar("Sala del Billar");
        Cocina cocina = new Cocina("Cocina");
        Salon salon = new Salon("Salón");
        Sotano sotano = new Sotano("Sótano");

        vestibulo.accesos = new Habitacion[]{estudio, cocina};
        estudio.accesos = new Habitacion[]{vestibulo, invernadero};
        invernadero.accesos = new Habitacion[]{estudio, salaBillar};
        salaBillar.accesos = new Habitacion[]{salon, cocina};
        salon.accesos = new Habitacion[]{salaBillar};
        cocina.accesos = new Habitacion[]{salaBillar, sotano, vestibulo};
        sotano.accesos = new Habitacion[]{cocina};

        habitaciones[0] = vestibulo;
        habitaciones[1] = estudio;
        habitaciones[2] = invernadero;
        habitaciones[3] = salaBillar;
        habitaciones[4] = cocina;
        habitaciones[5] = salon;
        habitaciones[6] = sotano;


        return habitaciones;
    }
    public boolean isDescubierta() {
        return descubierto;
    }

    public void setDescubierta(boolean descubierto) {
        this.descubierto = descubierto;
    }

    public abstract boolean acciones(Jugador j);

}
