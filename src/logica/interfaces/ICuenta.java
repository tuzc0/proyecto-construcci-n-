package logica.interfaces;

import logica.usuariosDTO.CuentaDTO;
import java.sql.SQLException;

public interface ICuenta {

    boolean crearNuevaCuenta(CuentaDTO cuenta) throws SQLException;

    boolean eliminarCuentaPorID(int idUsuario) throws SQLException;

    boolean modificarCuenta(CuentaDTO usuario) throws SQLException;

    CuentaDTO buscarUsuarioPorID(int idUsuario) throws SQLException;
}
