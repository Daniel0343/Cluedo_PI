package org.example.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static Connection conn = null;

    // Declaramos los datos de conexion a la bd
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String user="if0_40284755";
    private static final String pass="2mrHJ4tD89";
    private static final String url="jdbc:mysql://sql309.infinityfree.com/if0_40284755_cluedo";

    private ConexionBD(){
        try{
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        if (conn==null){
            new ConexionBD();
        }
        return conn;
    }

    public static void closeConnection(){
        try{
            if (conn != null){
                conn.close();
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

}
