package accesoadatos.usuariosDAO;

import accesoadatos.ConexionBD;
import logica.interfaces.ICuentaDAO;
import logica.usuariosDTO.CuentaDTO;
import logica.usuariosDTO.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentaDAO implements ICuentaDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement consultaCuenta = null;
    ResultSet resultadoConsultaCuenta;

    public boolean crearNuevaCuenta(CuentaDTO cuenta) throws SQLException {

        String insertarSQLCuenta = "INSERT INTO cuenta VALUES(?, ?)";
        boolean usuarioInsertado = false;

        try {

            consultaCuenta = conexionBaseDeDatos.prepareStatement(insertarSQLCuenta);
            consultaCuenta.setString(1, cuenta.getCorreoElectronico());
            consultaCuenta.setString(2, cuenta.getContrasena());
            consultaCuenta.executeUpdate();
            usuarioInsertado = true;

        } catch (SQLException e) {

            throw new SQLException("Error al insertar la cuenta: " + e.getMessage());
        }

        return usuarioInsertado;
    }

    public boolean eliminarCuentaPorID(int idUsuario) throws SQLException {

        String eliminarSQLUsuario = "DELETE FROM usuario WHERE idUsuario = ?";
        boolean cuentaEliminada = false;

        try {

            consultaCuenta = conexionBaseDeDatos.prepareStatement(eliminarSQLUsuario);
            consultaCuenta.setInt(1, idUsuario);
            consultaCuenta.executeUpdate();
            cuentaEliminada = true;

        } catch (SQLException e) {

            throw new SQLException("Error al eliminar el usuario: " + e.getMessage());
        }

        return cuentaEliminada;
    }

    public boolean modificarCuenta(CuentaDTO cuenta) throws SQLException {

        String modificarSQLUsuario = "UPDATE cuenta SET correoElectronico = ?, contrasena = ? WHERE idUsuario = ?";
        boolean cuentaModificada = false;

        try {

            consultaCuenta = conexionBaseDeDatos.prepareStatement(modificarSQLUsuario);
            consultaCuenta.setString(1, cuenta.getCorreoElectronico());
            consultaCuenta.setString(2, cuenta.getContrasena());
            consultaCuenta.executeUpdate();
            cuentaModificada = true;

        } catch (SQLException e) {

            throw new SQLException("Error al modificar la cuenta: " + e.getMessage());
        }

        return cuentaModificada;
    }

    public CuentaDTO buscarCuentaPorID(int idUsuario) throws SQLException {

        String buscarSQLUsuario = "SELECT * FROM cuenta WHERE idUsuario = ?";
        CuentaDTO cuentaEncontrada = null;

        try {

            consultaCuenta = conexionBaseDeDatos.prepareStatement(buscarSQLUsuario);
            consultaCuenta.setInt(1, idUsuario);
            resultadoConsultaCuenta = consultaCuenta.executeQuery();

            while (resultadoConsultaCuenta.next()) {

                if (resultadoConsultaCuenta.getInt(1) == idUsuario) {

                    cuentaEncontrada = new CuentaDTO(
                            resultadoConsultaCuenta.getString(1),
                            resultadoConsultaCuenta.getString(2)
                    );
                }
            }

        } catch (SQLException e) {

            throw new SQLException("Error al buscar la cuenta: " + e.getMessage());
        }

        if (cuentaEncontrada == null) {

            cuentaEncontrada = new CuentaDTO(-1);
        }

        return cuentaEncontrada;
    }


}
