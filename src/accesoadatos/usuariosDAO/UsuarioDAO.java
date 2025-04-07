package accesoadatos.usuariosDAO;

import accesoadatos.ConexionBD;
import logica.usuariosDTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class UsuarioDAO {

    public boolean insertarUsuario(UsuarioDTO usuario) throws SQLException {

        String insertarSQLUsuario = "INSERT INTO usuario VALUES(?, ?, ?)";

        try (Connection conexionBaseDeDatos = new ConexionBD().getConnection();
             PreparedStatement consultarInsertarUsuario = conexionBaseDeDatos.prepareStatement(insertarSQLUsuario)) {

            consultarInsertarUsuario.setInt(1, usuario.getIdUsuario());
            consultarInsertarUsuario.setString(2, usuario.getNombre());
            consultarInsertarUsuario.setString(3, usuario.getApellido());
            consultarInsertarUsuario.executeUpdate();
            return true;
        }
    }

    public boolean eliminarUsuario(int idUsuario) throws SQLException {

        String eliminarSQLUsuario = "DELETE FROM usuario WHERE idUsuario = ?";

        try (Connection conexionBaseDeDatos = new ConexionBD().getConnection();
             PreparedStatement consultarEliminarUsuario = conexionBaseDeDatos.prepareStatement(eliminarSQLUsuario)) {

            consultarEliminarUsuario.setInt(1, idUsuario);
            consultarEliminarUsuario.executeUpdate();
            return true;
        }
    }

    public boolean modificarUsuario(UsuarioDTO usuario) throws SQLException {

        String modificarSQLUsuario = "UPDATE usuario SET nombre = ?, apellidos = ? WHERE idUsuario = ?";

        try (Connection conexionBaseDeDatos = new ConexionBD().getConnection();
             PreparedStatement consultarModificarUsuario = conexionBaseDeDatos.prepareStatement(modificarSQLUsuario)) {

            consultarModificarUsuario.setInt(3, usuario.getIdUsuario());
            consultarModificarUsuario.setString(2, usuario.getApellido());
            consultarModificarUsuario.setString(1, usuario.getNombre());
            consultarModificarUsuario.executeUpdate();
            return true;
        }
    }

    public List<UsuarioDTO> consultarUsuario() throws SQLException {

        String consultarSQLUsuario = "SELECT * FROM usuario";
        List<UsuarioDTO> listaUsuarios = new ArrayList<>();

        try (Connection conexionBaseDeDatos = new ConexionBD().getConnection();
             PreparedStatement consultarUsuario = conexionBaseDeDatos.prepareStatement(consultarSQLUsuario)) {

            try (ResultSet resultado = consultarUsuario.executeQuery()) {

                while (resultado.next()) {

                    int id = resultado.getInt("idUsuario");
                    String nombre = resultado.getString("nombre");
                    String apellidos = resultado.getString("apellidos");

                    UsuarioDTO usuario = new UsuarioDTO(id, nombre, apellidos);
                    listaUsuarios.add(usuario);
                }
            }
        }

        return listaUsuarios;
    }
}