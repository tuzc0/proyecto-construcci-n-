package logica.interfaces;

import logica.usuariosDTO.AcademicoDTO;
import logica.usuariosDTO.AcademicoEvaluadorDTO;
import logica.usuariosDTO.EstudianteDTO;

import java.sql.SQLException;

public interface IAcademicoDAO {

    boolean insertarAcademico(AcademicoDTO academico) throws Exception;

    boolean eliminarAcademicoPorNumeroDePersonal(String numeroDePersonal) throws Exception;

    boolean modificarAcademico(AcademicoDTO academico) throws Exception;

    EstudianteDTO buscarAcademicoPorNumeroDePersonal(int numeroDePersonal) throws SQLException;
}
