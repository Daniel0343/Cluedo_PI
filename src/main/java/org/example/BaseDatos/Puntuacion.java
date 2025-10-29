package org.example.BaseDatos;

public class Puntuacion {
    private Usuario usuario;
    private int tiempo;

    public  Puntuacion(Usuario usuario, int tiempo) {
        this.usuario = usuario;
        this.tiempo = tiempo;
    }

    public void subirPuntuacion(){
        //Subir la puntuación a la base de datos
    }

    public String getNombre(){
        return usuario.getNombre();
    }
    public int getTiempo(){
        return tiempo;
    }
}
