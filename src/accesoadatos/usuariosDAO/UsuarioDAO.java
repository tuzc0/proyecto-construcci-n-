package accesoadatos.usuariosDAO;

import accesoadatos.ConexionBD;
import logica.interfaces.IUsuarioDAO;
import logica.usuariosDTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class UsuarioDAO implements IUsuarioDAO {
    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaUsuario = null;
    ResultSet resultadoConsultaUsuario;

    public boolean insertarUsuario(UsuarioDTO usuario) throws SQLException {

        String insertarSQLUsuario = "INSERT INTO usuario VALUES(?, ?, ?)";
        boolean usuarioInsertado = false;

        try {

            sentenciaUsuario = conexionBaseDeDatos.prepareStatement(insertarSQLUsuario);

            sentenciaUsuario.setInt(1, usuario.getIdUsuario());
            sentenciaUsuario.setString(2, usuario.getNombre());
            sentenciaUsuario.setString(3, usuario.getApellido());
            sentenciaUsuario.executeUpdate();
            usuarioInsertado = true;

        } catch (SQLException e) {

            throw new SQLException("Error al insertar el usuario: " + e.getMessage());
        }

        return usuarioInsertado;
    }

    public boolean eliminarUsuarioPorID(int idUsuario) throws SQLException {

        String eliminarSQLUsuario = "DELETE FROM usuario WHERE idUsuario = ?";
        boolean usuarioEliminado = false;

        try {
            sentenciaUsuario = conexionBaseDeDatos.prepareStatement(eliminarSQLUsuario);
            sentenciaUsuario.setInt(1, idUsuario);
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

    public boolean buscarUsuarioPorID(int idUsuario) throws SQLException {

        String busquedaSQLUsuario = "SELECT * FROM usuario where idUsuario = ?";
        boolean encontrado = false;

        try {

            ResultSet resultadoConsulta = sentenciaUsuario.executeQuery();
            resultadoConsulta =
        }
    }
}