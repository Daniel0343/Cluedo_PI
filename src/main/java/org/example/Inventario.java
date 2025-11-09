package org.example;

import org.example.Objetos.Items;

import java.util.ArrayList;

public class Inventario {
    ArrayList<Items> inventario;

    public Inventario() {
        inventario = new ArrayList<>();
    }

    public ArrayList<Items> getInventario() {
        return inventario;
    }

    public boolean contieneItem(String nombre) {
        return inventario.stream().anyMatch(d -> d.getNombre().equals(nombre));
    }

    public void agregarItem(Items item) {
        if (!contieneItem(item.getNombre())) {
            inventario.add(item);
        }
    }
    public void mostrarInventario() {
        inventario.stream().forEach(System.out::println);
    }
}
