package logica.interfaces;

import logica.usuariosDTO.UsuarioDTO;
import java.sql.SQLException;

public interface IUsuarioDAO {

    boolean insertarUsuario(UsuarioDTO usuario) throws SQLException;

    boolean eliminarUsuarioPorID(int idUsuario) throws SQLException;

    boolean modificarUsuario(UsuarioDTO usuario) throws SQLException;

    UsuarioDTO buscarUsuarioPorID(int idUsuario) throws SQLException;
}
