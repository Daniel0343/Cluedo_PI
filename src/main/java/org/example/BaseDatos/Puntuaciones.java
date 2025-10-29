package org.example.BaseDatos;

import java.util.ArrayList;

public class Puntuaciones {
    public static void mostrarPuntuaciones(){
        ArrayList<Puntuacion> puntuaciones = new ArrayList<>();
        //Obtener puntuaciones de la base de datos




        puntuaciones.forEach(p -> {
            System.out.println("Usuario: "+p.getNombre()+" Tiempo: "+p.getTiempo());
        });
    }



}
