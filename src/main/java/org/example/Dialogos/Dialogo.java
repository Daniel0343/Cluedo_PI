package org.example.Dialogos;


public class Dialogo {
    private String nombre;
    private String dialogo;
    private TipoDialogo tipo;

    public Dialogo(String nombre, String dialogo, TipoDialogo tipo) {
        this.nombre = nombre;
        this.dialogo = dialogo;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDialogo() {
        return dialogo;
    }
    public void setDialogo(String dialogo) {
        this.dialogo = dialogo;
    }
    public TipoDialogo getTipo() {
        return tipo;
    }
    public void setTipo(TipoDialogo tipo) {
        this.tipo = tipo;
    }
}
