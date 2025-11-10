package org.example.BaseDatos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Puntuacion {

    public static void subirPuntuacion(String nombre, int puntos){
        //Subir la puntuación a la base de datos

        if (Usuario.comprobarUsuario(nombre)){


            try{
                PreparedStatement statement = ConexionBD.getConnection().prepareStatement("INSERT INTO puntuaciones (nombre, puntos) VALUES (?, ?)");
                statement.setString(1, nombre);
                statement.setInt(2, puntos);
                statement.executeUpdate();


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
