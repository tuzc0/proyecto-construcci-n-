package logica.interfaces;
import accesoadatos.usuariosDAO.UsuarioDAO;
import logica.usuariosDTO.EstudianteDTO;
import logica.usuariosDTO.UsuarioDTO;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDAO {

    public boolean insertarUsuario(UsuarioDTO usuario) throws SQLException;

    public boolean eliminarUsuarioPorID(int idUsuario) throws SQLException;

    public boolean modificarUsuario(UsuarioDTO usuario) throws SQLException;

    public List<UsuarioDTO> consultarUsuarios() throws SQLException;
}
