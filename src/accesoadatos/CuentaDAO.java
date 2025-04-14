package accesoadatos;

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
    UsuarioDTO usuario = new UsuarioDTO();

    public boolean crearNuevaCuenta(CuentaDTO cuenta) throws SQLException {

        String insertarSQLCuenta = "INSERT INTO cuenta VALUES(?, ?)";
        boolean usuarioInsertado = false;

        try {

            consultaCuenta = conexionBaseDeDatos.prepareStatement(insertarSQLCuenta);
            consultaCuenta.setString(1, cuenta.getCorreoElectronico());
            consultaCuenta.setString(2, cuenta.getContrasena());
            consultaCuenta.executeUpdate();
            usuarioInsertado = true;

        } finally {

            if (consultaCuenta != null) {

                consultaCuenta.close();
            }
        }

        return usuarioInsertado;
    }

    public boolean eliminarCuentaPorID(int idUsuario) throws SQLException {

        String eliminarSQLUsuario = "UPDATE usuario SET estadoActivo = ? WHERE idUsuario = " +
                "(SELECT idUsuario FROM cuenta WHERE idUsuario = ?)";
        boolean cuentaEliminada = false;

        try {

            consultaCuenta = conexionBaseDeDatos.prepareStatement(eliminarSQLUsuario);
            consultaCuenta.setInt(1, idUsuario);
            consultaCuenta.executeUpdate();
            cuentaEliminada = true;

        } finally {

            if (consultaCuenta != null) {

                consultaCuenta.close();
            }
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

        } finally {

            if (consultaCuenta != null) {

                consultaCuenta.close();
            }
        }

        return cuentaModificada;
    }

    public CuentaDTO buscarCuentaPorID(int idUsuario) throws SQLException {

        String buscarSQLUsuario = "SELECT * FROM cuenta WHERE idUsuario = ?";
        CuentaDTO cuentaEncontrada = new CuentaDTO("N/A","N/A");

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

        } finally {

            if (consultaCuenta != null) {

                consultaCuenta.close();
            }
        }

        return cuentaEncontrada;
    }
}
