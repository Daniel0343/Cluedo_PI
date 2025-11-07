package org.example.Dialogos;


public class Dialogo {
    private String nombre;
    private String dialogo;
    private String dialogo_lupa;
    private TipoDialogo tipo;

    public Dialogo(String nombre, String dialogo, String dialogo_lupa, TipoDialogo tipo) {
        this.nombre = nombre;
        this.dialogo = dialogo;
        this.dialogo_lupa = dialogo_lupa;
        this.tipo = tipo;
    }

    public String getDialogo_lupa() {
        return dialogo_lupa;
    }

    public void setDialogo_lupa(String dialogo_lupa) {
        this.dialogo_lupa = dialogo_lupa;
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
