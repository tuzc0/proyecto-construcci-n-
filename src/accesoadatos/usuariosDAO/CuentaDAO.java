package accesoadatos.usuariosDAO;

import accesoadatos.ConexionBD;
import logica.usuariosDTO.CuentaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO {

    public boolean insertarCuenta(CuentaDTO cuenta) throws SQLException {

        String insertarSQLCuenta = "INSERT INTO cuenta VALUES(?, ?)";

        try (Connection conexionBaseDeDatos = new ConexionBD().getConnection();
             PreparedStatement consultarInsertarCuenta = conexionBaseDeDatos.prepareStatement(insertarSQLCuenta)) {

            consultarInsertarCuenta.setString(1, cuenta.getCorreoElectronico());
            consultarInsertarCuenta.setString(2, cuenta.getContrasena());
            consultarInsertarCuenta.setInt (3, cuenta. getIdUsuario());
            consultarInsertarCuenta.executeUpdate();
            return true;
        }
    }
}
