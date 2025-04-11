package accesoadatos;

import logica.interfaces.IUsuarioDAO;
import logica.usuariosDTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO implements IUsuarioDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaUsuario = null;
    ResultSet resultadoConsultaUsuario;

    public boolean insertarUsuario(UsuarioDTO usuario) throws SQLException {

        String insertarSQLUsuario = "INSERT INTO usuario (idUsuario, nombre, apellidos, estadoActivo) VALUES (?, ?, ?, ?)";
        boolean usuarioInsertado = false;

        try {
            sentenciaUsuario = conexionBaseDeDatos.prepareStatement(insertarSQLUsuario);
            sentenciaUsuario.setInt(1, usuario.getIdUsuario());
            sentenciaUsuario.setString(2, usuario.getNombre());
            sentenciaUsuario.setString(3, usuario.getApellido());
            sentenciaUsuario.setInt(4, usuario.getEstado());
            sentenciaUsuario.executeUpdate();
            usuarioInsertado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al insertar el usuario: " + e.getMessage());
        }

        return usuarioInsertado;
    }

    public boolean eliminarUsuarioPorID(int idUsuario) throws SQLException {

        String eliminarSQLUsuario = "UPDATE usuario SET estadoActivo = ? WHERE idUsuario = ?";
        boolean usuarioEliminado = false;

        try {
            sentenciaUsuario = conexionBaseDeDatos.prepareStatement(eliminarSQLUsuario);
            sentenciaUsuario.setInt(1, 0);
            sentenciaUsuario.setInt(2, idUsuario);
            sentenciaUsuario.executeUpdate();
            usuarioEliminado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al eliminar el usuario: " + e.getMessage());
        }

        return usuarioEliminado;
    }

    public boolean modificarUsuario(UsuarioDTO usuario) throws SQLException {

        String modificarSQLUsuario = "UPDATE usuario SET nombre = ?, apellidos = ? WHERE idUsuario = ?";
        boolean usuarioModificado = false;

        try {

            sentenciaUsuario = conexionBaseDeDatos.prepareStatement(modificarSQLUsuario);
            sentenciaUsuario.setInt(3, usuario.getIdUsuario());
            sentenciaUsuario.setString(2, usuario.getApellido());
            sentenciaUsuario.setString(1, usuario.getNombre());
            sentenciaUsuario.executeUpdate();
            usuarioModificado = true;

        } catch (SQLException e) {

            throw new SQLException("Error al modificar el usuario: " + e.getMessage());
        }

        return usuarioModificado;
    }

    public UsuarioDTO buscarUsuarioPorID(int idUsuario) throws SQLException {

        String busquedaSQLUsuario = "SELECT * FROM usuario WHERE idUsuario = ?";
        UsuarioDTO usuarioEncontrado = null;

        try {

            sentenciaUsuario = conexionBaseDeDatos.prepareStatement(busquedaSQLUsuario);
            sentenciaUsuario.setInt(1, idUsuario);
            resultadoConsultaUsuario = sentenciaUsuario.executeQuery();

            while (resultadoConsultaUsuario.next()) {

                if (resultadoConsultaUsuario.getInt(1) == idUsuario) {

                    usuarioEncontrado = new UsuarioDTO(
                            resultadoConsultaUsuario.getInt(1),
                            resultadoConsultaUsuario.getString(2),
                            resultadoConsultaUsuario.getString(3),
                            resultadoConsultaUsuario.getInt(4)
                    );
                }
            }

        } catch (SQLException e) {

            throw new SQLException("Error al buscar el usuario: " + e.getMessage());
        }

        if (usuarioEncontrado == null) {

            usuarioEncontrado = new UsuarioDTO(-1);
        }

        return usuarioEncontrado;
    }
}