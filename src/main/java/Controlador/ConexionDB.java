
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
     private Connection conexion;
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/alumnoslogin";
    private final String USER = "root";
    private final String PASS = "";

    public Connection conectarBaseDatos() {
        try {
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Conexion establecida");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, "Error de conexion", ex);
        }
        return conexion;
    }

    public void cerrar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexion cerrada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, "Error al cerrar la conexion", ex);
        }
    }
    
       public static void main(String[] args) {
        ConexionDB conexionDB = new ConexionDB();
        conexionDB.conectarBaseDatos();
        conexionDB.cerrar();
    }
}
