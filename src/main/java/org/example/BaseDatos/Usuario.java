package org.example.BaseDatos;

public class Usuario {
    private String nombre;
    private String contrasena;

    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public boolean comprobarUsuario() {
        //Consultar en la base de datos si existe el usuario
        return false;
    }

    public void crearUsuario(){
        //Crear el nuevo usuario en la base de datos
    }

    public boolean validarUsuario(){
        //Comprobar que el usuario y contraseña son correctos para iniciar sesión
        return true;
    }

    public String getNombre(){
        return nombre;
    }
}
