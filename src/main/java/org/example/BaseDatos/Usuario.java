package org.example.BaseDatos;

import java.sql.*;

public class Usuario {

    public static boolean comprobarUsuario(String nombre) {
        //Consultar en la base de datos si existe el usuario
        try{
            Statement statement = ConexionBD.getConnection().createStatement();
            String query = "SELECT nombre FROM usuario";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                if (nombre.equals(resultSet.getString(1))){
                    return true;
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static boolean crearUsuario(String nombre, String contrasena){
        //Crear el nuevo usuario en la base de datos
        if (!comprobarUsuario(nombre)){
            try {
                PreparedStatement statement = ConexionBD.getConnection().prepareStatement("INSERT INTO usuario (nombre, contrasena) VALUES (?, ?)");
                statement.setString(1, nombre);
                statement.setString(2, contrasena);
                boolean insertado = 1 == statement.executeUpdate();
                if (insertado) {
                    return true;
                }
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public static boolean validarUsuario(String nombre, String contrasena){
        //Comprobar que el usuario y contraseña son correctos para iniciar sesión
        try{
            Statement statement = ConexionBD.getConnection().createStatement();
            String query = "SELECT nombre, contrasena FROM usuario";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                if (nombre.equals(resultSet.getString(1)) &&  contrasena.equals(resultSet.getString(2))){
                    return true;
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
