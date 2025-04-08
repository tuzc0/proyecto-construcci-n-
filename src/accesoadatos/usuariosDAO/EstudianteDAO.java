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

        try {

            sentenciaEstudiante = conexionBaseDeDatos.prepareStatement(eliminarSQLEstudiante);
            sentenciaEstudiante.setString(1, matricula);
            sentenciaEstudiante.executeUpdate();
            return true;

        } catch (SQLException e) {

            throw new SQLException("Error al eliminar el estudiante: " + e.getMessage());
        }
    }

    public boolean modificarEstudiante(EstudianteDTO estudiante) throws SQLException {

        String modificarSQLEstudiante = "UPDATE estudiante SET idUsuario = ? WHERE matricula = ?";

        try {

            sentenciaEstudiante = conexionBaseDeDatos.prepareStatement(modificarSQLEstudiante);
            sentenciaEstudiante.setString(2, estudiante.getMatricula());
            sentenciaEstudiante.setInt(1, estudiante.getIdUsuario());
            sentenciaEstudiante.executeUpdate();
            return true;

        } catch (SQLException e) {

            throw new SQLException("Error al modificar el estudiante: " + e.getMessage());
        }
    }

}
