package org.example;

import org.example.Salas.Habitacion;

import java.util.ArrayList;

public class Jugador {
    String nombre;
    Habitacion ubicacion;
    public Inventario inventario;



    public Jugador(String nombre, Habitacion vestibulo){
        this.nombre = nombre;
        this.ubicacion = vestibulo;
    }

    private void setUbicanción(Habitacion nuevaUbi) {
        this.ubicacion = nuevaUbi;
    }

    public void acciones(){
        System.out.println("¿Que quieres hacer en " +  ubicacion.getNombre()+"?   |  PRUEBA (1,2) \n1 - acciones en la habitación\n2 - Cambiar de habitación");
        int opcion = Escaner.entero();
        switch (opcion){
            case 1:
                System.out.println("ACCIONES");
                ubicacion.acciones(this);
                break;
            case 2:
                setUbicanción(ubicacion.movimiento());
                //Main.mostrarMapa(ubicacion.getNombre());
                break;
            default:
                System.out.println("Valor incorrecto, vuelve a intentarlo");
                acciones();
                break;
        }

    }


}
