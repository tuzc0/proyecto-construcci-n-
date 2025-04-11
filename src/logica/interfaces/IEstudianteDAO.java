package logica.interfaces;

import logica.usuariosDTO.EstudianteDTO;
import java.sql.SQLException;


public interface IEstudianteDAO {

    boolean insertarEstudiante(EstudianteDTO estudiante) throws Exception;

    boolean eliminarEstudiantePorMatricula(String matricula) throws Exception;

    boolean modificarEstudiante(EstudianteDTO estudiante) throws Exception;

    EstudianteDTO buscarEstudiantePorMatricula(String matricula) throws SQLException;
}
