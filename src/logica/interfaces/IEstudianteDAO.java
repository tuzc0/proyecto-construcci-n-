package logica.interfaces;

import logica.usuariosDTO.EstudianteDTO;

import java.util.List;

public interface IEstudianteDAO {

    boolean insertarEstudiante(EstudianteDTO estudiante) throws Exception;

    boolean eliminarEstudiantePorMatricula(String matricula) throws Exception;

    boolean modificarEstudiante(EstudianteDTO estudiante) throws Exception;

    List<EstudianteDTO> consultarEstudiante() throws Exception;
}
