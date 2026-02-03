package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
   
    //hacer conexion a la base de datos
    public static Connection Conectar() {
        Connection conexion = null;
        try {
            String url = "jdbc:mysql://localhost:3306/Digital-Stock";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return conexion;
    }
    
    //cerrar la conexion
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión:");
            }
        }
    }
    
}
