package org.example.Objetos;

public class Items {
    private String nombre;
    private String descripcion;
    private Tipo tipo;

    public Items(String nombre) {
        this.nombre = nombre;
        this.descripcion = Descripciones.getDescripciones().stream().filter(d -> d.getNombre().equalsIgnoreCase(nombre)).findFirst().get().getDescripcion();
        this.tipo = Descripciones.getDescripciones().stream().filter(d -> d.getNombre().equalsIgnoreCase(nombre)).findFirst().get().getTipo();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre+" | Descripcion: "+descripcion;
    }
}
