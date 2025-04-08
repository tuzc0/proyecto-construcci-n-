package accesoadatos.usuariosDAO;

import accesoadatos.ConexionBD;
import logica.interfaces.IEstudianteDAO;
import logica.usuariosDTO.EstudianteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO implements IEstudianteDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaEstudiante = null;
    ResultSet resultadoConsultaEstudiante;

    public boolean insertarEstudiante(EstudianteDTO estudiante) throws SQLException{

        String insertarSQLEstudiante = "INSERT INTO estudiante VALUES(?, ?)";

        try {
            sentenciaEstudiante = conexionBaseDeDatos.prepareStatement(insertarSQLEstudiante);

            sentenciaEstudiante.setString(1, estudiante.getMatricula());
            sentenciaEstudiante.setInt(2, estudiante.getIdUsuario());
            sentenciaEstudiante.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException("Error al insertar", e);
        }
    }


    public boolean eliminarEstudiantePorMatricula(String matricula) throws SQLException {

        String eliminarSQLEstudiante = "DELETE FROM estudiante WHERE matricula = ?";

        try (Connection conexionBaseDeDatos = new ConexionBD().getConnection();
             PreparedStatement consultarEliminarEstudiante = conexionBaseDeDatos.prepareStatement(eliminarSQLEstudiante)) {

            consultarEliminarEstudiante.setString(1, matricula);
            consultarEliminarEstudiante.executeUpdate();
            return true;
        }
    }

    public boolean modificarEstudiante(EstudianteDTO estudiante) throws SQLException {

        String modificarSQLEstudiante = "UPDATE estudiante SET idUsuario = ? WHERE matricula = ?";

        try (Connection conexionBaseDeDatos = new ConexionBD().getConnection();
             PreparedStatement consultarModificarEstudiante = conexionBaseDeDatos.prepareStatement(modificarSQLEstudiante)) {

            consultarModificarEstudiante.setString(2, estudiante.getMatricula());
            consultarModificarEstudiante.setInt(1, estudiante.getIdUsuario());
            consultarModificarEstudiante.executeUpdate();
            return true;
        }
    }

    public List<EstudianteDTO> consultarEstudiante() throws SQLException {

        String consultarSQLEstudiante = "SELECT * FROM estudiante";
        List<EstudianteDTO> listaEstudiantes = new ArrayList<>();

        try (Connection conexionBaseDeDatos = new ConexionBD().getConnection();
             PreparedStatement consultarEstudiante = conexionBaseDeDatos.prepareStatement(consultarSQLEstudiante);
             ResultSet resultadoConsulta = consultarEstudiante.executeQuery()) {

            while (resultadoConsulta.next()) {
                EstudianteDTO estudiante = new EstudianteDTO();
                estudiante.setMatricula(resultadoConsulta.getString("matricula"));
                estudiante.setIdUsuario(resultadoConsulta.getInt("idUsuario"));
                listaEstudiantes.add(estudiante);
            }
        }
        return listaEstudiantes;
    }
}
