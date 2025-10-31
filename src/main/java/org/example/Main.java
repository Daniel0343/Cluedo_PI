package org.example;


import org.example.Salas.Habitacion;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Habitacion.crearInfo();
        Jugador j = new Jugador("nombre", Habitacion.habitaciones[0]);

        while (true) {
            j.acciones();
        }
    }

}
