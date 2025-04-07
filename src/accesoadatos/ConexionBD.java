package accesoadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    Connection conexion;
    LectorConfigBD LectorConfiguracion = new LectorConfigBD();

    public ConexionBD() {

        try {

            conexion = DriverManager.getConnection(LectorConfiguracion.getUrl(), LectorConfiguracion.getUsuario(),
                    LectorConfiguracion.getContraseña());

        } catch (SQLException e) {

            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public Connection getConnection() {

        return conexion;
    }
}