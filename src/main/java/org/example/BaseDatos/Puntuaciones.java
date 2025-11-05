package org.example.BaseDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Puntuaciones {
    public static void mostrarPuntuaciones() {
        try {
            Statement statement = ConexionBD.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM puntuaciones ORDER BY id DESC LIMIT 10");
            System.out.printf("%-5s %-20s %-10s\n", "id", "nombre", "puntos");
            System.out.println("-------------------------------------------");
            while (resultSet.next()) {
                System.out.printf("%-5d %-10s %-8d", resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
