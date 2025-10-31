package org.example.BaseDatos;

public class Puntuacion {
    private Usuario usuario;
    private int puntuacion;

    public  Puntuacion(Usuario usuario, int puntuacion) {
        this.usuario = usuario;
        this.puntuacion = puntuacion;
    }

    public void subirPuntuacion(){
        //Subir la puntuación a la base de datos
    }

    public String getNombre(){
        return usuario.getNombre();
    }
    public int getPuntuacion(){
        return puntuacion;
    }
}
